package com.project.digiparking.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.digiparking.MainActivity;
import com.project.digiparking.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void password(View view) {
    }

    public void login(View view) {
        startActivity(new Intent(SignInActivity.this, MainActivity.class));
        finish();
    }

    public void sign_Up(View view) {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
        finish();
    }
}