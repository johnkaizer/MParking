package com.project.digiparking.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.digiparking.Model.BookingModel;
import com.project.digiparking.R;

public class ConfirmingBooking extends AppCompatActivity {
    AppCompatButton proceedBtn;
    TextView location,parkingSpot,date,dateE,starTime,endTime,carModels,carPlate,amount;
    DatabaseReference dataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirming_booking);
        dataRef= FirebaseDatabase.getInstance().getReference().child("Ticket Bookings");
        proceedBtn = findViewById(R.id.submit_btn);
        location=findViewById(R.id.location_txt);
        location.setText(getIntent().getExtras().getString("place"));
        parkingSpot = findViewById(R.id.parking_spot);
//        location.setText(getIntent().getExtras().getString("place"));
        date = findViewById(R.id.date);
        date.setText(getIntent().getExtras().getString("date1"));
        dateE = findViewById(R.id.date1);
        dateE.setText(getIntent().getExtras().getString("date1"));
        starTime = findViewById(R.id.start_time);
        starTime.setText(getIntent().getExtras().getString("stTime"));
        endTime = findViewById(R.id.end_time);
        endTime.setText(getIntent().getExtras().getString("endTime"));
        carModels = findViewById(R.id.car_name);
        carPlate = findViewById(R.id.car_plate);
        amount=findViewById(R.id.amount_due);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBooking();
                String str = amount.getText().toString();
                Intent intent = new Intent(ConfirmingBooking.this, PaymentActivity.class);
                intent.putExtra("amount", str);
                startActivity(intent);
                finish();
            }
        });
    }

    private void saveBooking() {
        String ParkingLocation =  location.getText().toString();
        String ParkingSpot =  parkingSpot.getText().toString();
        String ParkingDate =  date.getText().toString();
        String StartTime =  starTime.getText().toString();
        String EndTime =  endTime.getText().toString();
        String CarModel =  carModels.getText().toString();
        String CarPlate =  carPlate.getText().toString();
        String ParkingAmount =  amount.getText().toString();


        BookingModel booking = new BookingModel(ParkingLocation,ParkingSpot,ParkingDate,StartTime,EndTime,CarModel,CarPlate,ParkingAmount);
        dataRef.push().setValue(booking);

    }
}