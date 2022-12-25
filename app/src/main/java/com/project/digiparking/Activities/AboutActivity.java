package com.project.digiparking.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.digiparking.R;

public class AboutActivity extends AppCompatActivity {
    TextView details,details1,details2;
    LinearLayout layout,layout1,layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        details = findViewById(R.id.mparking_details);
        layout = findViewById(R.id.linear);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        details1 = findViewById(R.id.mparking_details1);
        layout1 = findViewById(R.id.linear1);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        details2 = findViewById(R.id.mparking_details2);
        layout2= findViewById(R.id.linear2);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }

    public void expand(View view) {
        int v = (details.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details.setVisibility(v);
    }

    public void expand2(View view) {
        int v = (details2.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details2.setVisibility(v);
    }

    public void expand1(View view) {
        int v = (details1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details1.setVisibility(v);
    }
}