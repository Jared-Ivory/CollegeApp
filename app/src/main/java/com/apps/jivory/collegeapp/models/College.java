package com.apps.jivory.collegeapp.models;

import com.google.gson.annotations.SerializedName;

public class College {
    @SerializedName("school.name")
    private String name;
    @SerializedName("id")
    private int id;
    @SerializedName("school.school_url")
    private String schoolurl;
    @SerializedName("latest.admissions.sat_scores.75th_percentile.critical_reading")
    private float sat_scores75th;
    @SerializedName("latest.admissions.sat_scores.25th_percentile.critical_reading")
    private float sat_scores25th;



    public College(String name, int id, String schoolurl, float sat_scores25th, float sats_cores75th){
        this.name = name;
        this.id = id;
        this.schoolurl = schoolurl;
        this.sat_scores25th = sat_scores25th;
        this.sat_scores75th = sat_scores75th;
    }

    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", schoolurl='" + schoolurl + '\'' +
                ", satscores75th=" + sat_scores75th +
                ", satscores25th=" + sat_scores25th +
                '}';
    }
}
