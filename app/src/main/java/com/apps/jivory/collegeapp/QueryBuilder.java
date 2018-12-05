package com.apps.jivory.collegeapp;

import android.util.Log;

import com.apps.jivory.collegeapp.models.CollegeField;
import com.apps.jivory.collegeapp.models.CollegeFilter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class QueryBuilder {
    private static final String TAG = "QUERYBUILDER";
    private Map<CollegeFilter, String> filters;
    private Set<CollegeField> fields;

    public QueryBuilder(){
        filters = new HashMap<>();
        fields = new TreeSet<>();
    }

    public QueryBuilder addFilter(CollegeFilter filter, String value){
        filters.put(filter,value);
        return this;
    }

    public QueryBuilder addField(CollegeField field){
        fields.add(field);
        return this;
    }

    public Set<CollegeField> getFields(){
        return fields;
    }

    public Map<CollegeFilter, String>  getFilters(){
        return filters;
    }

    public String getQuery(){
        String query = "_fields=";
        for(CollegeField field: fields){
            query+=field.toString()+",";
        }
        query = query.substring(0, query.length() -1);
        for(Map.Entry<CollegeFilter, String> entry : filters.entrySet()){
            query = query + "&"+entry.toString();
        }
        Log.d(TAG, query);
        return query;
    }
}
