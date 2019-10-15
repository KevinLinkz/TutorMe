package com.example.me.dao;

import android.Manifest;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

public class PERMISSION_ACCESS {
    private static final int CAMERA_REQUEST = 1888;
    private static final int GALLERY_REQUEST = 1889;

    public PERMISSION_ACCESS(FragmentActivity fragmentActivity,String permission) {
        switch (permission){

            case "Camera" :
                RequestPermissions(fragmentActivity,Manifest.permission.CAMERA,CAMERA_REQUEST);
                break;
        }


    }

    public void RequestPermissions(FragmentActivity fragmentActivity,String manifest,int requestCode) {
        if (ContextCompat.checkSelfPermission(fragmentActivity,
                manifest)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(fragmentActivity,
                    new String[]{manifest}, requestCode);
        }
    }

}
