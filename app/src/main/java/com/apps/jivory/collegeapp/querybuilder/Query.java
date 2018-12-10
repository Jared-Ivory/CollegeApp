package com.apps.jivory.collegeapp.querybuilder;

import com.apps.jivory.collegeapp.asynctasks.CSCQueryTask;

import java.util.Map;
import java.util.Set;

public class Query {
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


}
