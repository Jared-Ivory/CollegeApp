package com.apps.jivory.collegeapp.asynctasks;

import android.os.AsyncTask;

import com.apps.jivory.collegeapp.architecture.CollegeDao;


public class ClearCollegeDatabaseAsyncTask extends AsyncTask<Void, Void, Void> {
    private CollegeDao collegeDao;

    public ClearCollegeDatabaseAsyncTask(CollegeDao collegeDao){
        this.collegeDao = collegeDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        collegeDao.deleteAllColleges();
        return null;
    }
}
