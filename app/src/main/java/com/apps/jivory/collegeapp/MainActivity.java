package com.apps.jivory.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apps.jivory.collegeapp.models.College;
import com.apps.jivory.collegeapp.querybuilder.CollegeField;
import com.apps.jivory.collegeapp.querybuilder.CollegeFilter;
import com.apps.jivory.collegeapp.viewmodels.MainViewModel;
import com.facebook.stetho.Stetho;

import java.util.List;
import java.util.stream.Collectors;


public class MainActivity extends AppCompatActivity{
    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** initializes stetho */
        Stetho.initializeWithDefaults(this);


        mainViewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);

        final QueryBuilder queryBuilder = new QueryBuilder();

        queryBuilder
                .addField(CollegeField.SCHOOL_NAME)
                .addField(CollegeField.ID)
                .addField(CollegeField.SATSCORES_READING_75TH)
                .addField(CollegeField.SATSCORES_READING_25TH)
                .addField(CollegeField.CITY)
                .addField(CollegeField.STATE)
                .addField(CollegeField.TUITION_IN_STATE)
                .addField(CollegeField.TUITION_OUT_OF_STATE)
                ;

        final TextView t = findViewById(R.id.textview);
        final EditText editTextZipcode = findViewById(R.id.editText_zipcode);
        final EditText editTextDistance = findViewById(R.id.editText_distance);


        Button search = findViewById(R.id.search_btn
        );
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryBuilder.addFilter(CollegeFilter.DISTANCE, editTextDistance.getText().toString() + "mi");
                queryBuilder.addFilter(CollegeFilter.ZIPCODE, editTextZipcode.getText().toString());
                mainViewModel.searchCollegeScorecard(queryBuilder.getQuery());
            }
        });

        mainViewModel.getAllColleges().observe(MainActivity.this, new Observer<List<College>>() {
            @Override
            public void onChanged(List<College> colleges) {
                String s = "";

                /** Can use lambda functions to filter collections
                 * i.e.
                 * colleges = colleges.stream().filter(p -> p.getSat_scores25th() > 200).collect(Collectors.toList()); */
                for(College c: colleges){
                    s+=c.prettyString()+"\n";
                }
                t.setText(s);
            }
        });


    }

}


