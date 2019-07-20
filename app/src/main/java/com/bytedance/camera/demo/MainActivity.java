package com.bytedance.camera.demo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        final int REQUEST_PERMISSION_CODE = 1;
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_picture).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TakePictureActivity.class));
        });

        findViewById(R.id.btn_camera).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RecordVideoActivity.class));
        });

        findViewById(R.id.btn_custom).setOnClickListener(v -> {
            //todo 在这里申请相机、麦克风、存储的权限
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            startActivity(new Intent(MainActivity.this, CustomCameraActivity.class));


        });
    }

}
