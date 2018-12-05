package com.apps.jivory.collegeapp.models;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "college_table")
public class College {
    @SerializedName("school.name")
    private String name;
    @PrimaryKey()
    @SerializedName("id")
    private int id;
    @SerializedName("school.school_url")
    private String schoolurl;
    @SerializedName("latest.admissions.sat_scores.25th_percentile.critical_reading")
    private float sat_scores25th;
    @SerializedName("latest.admissions.sat_scores.75th_percentile.critical_reading")
    private float sat_scores75th;



    public College(String name, int id, String schoolurl, float sat_scores25th, float sat_scores75th){
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolurl() {
        return schoolurl;
    }

    public void setSchoolurl(String schoolurl) {
        this.schoolurl = schoolurl;
    }

    public float getSat_scores75th() {
        return sat_scores75th;
    }

    public void setSat_scores75th(float sat_scores75th) {
        this.sat_scores75th = sat_scores75th;
    }

    public float getSat_scores25th() {
        return sat_scores25th;
    }

    public void setSat_scores25th(float sat_scores25th) {
        this.sat_scores25th = sat_scores25th;
    }
}
