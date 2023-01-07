package com.project.digiparking.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.digiparking.Adapters.ParkingSlotsAdapter;
import com.project.digiparking.Model.ParkingSlotsModel;
import com.project.digiparking.R;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {
    RecyclerView slotsRec;
    ArrayList<ParkingSlotsModel> parkingSlotsModels;
    ParkingSlotsAdapter parkingSlotsAdapter ;
    TextView name,rate;
    AppCompatButton SubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        name = findViewById(R.id.place);
        rate = findViewById(R.id.amount);
        SubmitBtn = findViewById(R.id.book);
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookingActivity.this, ConfirmingBooking.class));

            }
        });

        slotsRec =findViewById(R.id.slots_RV);
        parkingSlotsModels =new ArrayList<>();

        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_1"));
        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_2"));
        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_3"));
        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_4"));
        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_5"));
        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_6"));
        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_7"));
        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_8"));
        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_9"));
        parkingSlotsModels.add(new ParkingSlotsModel( "PSK_10"));

        String title = getIntent().getStringExtra("name");
        name.setText(title);
        String amount = getIntent().getStringExtra("money");
        rate.setText(amount);

        parkingSlotsAdapter = new ParkingSlotsAdapter(this, parkingSlotsModels, this);
        slotsRec.setAdapter(parkingSlotsAdapter);
        slotsRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        slotsRec.setHasFixedSize(true);
        slotsRec.setNestedScrollingEnabled(false);
    }
}