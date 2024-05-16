package com.example.myapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapp.R;

public class Intro2_activity extends Activity {

    @Override
    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.intro2);

        // Next Button
        final TextView btnNext = findViewById(R.id.textView3);

            btnNext.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intro2_activity.this, Intro3_activity.class);
                    startActivity(intent);
                }
            });
    }
}