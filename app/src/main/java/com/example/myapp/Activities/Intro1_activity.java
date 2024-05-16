package com.example.myapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapp.R;

public class Intro1_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.intro1);


//        // Find the ConstraintLayout containing the button
//        ConstraintLayout btnStartLayout = findViewById(R.id.btnStart);
//
//        // Find the TextView inside the ConstraintLayout
//        final TextView btnStart = btnStartLayout.findViewById(R.id.textView3);

        // Start Button
        final TextView btnStart = findViewById(R.id.textView3);

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro1_activity.this, Intro2_activity.class);
                startActivity(intent);
            }
        });
    }
}
