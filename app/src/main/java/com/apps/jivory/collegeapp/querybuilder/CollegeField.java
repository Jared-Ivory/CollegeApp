package com.apps.jivory.collegeapp.querybuilder;

public enum CollegeField {
    ID("id"),
    SCHOOL_NAME("school.name"),
    CITY("school.city"),
    STATE("school.state"),
    ZIP("school.zip"),
    SATSCORES_READING_25TH("latest.admissions.sat_scores.25th_percentile.critical_reading"),
    SATSCORES_READING_75TH("latest.admissions.sat_scores.75th_percentile.critical_reading"),
    TUITION_IN_STATE("latest.cost.tuition.in_state"),
    TUITION_OUT_OF_STATE("latest.cost.tuition.out_of_state")
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
