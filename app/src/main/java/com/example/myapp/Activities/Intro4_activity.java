package com.example.myapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapp.R;

public class Intro4_activity extends Activity {

    @Override
    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.intro4);

        // Next Button
        final TextView btnStart = findViewById(R.id.textView3);

        btnStart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro4_activity.this, home_activity.class);
                startActivity(intent);
            }
        });
    }
}
