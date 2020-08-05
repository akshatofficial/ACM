package com.example.acm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class navigation_team extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_team, container, false);
        ArrayList<ExampleforTeam> exampleList = new ArrayList<>();
        exampleList.add(new ExampleforTeam(R.drawable.swapnil, "Swapnil Narayan", "ChairMan ACM IIT(ISM) Dhanbad"));
        exampleList.add(new ExampleforTeam(R.drawable.abhishekraj, "Abhishek Raj", "Vice Chair ACM IIT(ISM) Dhanbad"));
        exampleList.add(new ExampleforTeam(R.drawable.shailsiyag, "Sahil Siyag", "Secretary And Management Head"));
        exampleList.add(new ExampleforTeam(R.drawable.samirjain, "Sameer Jain", "Treasurer"));
        exampleList.add(new ExampleforTeam(R.drawable.satyavart, "Satyavart", "Membership Chair"));
        exampleList.add(new ExampleforTeam(R.drawable.prince, "Prince Kumar", "PR Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.dhyeysir, "Dhyey Mistry", "Tech Head"));
        exampleList.add(new ExampleforTeam(R.drawable.ishanthapa, "Ishan Thapa", "Promotion Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.akashkulsh, "Akash Kulshreshtha", "Designing Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.adityashivas, "Aditya Shrivastav", "Sponsor Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.madhavaggar, "Madhav Aggarwal", "Content Writing Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.avinashsir, "Avinash", "Campus Ambassador Program Head"));
        exampleList.add(new ExampleforTeam(R.drawable.rashmikiranpandit, "Rashmikiran Pandit", "Sponsor Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.subhagyata, "Subhagyata Swaraj Jaiswal", "Content Writing and Promotion Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.saurabh, "Saurabh Raj", "Designing Team Head"));
        ExampleTeamAdapter adapter = new ExampleTeamAdapter(exampleList);
        mRecyclerView = view.findViewById(R.id.recyclerViewTeam);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setAdapter(adapter);

        return view;
    }
}