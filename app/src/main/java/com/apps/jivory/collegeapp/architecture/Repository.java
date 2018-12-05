package com.apps.jivory.collegeapp.architecture;

import android.app.Application;

import com.apps.jivory.collegeapp.architecture.CollegeDao;
import com.apps.jivory.collegeapp.architecture.CollegeDatabase;
import com.apps.jivory.collegeapp.asynctasks.CSCQueryTask;
import com.apps.jivory.collegeapp.asynctasks.ClearCollegeDatabaseAsyncTask;
import com.apps.jivory.collegeapp.asynctasks.InsertCollegeAsyncTask;
import com.apps.jivory.collegeapp.models.College;
import com.apps.jivory.collegeapp.models.CollegeQuery;
import com.apps.jivory.collegeapp.models.CollegeScorecardResponse;

import java.util.List;

public class Repository {
    private static final String ROOT_URL = "https://api.data.gov/ed/collegescorecard/v1/schools.json?";
    private static final String API_KEY = "71T6y50gHU9RdxbXzBOzcRX93kSMYZqr1p6gV6De";

    private CollegeDao collegeDao;

    public  Repository(Application application){
        CollegeDatabase db = CollegeDatabase.getInstance(application.getApplicationContext());
        this.collegeDao = db.collegeDao();
    }

    public void searchCollegeScorecard(String query){
        query = ROOT_URL + query + "&api_key=" + API_KEY;
        new CSCQueryTask(new CollegeScorecardResponse() {
            @Override
            public void processFinish(CollegeQuery collegeQuery) {
                /** Recieves the results of a valid query */
                addColleges(collegeQuery);
            }
        }).execute(query);
    }


    private void addColleges(CollegeQuery collegeQuery){
        List<College> colleges = collegeQuery.getColleges();
        new InsertCollegeAsyncTask(collegeDao).execute(colleges.toArray(new College[0]));
    }
}
