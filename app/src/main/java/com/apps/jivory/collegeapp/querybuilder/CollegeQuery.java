package com.apps.jivory.collegeapp.querybuilder;

import com.apps.jivory.collegeapp.models.College;
import com.apps.jivory.collegeapp.models.Metadata;
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

    public void addColleges(List<College> colleges){
        for(College c: colleges){
            this.colleges.add(c);
        }
    }

    public Metadata getMetadata() {
        return metadata;
    }
}
