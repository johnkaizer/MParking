package com.project.digiparking.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.digiparking.Authentication.SignInActivity;
import com.project.digiparking.MainActivity;
import com.project.digiparking.MapsActivity;
import com.project.digiparking.R;

public class CarParkDetailActivity extends AppCompatActivity {
    AppCompatButton booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_park_detail);
        booking= findViewById(R.id.book);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CarParkDetailActivity.this, MapsActivity.class));

            }
        });
    }
}