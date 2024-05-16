package com.example.myapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapp.R;

public class Intro3_activity extends Activity {

    @Override
    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.intro3);

        // Next Button
        final TextView btnStart = findViewById(R.id.textView3);

        btnStart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro3_activity.this, Intro4_activity.class);
                startActivity(intent);
            }
        });
    }
}
