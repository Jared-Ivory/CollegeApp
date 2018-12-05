package com.apps.jivory.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apps.jivory.collegeapp.models.CollegeField;
import com.apps.jivory.collegeapp.models.CollegeFilter;
import com.apps.jivory.collegeapp.models.CollegeQuery;


public class MainActivity extends AppCompatActivity{

    private Repository repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repo = new Repository();

        QueryBuilder queryBuilder = new QueryBuilder();

        queryBuilder
                .addField(CollegeField.SCHOOLNAME)
                .addField(CollegeField.ID)
                .addFilter(CollegeFilter.DISTANCE, "10mi")
                .addFilter(CollegeFilter.ZIPCODE, "11713");

        final TextView t = findViewById(R.id.textview);
        t.setText(queryBuilder.getQuery());

        repo.searchCollegeScorecard(queryBuilder.getQuery());

        Button b = findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollegeQuery c = repo.getCollegeQuery();
                t.setText(c.getColleges().toString());
            }
        });


    }

}


