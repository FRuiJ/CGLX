package com.example.materialtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class VehicleActivity extends AppCompatActivity {

    public static final String VEHICLE_NAME = "vehicle_name";
    public static final String VEHICLE_IMAGE_ID = "vehicle_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        Intent intent = getIntent();
        String vehicleName = intent.getStringExtra(VEHICLE_NAME);
        int vehicleImageId = intent.getIntExtra(VEHICLE_IMAGE_ID, 0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView vehicleImageView = findViewById(R.id.vehicle_image_view);
        TextView vehicleContentText = findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(vehicleName);
        Glide.with(this).load(vehicleImageId).into(vehicleImageView);
        String vehicleContent = generateFruitContent(vehicleName);
        vehicleContentText.setText(vehicleContent);
    }

    private String generateFruitContent(String vehicleName) {
        StringBuilder vehicleContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            vehicleContent.append(vehicleName);
        }
        return vehicleContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}