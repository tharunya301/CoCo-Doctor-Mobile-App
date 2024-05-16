package com.example.myapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Adapters.diagnose_Adapter;
import com.example.myapp.Domains.diagnose_Domain;
import com.example.myapp.Domains.getStarted_Domain;
import com.example.myapp.R;

import java.util.ArrayList;

public class diagnose_activity extends AppCompatActivity {
    private RecyclerView.Adapter diagnose_Adapter;
    private RecyclerView recyclerView_diagnose;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagnose);
        initRecyclerView();
        // App Bar
        ImageView btnHome = findViewById(R.id.home);
        ImageView btnDiagnose = findViewById(R.id.diagnose);
        ImageView btnHistory = findViewById(R.id.history);
        ImageView btnSettings = findViewById(R.id.settings);

        // Click on Home icon
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(diagnose_activity.this, home_activity.class);
                startActivity(intentHome);
            }
        });

        // Click on Diagnose icon
        btnDiagnose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDiagnose = new Intent(diagnose_activity.this, diagnose_activity.class);
                startActivity(intentDiagnose);
            }
        });

        // Click on History icon
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHistory = new Intent(diagnose_activity.this, History_activity.class);
                startActivity(intentHistory);
            }
        });

        // Click on Setting icon
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSettings = new Intent(diagnose_activity.this, Setting_Activity.class);
                startActivity(intentSettings);
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<diagnose_Domain> items = new ArrayList<>();
        items.add(new diagnose_Domain("", "", "", "", "", "", "", ""));
        items.add(new diagnose_Domain("", "", "", "", "", "", "", ""));
        items.add(new diagnose_Domain("", "", "", "", "", "", "", ""));
        items.add(new diagnose_Domain("", "", "", "", "", "", "", ""));
        items.add(new diagnose_Domain("", "", "", "", "", "", "", ""));

        recyclerView_diagnose = findViewById(R.id.view_Cat);
        recyclerView_diagnose.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        diagnose_Adapter = new diagnose_Adapter(items);
        recyclerView_diagnose.setAdapter(diagnose_Adapter);
    }
}
