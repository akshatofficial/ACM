package com.example.acm;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {

    public static LinkedHashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();
        final List<String> two, three, four, five, six, seven, eight;

        two = new ArrayList<>();
        three = new ArrayList<>();
        four = new ArrayList<>();
        five = new ArrayList<>();
        six = new ArrayList<>();
        seven = new ArrayList<>();
        eight = new ArrayList<>();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("EVENTS");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Events event = new Events();
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    event.setYear(ds.getValue(Events.class).getYear());
                    event.setTitle(ds.getValue(Events.class).getTitle());
                    String Year = event.getYear();
                    String Title = (String)event.getTitle();
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
                    else
                        two.add(Title);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        expandableListDetail.put("2020-2021", eight);
        expandableListDetail.put("2019-2020", seven);
        expandableListDetail.put("2018-2019", six);
        expandableListDetail.put("2017-2018", five);
        expandableListDetail.put("2016-2017", four);
        expandableListDetail.put("2015-2016", three);
        expandableListDetail.put("2014-2015", two);
        return expandableListDetail;

    }
}
