package com.apps.jivory.collegeapp.querybuilder;

public enum CollegeFilter {
    ZIPCODE("_zip"),
    LONGATUDE("location.lat"),
    LATITUDE("location.lon"),
    DISTANCE("_distance");

    public String name;

    CollegeFilter(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
