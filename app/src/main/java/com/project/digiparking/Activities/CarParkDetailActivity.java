package com.project.digiparking.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.digiparking.R;

public class CarParkDetailActivity extends AppCompatActivity {
    AppCompatButton booking;
    ImageView image;
    TextView amount;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_park_detail);

        booking= findViewById(R.id.book);
        image = findViewById(R.id.image_park);
        amount = findViewById(R.id.amount);
        name  = findViewById(R.id.parking_name);

        //get values from recyclerview
        name.setText(getIntent().getExtras().getString("title"));
        amount.setText(getIntent().getExtras().getString("amount"));
        Integer ImageUrl = getIntent().getIntExtra("image",0);
        image.setImageResource(ImageUrl);

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CarParkDetailActivity.this, BookingActivity.class));

            }
        });
    }
}