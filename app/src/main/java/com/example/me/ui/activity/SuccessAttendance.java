package com.example.me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.me.R;

public class SuccessAttendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_attendance);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(SuccessAttendance.this, MainActivity.class);
        startActivity(i);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        jump();
        return true;
    }
    private void jump() {
        if (isFinishing())
            return;
        Intent i = new Intent(SuccessAttendance.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
