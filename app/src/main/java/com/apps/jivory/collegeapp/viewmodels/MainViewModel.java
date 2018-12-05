package com.apps.jivory.collegeapp.viewmodels;

import android.app.Application;

import com.apps.jivory.collegeapp.architecture.Repository;
import com.apps.jivory.collegeapp.models.College;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {
    private Repository repo;
    private LiveData<List<College>> allColleges;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repo = new Repository(application);

        allColleges = repo.getAllColleges();
    }

    public void searchCollegeScorecard(String query){
        repo.searchCollegeScorecard(query);
    }

    public LiveData<List<College>> getAllColleges() {
        return allColleges;
    }
}
