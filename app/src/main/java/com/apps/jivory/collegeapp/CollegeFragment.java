package com.apps.jivory.collegeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.jivory.collegeapp.models.College;
import com.apps.jivory.collegeapp.models.CollegeAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CollegeFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private CollegeAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_college, container, false);
        adapter = new CollegeAdapter();

        recyclerView = view.findViewById(R.id.recyclerView_College);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


        return view;
    }



    public void setAdapter(CollegeAdapter adapter){
        this.adapter = adapter;
        recyclerView.setAdapter(adapter);
    }

    public void setColleges(List<College> colleges){
        adapter.setColleges(colleges);
    }



}
