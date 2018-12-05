package com.apps.jivory.collegeapp.asynctasks;

import android.os.AsyncTask;

import com.apps.jivory.collegeapp.architecture.CollegeDao;
import com.apps.jivory.collegeapp.models.College;

/** Room doesn't allow database operations on main thread, thus we use async tasks
 *  An async task allows these operations to perform in the background.
 *  From Docs:
 *  Async<Params, Progress, Result>
 *      Params, the type of the parameters sent to the task upon execution.
 *      Progress, the type of the progress units published during the background computation.
 *      Result, the type of the result of the background computation.
 */

public class InsertCollegeAsyncTask extends AsyncTask<College, Void, Void> {
    private CollegeDao collegeDao;

    public InsertCollegeAsyncTask(CollegeDao collegeDao){
        this.collegeDao = collegeDao;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(College... colleges) {
        collegeDao.deleteAllColleges();
        collegeDao.insert(colleges);
        return null;
    }
}
