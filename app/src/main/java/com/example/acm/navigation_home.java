package com.example.acm;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class navigation_home extends Fragment implements View.OnClickListener {



    CarouselView carouselView;
    TextView aboutAcmHeader, titleRecentAchieve, titleRecentEvents;
    int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    NavController navController;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        aboutAcmHeader = view.findViewById(R.id.aboutACMHeader);
        titleRecentAchieve = view.findViewById(R.id.title3);
        titleRecentEvents = view.findViewById(R.id.title1);
        aboutAcmHeader.setPaintFlags(aboutAcmHeader.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        titleRecentAchieve.setPaintFlags(titleRecentAchieve.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        titleRecentEvents.setPaintFlags(titleRecentEvents.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        navController= Navigation.findNavController(view);
        view.findViewById(R.id.fab_achievements).setOnClickListener(this);
        view.findViewById(R.id.fab_events).setOnClickListener(this);
        view.findViewById(R.id.fab_team).setOnClickListener(this);

        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.fab_achievements :
                navController.navigate(R.id.action_navigation_home_to_navigation_achievements);
                break;
            case R.id.fab_events :
                navController.navigate(R.id.action_navigation_home_to_navigation_event);
                break;
            case R.id.fab_team :
                navController.navigate(R.id.action_navigation_home_to_navigation_team);
                break;
        }

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}