package com.apps.jivory.collegeapp.models;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.CollegeHolder> {

    @NonNull
    @Override
    public CollegeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CollegeHolder extends RecyclerView.ViewHolder {

        public CollegeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
