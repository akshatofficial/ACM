package com.example.acm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DisplayPastEvents extends AppCompatActivity {
    TextView title,description;
    ImageView image;
    String Title1 , Parent1, Year1;
    DatabaseReference myRef;
    Query query;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_events);
        Intent intent = getIntent();
        Parent1 = intent.getStringExtra("PARENT");
        Title1 = intent.getStringExtra("TITLE").trim();
        Year1=Parent1.substring(0,4);

        title=findViewById(R.id.textViewTitle);
        description=findViewById(R.id.textViewDescription);
        image=findViewById(R.id.imageViewDisplay);

        myRef = FirebaseDatabase.getInstance().getReference().child("EVENTS");
        query = myRef.orderByChild("year").equalTo(Year1);


        /*Query query = myRef.orderByChild("year").equalTo(Year);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Events event = new Events();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    event=ds.getValue(Events.class);

                    if (event.getTitle().trim().equals(Title))
                    {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                            }
                        }, 1000);

                        Description = event.getDescription();
                        ImageURL = event.getImageURL();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/


        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Events event1 = ds.getValue(Events.class);
                    assert event1 != null;
                    if(event1.getTitle().equals(Title1))
                    {
                        String url = ds.child("imageURL").getValue(String.class);
                        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("IMAGES/").child(url);
                        GlideApp.with(getApplicationContext())
                                .load(storageReference)
                                .into(image);
                        title.setText(Title1);
                        description.setText(ds.child("description").getValue(String.class));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
