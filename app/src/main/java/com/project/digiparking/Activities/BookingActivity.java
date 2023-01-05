package com.project.digiparking.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.digiparking.ParkingSlotsAdapter;
import com.project.digiparking.ParkingSlotsModel;
import com.project.digiparking.R;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {
    RecyclerView slotsRec;
    ArrayList<ParkingSlotsModel> parkingSlotsModels;
    ParkingSlotsAdapter parkingSlotsAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

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

        parkingSlotsAdapter = new ParkingSlotsAdapter(this, parkingSlotsModels, this);
        slotsRec.setAdapter(parkingSlotsAdapter);
        slotsRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        slotsRec.setHasFixedSize(true);
        slotsRec.setNestedScrollingEnabled(false);
    }
}