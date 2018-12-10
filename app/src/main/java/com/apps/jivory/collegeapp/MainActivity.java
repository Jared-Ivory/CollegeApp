package com.apps.jivory.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apps.jivory.collegeapp.models.College;
import com.apps.jivory.collegeapp.models.CollegeAdapter;
import com.apps.jivory.collegeapp.querybuilder.CollegeField;
import com.apps.jivory.collegeapp.querybuilder.CollegeFilter;
import com.apps.jivory.collegeapp.viewmodels.MainViewModel;
import com.facebook.stetho.Stetho;

import java.util.List;
import java.util.stream.Collectors;


public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private CollegeFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** initializes stetho */
        Stetho.initializeWithDefaults(this);
        mainViewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);

        QueryBuilder queryBuilder = QueryBuilder.DEFAULT;
        Button search = findViewById(R.id.search_btn);

        TextView t = findViewById(R.id.textview);
        EditText editTextZipcode = findViewById(R.id.editText_zipcode);
        EditText editTextDistance = findViewById(R.id.editText_distance);

        fragment = new CollegeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();

        search.setOnClickListener(v -> {
            queryBuilder.addFilter(CollegeFilter.DISTANCE, editTextDistance.getText().toString() + "mi");
            queryBuilder.addFilter(CollegeFilter.ZIPCODE, editTextZipcode.getText().toString());
            mainViewModel.searchCollegeScorecard(queryBuilder.createQuery());
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        mainViewModel.getAllColleges().observe(this, new Observer<List<College>>() {
            @Override
            public void onChanged(List<College> colleges) {
                fragment.setColleges(colleges);
            }
        });
    }
}


