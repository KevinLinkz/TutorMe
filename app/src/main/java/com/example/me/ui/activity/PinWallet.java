package com.example.me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.me.R;
import com.hanks.passcodeview.PasscodeView;

public class PinWallet extends AppCompatActivity {
    private PasscodeView pinWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_wallet);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        final String strCallback = bundle.getString("Callback");
        pinWallet = findViewById(R.id.pinWallet);
        pinWallet.setPasscodeLength(4)
                .setLocalPasscode("1234")
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {
                        Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSuccess(String number) {
                        Intent i = new Intent(PinWallet.this, SuccessPay.class);
                        i.putExtra("Callback", strCallback);
                        startActivity(i);
                    }
                });
        if (strCallback.equalsIgnoreCase("TopUp")) {

            pinWallet.setFirstInputTip("Enter pin M-BCA to verify payment");
        } else {

            pinWallet.setFirstInputTip("Enter pin to verify payment");
        }
    }
}
