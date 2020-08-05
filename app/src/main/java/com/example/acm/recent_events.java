package com.example.acm;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class recent_events extends Fragment {

    RecyclerView recyclerView;
    static ProgressBar bar;
    DatabaseReference myRef;
    Query query;
    List<Events> mList;
    //ListView listView;
    //FirebaseListAdapter<Events> listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recent_events, container, false);
        myRef = FirebaseDatabase.getInstance().getReference().child("EVENTS");
        query = myRef.orderByChild("year").limitToLast(10);
        query.keepSynced(true);
        bar = v.findViewById(R.id.progressBar);
        bar.setVisibility(View.VISIBLE);

        /*listView = (ListView) v.findViewById(R.id.recyclerView);

        myRef = FirebaseDatabase.getInstance().getReference().child("EVENTS");

        listAdapter = new FirebaseListAdapter <Events>(getActivity(), Events.class, R.layout.event_model, myRef) {
            TextView textViewTitle;
            TextView textViewDate;

            protected void populateView(View v, Events model, int position)
            {
                textViewTitle = (TextView) v.findViewById(R.id.recent_title);
                textViewDate = (TextView) v.findViewById(R.id.recent_date);

                textViewTitle.setText(model.getTitle());
                textViewDate.setText(model.getDate());

            }
        };
        listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
        myRef.keepSynced(true);*/

        recyclerView =(RecyclerView) v.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Events, EventsViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Events, EventsViewHolder>
                (Events.class,R.layout.event_model,EventsViewHolder.class,query) {
            @Override
            protected void populateViewHolder(EventsViewHolder eventsViewHolder, final Events events, int i) {

                eventsViewHolder.setTitle(events.getTitle());
                eventsViewHolder.setDate(events.getDate());
                eventsViewHolder.setImage(events.getImageURL());
                eventsViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getContext(),DisplayEvents.class);
                        intent.putExtra("IMAGEURL",events.getImageURL());
                        intent.putExtra("TITLE",events.getTitle());
                        intent.putExtra("DESCRIPTION",events.getDescription());

                        startActivity(intent);
                    }
                });
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public EventsViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setTitle(String title)
        {
            TextView textViewTitle = (TextView)mView.findViewById(R.id.recent_title);
            textViewTitle.setText(title);
        }
        public void setDate(String date)
        {
            TextView textViewDate = (TextView)mView.findViewById(R.id.recent_date);
            textViewDate.setText(date);
        }
        public void setImage(final String imageUrl)
        {
            bar.setVisibility(View.GONE);
            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("IMAGES/").child(imageUrl);
            ImageView imageViewRecent = (ImageView)mView.findViewById(R.id.recent_image);
            GlideApp.with(mView.getContext())
                    .load(storageReference)
                    .into(imageViewRecent);
        }
    }
}