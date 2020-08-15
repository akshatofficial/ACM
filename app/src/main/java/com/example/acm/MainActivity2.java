package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private com.example.acm.SlideAdaptor slideAdaptor;

    private TextView[] mDots;

    private Button next, prev;
    private int mCurrentButton;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //checkFirstOpen();
        viewPager = (ViewPager)findViewById(R.id.slideViewPager);
        //linearLayout = (LinearLayout)findViewById(R.id.dotsView);
        relativeLayout = findViewById(R.id.relativeLayoutOnBoard);
        next = (Button)findViewById(R.id.next_button);
        next.setBackgroundColor(Color.rgb(247, 131, 131));
        prev = (Button)findViewById(R.id.previous_button);
        slideAdaptor = new com.example.acm.SlideAdaptor(this);
        viewPager.setAdapter(slideAdaptor);
        //addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mCurrentButton + 1);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mCurrentButton - 1);
            }
        });
    }


/*public void addDotsIndicator(int position){
        mDots = new TextView[4];
        linearLayout.removeAllViews();
        for(int i = 0;i < mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorDots));
            linearLayout.addView(mDots[i]);
        }
        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorChange));
        }
    }*/

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
           //addDotsIndicator(position);

            mCurrentButton = position;
            if(position == 0){
                relativeLayout.setBackgroundColor(Color.rgb(247, 131, 131));
                next.setBackgroundColor(Color.rgb(247, 131, 131));
                prev.setBackgroundColor(Color.rgb(247, 131, 131));
            }else if(position == 1){
                relativeLayout.setBackgroundColor(Color.parseColor("#A8E6CF"));
                next.setBackgroundColor(Color.parseColor("#A8E6CF"));
                prev.setBackgroundColor(Color.parseColor("#A8E6CF"));
            }else if(position == 2){
                relativeLayout.setBackgroundColor(Color.parseColor("#84A9AC"));
                next.setBackgroundColor(Color.parseColor("#84A9AC"));
                prev.setBackgroundColor(Color.parseColor("#84A9AC"));
            }else if(position == 3){
                relativeLayout.setBackgroundColor(Color.parseColor("#B2EBF2"));
                next.setBackgroundColor(Color.parseColor("#B2EBF2"));
                prev.setBackgroundColor(Color.parseColor("#B2EBF2"));
            }

            if(position == 0){
                //next.setVisibility(View.INVISIBLE);
                prev.setVisibility(View.INVISIBLE);
                prev.setEnabled(false);
                next.setEnabled(true);
                next.setText("Next");
            }else if(position == 3){
                prev.setEnabled(true);
                next.setEnabled(true);
                next.setText("Finish");
                //next.setVisibility(View.INVISIBLE);
                prev.setVisibility(View.VISIBLE);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity2.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }else{
                prev.setVisibility(View.VISIBLE);
                prev.setEnabled(true);
                next.setEnabled(true);
                next.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}