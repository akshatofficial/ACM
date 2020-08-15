package com.example.acm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class navigation_team extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView email, linkedIn;
    final ArrayList<Pair<String, String>> l = new ArrayList<Pair <String, String>>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_team, container, false);
        View view1 = inflater.inflate(R.layout.exampleforteam, container, false);
        email = view1.findViewById(R.id.logoEmail);
        linkedIn = view1.findViewById(R.id.logoLinkedIn);
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


        l.add(new Pair<String, String> ("swapism7@gmail.com", "https://www.linkedin.com/in/swapzism/"));
        l.add(new Pair<String, String> ("abhishekraj29011998@gmail.com", "https://www.linkedin.com/in/abhishek-raj-permani-495483156/"));
        l.add(new Pair<String, String>("sahilsiyag88@gmail.com", "https://www.linkedin.com/in/sahil-siyag-4aa893191/"));
        l.add(new Pair<String, String>("sameer2000jain12@gmail.com", "https://www.linkedin.com/in/sameer-jain-882589158/"));
        l.add(new Pair<String, String>("", "https://www.linkedin.com/in/satyavart-b8630b173/"));
        l.add(new Pair<String, String>("princegup678@gmail.com", "https://www.linkedin.com/in/princegup678/"));
        l.add(new Pair<String, String>("dhyeybm@gmail.com", "https://www.linkedin.com/in/dhyey-mistry-859177177/"));
        l.add(new Pair<String, String>("ishanthapa2607@gmail.com", "https://www.linkedin.com/in/ishan-thapa-426722194/"));
        l.add(new Pair<String, String>("", "https://www.linkedin.com/in/akash-kulshrestha-262458134/"));
        l.add(new Pair<String, String>("", "https://www.linkedin.com/in/aditya-shrivastav-b6003517a/"));
        l.add(new Pair<String, String>("Madhav.21.2k@gmail.com", "https://www.linkedin.com/in/madhav-agarwal-021a55180/"));
        l.add(new Pair<String, String>("avinash21997@gmail.com", "https://www.linkedin.com/in/avinash-b904a8194/"));
        l.add(new Pair<String, String>("panditrk2000@gmail.com", "https://www.linkedin.com/in/rashmikiran-pandit-358196189/"));
        l.add(new Pair<String, String>("Shubhagytaswaraj@gmail.com", "https://www.linkedin.com/in/shubhagyta-395ab4185/"));
        l.add(new Pair<String, String>("saurabhraj.18je0747@pe.iitism.ac.in", "https://www.linkedin.com/in/saurabh-raj-aab418184/"));

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition =  mRecyclerView.getChildLayoutPosition(v);
                Pair<String, String> url = l.get(itemPosition);
                String emailUrl = url.first;
                if(emailUrl.length() != 0) {
                    startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + emailUrl)));
                }
            }
        });

        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition =  mRecyclerView.getChildLayoutPosition(v);
                Pair<String, String> url = l.get(itemPosition);
                String linkedInUrl = url.second;
                startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + linkedInUrl)));
            }
        });

        return view;
    }
}