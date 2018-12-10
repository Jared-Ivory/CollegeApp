package com.apps.jivory.collegeapp;

import android.util.Log;

import com.apps.jivory.collegeapp.querybuilder.CollegeField;
import com.apps.jivory.collegeapp.querybuilder.CollegeFilter;
import com.apps.jivory.collegeapp.querybuilder.Query;

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

    public Query createQuery(){
        return new Query(filters, fields);
    }

    public static final QueryBuilder DEFAULT =
            new QueryBuilder().addField(CollegeField.SCHOOL_NAME)
                    .addField(CollegeField.ID)
                    .addField(CollegeField.SATSCORES_READING_75TH)
                    .addField(CollegeField.SATSCORES_READING_25TH)
                    .addField(CollegeField.CITY)
                    .addField(CollegeField.STATE)
                    .addField(CollegeField.TUITION_IN_STATE)
                    .addField(CollegeField.TUITION_OUT_OF_STATE);
}
