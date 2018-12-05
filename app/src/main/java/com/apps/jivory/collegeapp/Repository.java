package com.apps.jivory.collegeapp;

import com.apps.jivory.collegeapp.asynctasks.CSCQueryTask;
import com.apps.jivory.collegeapp.models.CollegeQuery;
import com.apps.jivory.collegeapp.models.CollegeScorecardResponse;

public class Repository {
    private static final String ROOT_URL = "https://api.data.gov/ed/collegescorecard/v1/schools.json?";
    private static final String API_KEY = "71T6y50gHU9RdxbXzBOzcRX93kSMYZqr1p6gV6De";

    private static CollegeQuery collegeQuery = null;

    public void searchCollegeScorecard(String query){
        query = ROOT_URL + query + "&api_key=" + API_KEY;
        new CSCQueryTask(new CollegeScorecardResponse() {
            @Override
            public void processFinish(CollegeQuery collegeQuery) {
                //Gets result from query
                Repository.collegeQuery = collegeQuery;
            }
        }).execute(query);
    }


    public CollegeQuery getCollegeQuery(){
        return collegeQuery;
    }
}
