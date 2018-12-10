package com.apps.jivory.collegeapp.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import com.apps.jivory.collegeapp.R;
import com.apps.jivory.collegeapp.models.Metadata;
import com.apps.jivory.collegeapp.querybuilder.CollegeQuery;
import com.apps.jivory.collegeapp.models.CollegeScorecardResponse;
import com.apps.jivory.collegeapp.querybuilder.Query;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CSCQueryTask extends AsyncTask<Query, Void, CollegeQuery> {
    private static final String ROOT_URL = "https://api.data.gov/ed/collegescorecard/v1/schools.json?";
    private static final String API_KEY = "71T6y50gHU9RdxbXzBOzcRX93kSMYZqr1p6gV6De";

    public CollegeScorecardResponse response;

    public CSCQueryTask(CollegeScorecardResponse response){
        this.response = response;
    }

    private CollegeQuery result;

    @Override
    protected CollegeQuery doInBackground(Query... queries) {
        try {
            Gson gson = new Gson();


            Query query = queries[0];
            query.setPage(0);
            query.setPerPage(20);

            /** */
            URL url = new URL(query.getQuery(0));
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setRequestMethod("GET");

            int responsecode = httpsURLConnection.getResponseCode();
            Log.d("CSCQueryTask",String.valueOf(responsecode) + ", " + query.getQuery(0));

            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            result = gson.fromJson(bufferedReader, CollegeQuery.class);

            Metadata metadata = result.getMetadata();
            query.setTotalResults(metadata.getAmtResults());
            if(query.getTotalPages()>= 1) {
                for (int i = 1; i < query.getTotalPages(); i++) {
                    /** Hard Limit**/
                    if(i==2){
                        break;
                    }
                    url = new URL(query.getQuery(i));
                    httpsURLConnection = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection.setRequestMethod("GET");

                    responsecode = httpsURLConnection.getResponseCode();
                    Log.d("CSCQueryTask",String.valueOf(responsecode) + ", " + query.getQuery(0));

                    inputStream = httpsURLConnection.getInputStream();
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    CollegeQuery r = gson.fromJson(bufferedReader, CollegeQuery.class);
                    result.addColleges(r.getColleges());
                }
            }

            return result;
        } catch (MalformedURLException e) {
            Log.d("CSCQueryTask","malformnedurl");
        } catch (IOException e) {
            Log.d("CSCQueryTask",e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(CollegeQuery collegeQuery) {
        super.onPostExecute(collegeQuery);
        try {
            Log.d("CSCQueryTask", collegeQuery.getColleges().toString());
            response.processFinish(collegeQuery);
        } catch (NullPointerException e){
            Log.d("CSCQueryTask", "Uh oh");
        }
    }
}
