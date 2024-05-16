package com.example.myapp.Activities;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_MEDIA_IMAGES;
import static android.Manifest.permission.READ_MEDIA_VIDEO;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapp.Adapters.getStarted_Adapter;
import com.example.myapp.Domains.getStarted_Domain;
import com.example.myapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class home_activity extends AppCompatActivity {
//    private static final int CAMERA_REQUEST_CODE = 102;
//    private static final int CAMERA_PERM_CODE = 101;
    static final int REQUEST_TAKE_PHOTO = 1;
    private RecyclerView.Adapter Adapter;
    private RecyclerView recyclerView;
    FloatingActionButton camera;
    private String currentPhotoPath;
    private ImageSwitcher selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

//        initRecyclerView();

        // App Bar
        ImageView btnHome = findViewById(R.id.home);
        ImageView btnDiagnose = findViewById(R.id.diagnose);
        camera = findViewById(R.id.camera);
        ImageView btnHistory = findViewById(R.id.history);
        ImageView btnSettings = findViewById(R.id.settings);


        // Click on Home icon
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(home_activity.this, home_activity.class);
                startActivity(intentHome);
            }
        });

        // Click on Diagnose icon
        btnDiagnose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDiagnose = new Intent(home_activity.this, diagnose_activity.class);
                startActivity(intentDiagnose);
            }
        });

//        // Click on Camera icon
//        camera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                askCameraPermissions();
//            }
//        });

        // Click on History icon
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHistory = new Intent(home_activity.this, History_activity.class);
                startActivity(intentHistory);
            }
        });

        // Click on Setting icon
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSettings = new Intent(home_activity.this, Setting_Activity.class);
                startActivity(intentSettings);
            }
        });
    }

//    // Access Camera and Gallery
//    private void askCameraPermissions() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
//        }else {
//            dispatchTakePictureIntent();
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == CAMERA_PERM_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                dispatchTakePictureIntent();
//            } else {
//                Toast.makeText(this, "Camera Permission is Required to Use Camera.", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == CAMERA_REQUEST_CODE) {
//            if (resultCode == Activity.RESULT_OK){
//                File f = new File(currentPhotoPath);
//                selectedImage.setImageURI(Uri.fromFile(f));
//            }
//        }
//    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {

            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }


    private void initRecyclerView() {
        ArrayList<getStarted_Domain> items = new ArrayList<>();
        items.add(new getStarted_Domain("", "", "", "", "", "", "", ""));
        items.add(new getStarted_Domain("", "", "", "", "", "", "", ""));
        items.add(new getStarted_Domain("", "", "", "", "", "", "", ""));
        items.add(new getStarted_Domain("", "", "", "", "", "", "", ""));
        items.add(new getStarted_Domain("", "", "", "", "", "", "", ""));

        recyclerView = findViewById(R.id.view_Pop);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        Adapter = new getStarted_Adapter(items);
        recyclerView.setAdapter(Adapter);

    }
}