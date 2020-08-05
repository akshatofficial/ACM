package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity {

    Handler handler;

    Animation topAnim, bottomAnim;
    ImageView logo;
    CardView des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        logo = (ImageView) findViewById(R.id.logo_id);
        des = (CardView) findViewById(R.id.des);

        logo.setAnimation(topAnim);
        des.setAnimation(bottomAnim);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }

        }, 2000);

    }
}

