package com.example.myapp.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.NotificationCompat;

import com.example.myapp.R;

public class Setting_Activity extends AppCompatActivity {
    ImageView backBtn, rate, share, contact, info;
    SwitchCompat notification;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backBtn = findViewById(R.id.backBtn);
        // Settings
        rate = findViewById(R.id.rateNext);
        share = findViewById(R.id.shareNext);
        contact = findViewById(R.id.contactNext);
        notification = findViewById(R.id.notificationSwitch);
        info = findViewById(R.id.infoNext);
        // App Bar
        final ImageView btnHome = findViewById(R.id.home);
        final ImageView btnDiagnose = findViewById(R.id.diagnose);
        final ImageView btnHistory = findViewById(R.id.history);
        final ImageView btnSettings = findViewById(R.id.settings);

        final String appPackageName = getPackageName();

        // Click on Back Button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(Setting_Activity.this, AppInfo.class);
                startActivity(intentBack);
            }
        });

        // Click on Notification
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNotification = new Intent(Setting_Activity.this, Setting_Activity.class);
                startActivity(intentNotification);
            }
        });

        // Click on Rate
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRate = new Intent(Setting_Activity.this, RateDialog.class);
                startActivity(intentRate);
                // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id" + appPackageName)));
                RateDialog rateDialog = new RateDialog(Setting_Activity.this);
                rateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
                rateDialog.setCancelable(false);
                rateDialog.show();
            }
        });

        // Click on Share
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent();
                intentShare.setAction(Intent.ACTION_SEND);
                intentShare.putExtra(Intent.EXTRA_TEXT, "Check this App\n" + "https://play.google.com/store/apps/details?id" + appPackageName);
                intentShare.setType("text/plain");
                startActivity(Intent.createChooser(intentShare, "Share this app"));
            }
        });

        // Click on Contact us
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Click on App Info
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAppInfo = new Intent(Setting_Activity.this, AppInfo.class);
                startActivity(intentAppInfo);
            }
        });

        // Click on Home icon
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(Setting_Activity.this, home_activity.class);
                startActivity(intentHome);
            }
        });

        // Click on Diagnose icon
        btnDiagnose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDiagnose = new Intent(Setting_Activity.this, diagnose_activity.class);
                startActivity(intentDiagnose);
            }
        });

        // Click on History icon
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHistory = new Intent(Setting_Activity.this, History_activity.class);
                startActivity(intentHistory);
            }
        });

        // Click on Setting icon
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSettings = new Intent(Setting_Activity.this, Setting_Activity.class);
                startActivity(intentSettings);
            }
        });
    }

//    @SuppressLint("NewApi")
//    public void makeNotification(){
//        String channelID = "CHANNEL_ID_NOTIFICATION";
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelID);
//        builder.setSmallIcon(R.drawable.notifications_active)
//                .setContentText("Notification Title")
//                .setContentText("Some text for notification here.")
//                .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//        Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("data", "Some value to be passed here.");
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
//                0, intent, PendingIntent.FLAG_MUTABLE);
//        builder.setContentIntent(pendingIntent);
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.0){
//            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelID);
//            if (notificationChannel == null){
//                int importance = NotificationManager.IMPORTANCE_HIGH;
//                notificationChannel = new NotificationChannel(channelID, "Some description", importance);
//                notificationChannel.setLightColor(Color.BLUE);
//                notificationChannel.enableVibration(true);
//                notificationManager.createNotificationChannel(notificationChannel);
//            }
//        }
//
//        notificationManager.notify(0, builder.build());
//    }
}
