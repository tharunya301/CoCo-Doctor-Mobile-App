package com.example.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapp.Domains.getStarted_Domain;
import com.example.myapp.R;

public class detail_activity extends AppCompatActivity {
    private TextView titleText, subtitle1Text, description1Text, subtitle2Text, description2Text, subtitle3Text, description3Text;
    private getStarted_Domain item;
    private ImageView picImg, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        
        initView();
        setVariable();
    }

    private void setVariable() {
        item = (getStarted_Domain) getIntent().getSerializableExtra("object");

        titleText.setText(item.getTitle());
        subtitle1Text.setText(item.getSubtitle1Text());
        description1Text.setText(item.getDescription1Text());
        subtitle2Text.setText(item.getSubtitle2Text());
        description2Text.setText(item.getDescription2Text());
        subtitle3Text.setText(item.getSubtitle3Text());
        description3Text.setText(item.getDescription3Text());

        int drawableResId = getResources().getIdentifier(item.getPicPath(),"design1", getPackageName());

        Glide.with(this).load(drawableResId).into(picImg);

        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        titleText = findViewById(R.id.titleText);
        subtitle1Text = findViewById(R.id.subtitle1Text);
        description1Text = findViewById(R.id.description1Text);
        subtitle2Text = findViewById(R.id.subtitle2Text);
        description2Text = findViewById(R.id.description2Text);
        subtitle3Text = findViewById(R.id.subtitle3Text);
        description3Text = findViewById(R.id.description3Text);
        picImg = findViewById(R.id.picImg);
        backBtn = findViewById(R.id.backBtn);

//        title
//        location
//        bed
//        guide
//        wifi
//        description
//        score
//        picImg
//        backBtn
    }
}