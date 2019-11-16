package com.example.me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.me.R;
import com.example.me.dao.calendar.BasicActivity;

public class SuccessPay extends AppCompatActivity {
    private Intent i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_pay);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        final String strCallback = bundle.getString("Callback");
        if (strCallback.equalsIgnoreCase("TopUp")){
            TextView lbl1 = findViewById(R.id.lbl1);
            lbl1.setText("Top Up Successfull");
            i = new Intent(SuccessPay.this, MainActivity.class);
        }
        else{
            i = new Intent(SuccessPay.this, BasicActivity.class);
        }
    }
    @Override
    public void onBackPressed() {
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
        startActivity(i);
        finish();
    }
}
