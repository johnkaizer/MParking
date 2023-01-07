package com.project.digiparking.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.digiparking.R;

public class ConfirmingBooking extends AppCompatActivity {
    AppCompatButton proceedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirming_booking);
        proceedBtn = findViewById(R.id.submit_btn);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmingBooking.this, PaymentActivity.class));
            }
        });
    }
}