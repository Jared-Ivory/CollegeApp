package com.apps.jivory.collegeapp.models;

public enum CollegeField {
    ID("id"),
    SCHOOLNAME("school.name"),
    CITY("school.city"),
    STATE("school.state"),
    ZIP("school.zip")
    ;

    public String name;

    CollegeField(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
