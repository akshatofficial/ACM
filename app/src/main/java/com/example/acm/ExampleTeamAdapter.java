package com.example.acm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleTeamAdapter extends RecyclerView.Adapter<ExampleTeamAdapter.ExampleTeamViewHolder> {
    private ArrayList<ExampleforTeam> mExampleList;

    public static class ExampleTeamViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView textName;
        public TextView positionName;


        public ExampleTeamViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.photo);
            textName = itemView.findViewById(R.id.nameTeam);
            positionName = itemView.findViewById(R.id.position);
        }
    }

    public ExampleTeamAdapter(ArrayList<ExampleforTeam> exampleList){
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exampleforteam, parent, false);
        ExampleTeamViewHolder evh = new ExampleTeamViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleTeamViewHolder holder, int position) {

        ExampleforTeam currentPos = mExampleList.get(position);
        holder.mImageView.setImageResource(currentPos.getmPhoto());
        holder.textName.setText(currentPos.getmName());
        holder.positionName.setText(currentPos.getmPosition());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

}
