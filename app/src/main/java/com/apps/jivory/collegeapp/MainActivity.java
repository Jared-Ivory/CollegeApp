package com.apps.jivory.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apps.jivory.collegeapp.models.College;
import com.apps.jivory.collegeapp.models.CollegeField;
import com.apps.jivory.collegeapp.models.CollegeFilter;
import com.apps.jivory.collegeapp.models.CollegeQuery;
import com.apps.jivory.collegeapp.viewmodels.MainViewModel;
import com.facebook.stetho.Stetho;


public class MainActivity extends AppCompatActivity{
    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** initializes stetho */
        Stetho.initializeWithDefaults(this);


        mainViewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);

        QueryBuilder queryBuilder = new QueryBuilder();

        queryBuilder
                .addField(CollegeField.SCHOOLNAME)
                .addField(CollegeField.ID)
                .addField(CollegeField.SATSCORES_READING_75TH)
                .addField(CollegeField.SATSCORES_READING_25TH)
                .addFilter(CollegeFilter.DISTANCE, "20mi")
                .addFilter(CollegeFilter.ZIPCODE, "11713");

        final TextView t = findViewById(R.id.textview);
        t.setText(queryBuilder.getQuery());

        mainViewModel.searchCollegeScorecard(queryBuilder.getQuery());

        Button b = findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}


