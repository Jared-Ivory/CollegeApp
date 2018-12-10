package com.apps.jivory.collegeapp.querybuilder;

import android.util.Log;

import com.apps.jivory.collegeapp.asynctasks.CSCQueryTask;

import java.util.Map;
import java.util.Set;

public class Query {
    public static final String TAG = "QUERY";

    private String url;
    private String apikey;
    private int page;
    private int per_page;
    private int totalresults;
    private int tot_pages;

    private Map<CollegeFilter, String> filters;
    private Set<CollegeField> fields;

    public Query(Map<CollegeFilter, String> filters, Set<CollegeField> fields) {
        this.filters = filters;
        this.fields = fields;
        this.page = 0;
        this.per_page = 20;
    }

    public int getTotalPages(){
        return totalresults/per_page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return per_page;
    }

    public void setPerPage(int per_page) {
        this.per_page = per_page;
    }

    public int getTotalResults() {
        return totalresults;
    }

    public void setTotalResults(int totalresults) {
        this.totalresults = totalresults;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getQuery(int i){
        String query = url;
        query += "_page=" + i;
        query += "&fields=";
        for(CollegeField field: fields){
            query+=field.toString()+",";
        }
        query = query.substring(0, query.length() -1);
        for(Map.Entry<CollegeFilter, String> entry : filters.entrySet()){
            query = query + "&"+entry.toString();
        }
        query+= "&api_key=" + apikey;
        Log.d(TAG, query);
        return query;
    }

}
