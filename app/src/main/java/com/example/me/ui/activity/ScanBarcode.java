package com.example.me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.me.R;
import com.example.me.dao.general.PERMISSION_ACCESS;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanBarcode extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_barcode);

//        getWindow().setStatusBarColor(@ColorInt);
        new PERMISSION_ACCESS(this,"Camera");
        mScannerView = (ZXingScannerView) this.findViewById(R.id.scanner);


    }
    @Override
    public void handleResult(Result result) {
        Toast.makeText(this, "Absent Successfull ! ", Toast.LENGTH_SHORT).show();

//        Toast.makeText(this, "Contents = " + result.getText() +
//                ", Format = " + result.getBarcodeFormat().toString(), Toast.LENGTH_SHORT).show();
        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mScannerView.resumeCameraPreview(ScanBarcode.this);
//            }
//        }, 2000);

        Intent i = new Intent(ScanBarcode.this, SuccessAttendance.class);
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }
}
