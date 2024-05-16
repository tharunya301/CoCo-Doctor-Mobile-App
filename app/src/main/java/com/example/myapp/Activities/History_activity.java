package com.example.myapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;

public class History_activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // App Bar
        final ImageView btnHome = findViewById(R.id.home);
        final ImageView btnDiagnose = findViewById(R.id.diagnose);
        final ImageView btnHistory = findViewById(R.id.history);
        final ImageView btnSettings = findViewById(R.id.settings);

        // Click on Home icon
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(History_activity.this, home_activity.class);
                startActivity(intentHome);
            }
        });

        // Click on Diagnose icon
        btnDiagnose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDiagnose = new Intent(History_activity.this, diagnose_activity.class);
                startActivity(intentDiagnose);
            }
        });

        // Click on History icon
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHistory = new Intent(History_activity.this, History_activity.class);
                startActivity(intentHistory);
            }
        });

        // Click on Setting icon
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSettings = new Intent(History_activity.this, Setting_Activity.class);
                startActivity(intentSettings);
            }
        });
    }
}
