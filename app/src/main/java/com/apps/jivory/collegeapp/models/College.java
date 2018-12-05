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
    @SerializedName("latest.cost.tuition.in_state")
    private int in_state_tuition;
    @SerializedName("latest.cost.tuition.out_of_state")
    private int out_of_state_tuition;



    public College(String name, int id, String schoolurl, float sat_scores25th, float sat_scores75th, int in_state_tuition, int out_of_state_tuition){
        this.name = name;
        this.id = id;
        this.schoolurl = schoolurl;
        this.sat_scores25th = sat_scores25th;
        this.sat_scores75th = sat_scores75th;
        this.in_state_tuition = in_state_tuition;
        this.out_of_state_tuition = out_of_state_tuition;
    }

    public String prettyString() {
        return name + "\n" +
                "id:" + id + "\n" +
                "schoolurl:'" + schoolurl + '\'' + "\n" +
                "sat_scores25th:" + sat_scores25th + "\n" +
                "sat_scores75th:" + sat_scores75th + "\n" +
                "in_state_tuition:" + in_state_tuition + "\n" +
                "out_of_state_tuition:" + out_of_state_tuition + "\n\n";
    }

    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", schoolurl='" + schoolurl + '\'' +
                ", sat_scores25th=" + sat_scores25th +
                ", sat_scores75th=" + sat_scores75th +
                ", in_state_tuition=" + in_state_tuition +
                ", out_of_state_tuition=" + out_of_state_tuition +
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

    public int getIn_state_tuition() {
        return in_state_tuition;
    }

    public void setIn_state_tuition(int in_state_tuition) {
        this.in_state_tuition = in_state_tuition;
    }

    public int getOut_of_state_tuition() {
        return out_of_state_tuition;
    }

    public void setOut_of_state_tuition(int out_of_state_tuition) {
        this.out_of_state_tuition = out_of_state_tuition;
    }
}
