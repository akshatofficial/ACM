package com.example.onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.acm.R;

public class SlideAdaptor extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdaptor(Context c){
        this.context = c;
    }

    public int slideImages[] = {
            R.drawable.events_logo,
            R.drawable.spo,
            R.drawable.team_logo,
            R.drawable.contact_us_logo
    };

    public String slide_heading[] = {
            "Events",
            "Sponsors",
            "Team",
            "Contact Us"
    };

    public String slide_descriptions[] = {
            "Here you will get to know about all events organised by the ACM club of IIT(ISM) Dhanbad.",
            "Here you will get to know about the sponsors who supports a lot in making our events successful",
            "Here you will get to know about the main reason of success of the ACM club, the TEAM",
            "Wanna contact us? We will be always here to help you!"
    };
    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideViewImage);
        TextView slideHeading = (TextView) view.findViewById(R.id.tag);
        TextView slideDescription = (TextView) view.findViewById(R.id.slideDescription);

        slideImageView.setImageResource(slideImages[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescription.setText(slide_descriptions[position]);

        container.addView(view);
        return view;
    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
