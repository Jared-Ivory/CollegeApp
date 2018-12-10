package com.apps.jivory.collegeapp.models;

import com.google.gson.annotations.SerializedName;

public class Metadata {
    @SerializedName("total")
    private int amtResults;
    @SerializedName("page")
    private int page;
    @SerializedName("per_page")
    private int per_page;

    public Metadata(int amtResults, int page, int per_page){
        this.amtResults = amtResults;
        this.page = page;
        this.per_page = per_page;
    }

    public int getAmtResults() {
        return amtResults;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }
}
