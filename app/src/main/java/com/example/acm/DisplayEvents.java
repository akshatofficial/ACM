package com.example.acm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;
import com.hanks.htextview.scale.ScaleText;
import com.hanks.htextview.scale.ScaleTextView;

public class DisplayEvents extends AppCompatActivity {

    TextView title,description;
    ImageView image;
    String imageUrl,Title,Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_events);
        Intent intent = getIntent();
        imageUrl = intent.getStringExtra("IMAGEURL");
        Title = intent.getStringExtra("TITLE");
        Description = intent.getStringExtra("DESCRIPTION");

        title=findViewById(R.id.textViewTitle);
        description=findViewById(R.id.textViewDescription);
        image=findViewById(R.id.imageViewDisplay);

        title.setText(Title);
        description.setText(Description);
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("IMAGES/").child(imageUrl);
        GlideApp.with(this)
                .load(storageReference)
                .into(image);
    }
}