package com.project.digiparking.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.digiparking.Model.User;
import com.project.digiparking.R;

public class ProfileActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView fullNameTxt = findViewById(R.id.user_name);
        final TextView emailTxt = findViewById(R.id.user_email);
        final TextView phoneTxt = findViewById(R.id.user_phone);
        final TextView passwordTxt = findViewById(R.id.user_pass);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile !=null){
                    String fullName = userProfile.fullName;
                    String email = userProfile.email;
                    String phone = userProfile.phone;
                    String password = userProfile.password;


                    fullNameTxt.setText(fullName);
                    emailTxt.setText(email);
                    phoneTxt.setText(phone);
                    passwordTxt.setText(password);

                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(ProfileActivity.this,"Something wrong happened!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}