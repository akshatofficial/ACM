package com.example.acm;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class past_events extends Fragment {
    /*List<String> childList;
    Map<String, List<String>> parentListItems;
    ExpandableListView expandableListView;

    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("EVENTS");
    List<String> parentList = new ArrayList<>();

    {
        parentList.add("2020-2021");
        parentList.add("2019-2020");
        parentList.add("2018-2019");
        parentList.add("2017-2018");
        parentList.add("2016-2017");
        parentList.add("2015-2016");
        parentList.add("2014-2015");
        parentList.add("2013-2014");
    }*/

    //ArrayList<String> one, two, three, four, five, six, seven, eight;
    //ArrayList<String> eight,six = null;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    LinkedHashMap<String, List<String>> expandableListDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_past_events, container, false);

        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(getContext(),DisplayPastEvents.class);
                intent.putExtra("PARENT",expandableListTitle.get(groupPosition));
                intent.putExtra("TITLE",expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition));
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                /*Toast.makeText(
                        getContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();*/
                return false;
            }
        });


        return view;
        /*parentListItems = new LinkedHashMap<>();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Events event = new Events();
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    event.setYear(ds.getValue(Events.class).getYear());
                    String Year = event.getYear().toString;
                    String Title = event.getTitle().toString;
                    if(Year.equals("2020"))
                        eight.add(Title);
                    else if(Year.equals("2019"))
                        seven.add(Title);
                    else if(Year.equals("2018"))
                        six.add(Title);
                    else if(Year.equals("2017"))
                        five.add(Title);
                    else if(Year.equals("2016"))
                        four.add(Title);
                    else if(Year.equals("2015"))
                        three.add(Title);
                    else if(Year.equals("2014"))
                        two.add(Title);
                    else
                        one.add(Title);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        for(String HoldItem: parentList)
        {
            if(HoldItem.equals("2020-2021"))
                loadChild(eight);
            else if(HoldItem.equals("2019-2020"))
                loadChild(seven);
            else if(HoldItem.equals("2018-2019"))
                loadChild(six);
            else if(HoldItem.equals("2017-2018"))
                loadChild(five);
            else if(HoldItem.equals("2016-2017"))
                loadChild(four);
            else if(HoldItem.equals("2015-2016"))
                loadChild(three);
            else if(HoldItem.equals("2014-2015"))
                loadChild(two);
            else
                loadChild(one);

            parentListItems.put(HoldItem,childList);

        }

        expandableListView = view.findViewById(R.id.expandableListView);
        final ExpandableListAdapter expandableListAdapter = new ListAdapter(getActivity(),parentList,parentListItems);
        expandableListView.setAdapter(expandableListAdapter);

        return view;
    }

    private void loadChild(ArrayList<String> parentElementNames)
    {
        childList = new ArrayList<>();
        String[] s1 = (String[]) parentElementNames.toArray();
        Collections.addAll(childList,s1);
    }*/
    }
}

