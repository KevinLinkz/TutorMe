package com.example.me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.me.R;

public class Receipt extends AppCompatActivity {

    private final Bundle args = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        Bundle bundle = getIntent().getExtras();
        TextView lbl2 = findViewById(R.id.lbl2);
        TextView lbl3 = findViewById(R.id.lbl3);
        TextView lbl4 = findViewById(R.id.lbl4);
        TextView lbl5 = findViewById(R.id.lbl5);
        TextView lbl6 = findViewById(R.id.lbl6);
        TextView lbl7 = findViewById(R.id.lbl7);
        TextView lbl8 = findViewById(R.id.lbl8);
        TextView lbl9 = findViewById(R.id.lbl9);

        lbl2.setText("Type Tutor = " + bundle.getString("Type"));
        lbl3.setText("Subject       = "+bundle.getString("Subject"));
        lbl4.setText("Repeat        = "+bundle.getString("Repeat"));
        if (!bundle.getString("Type").equalsIgnoreCase("Trial")){
            lbl5.setText("Price            = "+bundle.getString("Price"));
            lbl9.setText("Total           = "+bundle.getString("Total"));
        }else{
            lbl5.setText("Price            = Free");
            lbl9.setText("Total           = Free");
        }

        lbl6.setText("Date            = "+bundle.getString("Date"));
        lbl7.setText("Time            = "+bundle.getString("Time"));
        lbl8.setText("Location     =  "+bundle.getString("Location"));


        Button btnPay = findViewById(R.id.btnPay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Receipt.this,PinWallet.class)
                        .putExtra("Callback","Pay");
                startActivity(i);
            }
        });
    }
}
