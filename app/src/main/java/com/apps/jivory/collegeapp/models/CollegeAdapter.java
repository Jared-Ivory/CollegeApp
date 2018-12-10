package com.apps.jivory.collegeapp.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.jivory.collegeapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.CollegeHolder> {
    private List<College> colleges = new ArrayList<>();

    @NonNull
    @Override
    public CollegeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View collegeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.college, parent, false);
        // binds the view holder to the view
        return new CollegeHolder(collegeView);
    }


    /**
     Once the view holder is bound to the view of the college you can manipulate
     the layout resource file and bind data to it.
     */
    @Override
    public void onBindViewHolder(@NonNull CollegeHolder holder, int position) {
        College college = colleges.get(position);

        holder.textViewName.setText(college.getName());
        holder.textViewID.setText(String.valueOf(college.getId()));
        holder.textViewSatScore_25th.setText(String.valueOf(college.getSat_scores25th()));
        holder.textViewSatScore_75th.setText(String.valueOf(college.getSat_scores75th()));
        holder.textViewInStateTuition.setText(String.valueOf(college.getIn_state_tuition()));
        holder.textViewOutOfStateTuition.setText(String.valueOf(college.getOut_of_state_tuition()));

    }

    @Override
    public int getItemCount() {
        return colleges.size();
    }

    public void  setColleges(List<College> colleges){
        this.colleges = colleges;
        notifyDataSetChanged();
    }

    class CollegeHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewID;
        private TextView textViewSatScore_25th;
        private TextView textViewSatScore_75th;
        private TextView textViewInStateTuition;
        private TextView textViewOutOfStateTuition;

        public CollegeHolder(@NonNull View itemView){
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textView_Name);
            this.textViewID = itemView.findViewById(R.id.textView_ID);
            this.textViewSatScore_25th = itemView.findViewById(R.id.textView_SATScores25th);
            this.textViewSatScore_75th = itemView.findViewById(R.id.textView_SATScores75th);
            this.textViewInStateTuition = itemView.findViewById(R.id.textView_InStateTuition);
            this.textViewOutOfStateTuition = itemView.findViewById(R.id.textView_OutOfStateTuition);
        }

    }
}
