package com.project.digiparking.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.project.digiparking.Adapters.ParkingSlotsAdapter;
import com.project.digiparking.Model.ParkingSlotsModel;
import com.project.digiparking.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class BookingActivity extends AppCompatActivity {
    RecyclerView slotsRec;
    ArrayList<ParkingSlotsModel> parkingSlotsModels;
    ParkingSlotsAdapter parkingSlotsAdapter ;
    TextView name,rate,dateTxt,durationTxt;
    AppCompatButton SubmitBtn;
    TimePickerDialog sPicker,ePicker;
    EditText startTime, endTime;
    CalendarView CalV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        name = findViewById(R.id.place);
        rate = findViewById(R.id.amount);
        startTime = findViewById(R.id.park_time);
        endTime = findViewById(R.id.park_time1);
        SubmitBtn = findViewById(R.id.book);
        dateTxt = findViewById(R.id.today_date);
        durationTxt = findViewById(R.id.duration);
        CalV = findViewById(R.id.calendar_CV);
        CalV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = month+"/"+dayOfMonth+"/"+year;
                dateTxt.setText(date);

            }
        });
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = rate.getText().toString();
                String sTime = startTime.getText().toString();
                String eTime = endTime.getText().toString();
                String location = name.getText().toString();
                String date = dateTxt.getText().toString();
                Intent intent = new Intent(BookingActivity.this, ConfirmingBooking.class);
                intent.putExtra("amount", str);
                intent.putExtra("stTime", sTime);
                intent.putExtra("endTime", eTime);
                intent.putExtra("place", location);
                intent.putExtra("date1", date);
                startActivity(intent);
                finish();

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
        //picking start time
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour= calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);

                sPicker = new TimePickerDialog(BookingActivity.this,  new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format= new SimpleDateFormat("k:mm a");
                        String time= format.format(c.getTime());
                        startTime.setText(time);

                    }
                },hour, min,false);
                sPicker.show();
            }
        });
        //picking end time
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour= calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);

                ePicker = new TimePickerDialog(BookingActivity.this,  new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format= new SimpleDateFormat("k:mm a");
                        String time= format.format(c.getTime());
                        endTime.setText(time);

                    }
                },hour, min,false);
                ePicker.show();
            }
        });
    }
}