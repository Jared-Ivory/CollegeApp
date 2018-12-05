package com.apps.jivory.collegeapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollegeQuery {
    @Expose
    @SerializedName("metadata")
    private Metadata metadata;
    @Expose
    @SerializedName("results")
    private List<College> colleges;

    public CollegeQuery(Metadata metadata, List<College> colleges){
        this.metadata = metadata;
        this.colleges = colleges;
    }

    public List<College> getColleges(){
        return colleges;
    }

}
