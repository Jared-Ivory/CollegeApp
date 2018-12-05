package com.apps.jivory.collegeapp.viewmodels;

import android.app.Application;

import com.apps.jivory.collegeapp.architecture.Repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {
    private Repository repo;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repo = new Repository(application);
    }

    public void searchCollegeScorecard(String query){
        repo.searchCollegeScorecard(query);
    }


}
