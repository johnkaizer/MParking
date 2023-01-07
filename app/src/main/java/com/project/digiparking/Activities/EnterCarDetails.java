package com.project.digiparking.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.project.digiparking.MainActivity;
import com.project.digiparking.R;

public class EnterCarDetails extends AppCompatActivity {
    EditText EdCar,EdType,EdColor,EdPlate;
    ImageView imageV;
    AppCompatButton submitBtn,uploadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_car_details);
        EdCar = findViewById(R.id.car_name);
        EdType = findViewById(R.id.car_type);
        EdColor = findViewById(R.id.car_color);
        EdPlate = findViewById(R.id.car_plate);
        imageV = findViewById(R.id.car_image);
        submitBtn = findViewById(R.id.submit_btn);
        uploadBtn = findViewById(R.id.car_btn);

        SharedPreferences preference= getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        String FirstTime= preference.getString("FirstTimeInstall","");
        if (FirstTime.equals("Yes")){
            Intent intent=new Intent(   EnterCarDetails.this, MainActivity.class);
            startActivity(intent);
            finish();

        }else {
            SharedPreferences.Editor editor= preference.edit();
            editor.putString("FirstTimeInstall","Yes");
            editor.apply();


        }
    }
}