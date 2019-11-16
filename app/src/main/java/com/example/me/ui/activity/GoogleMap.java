package com.example.me.ui.activity;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.me.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class GoogleMap extends FragmentActivity implements OnMapReadyCallback {

    com.google.android.gms.maps.GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {
        map = googleMap;
        LatLng sentul = new LatLng(-6.586392, 106.881820);
        map.addMarker(new MarkerOptions().position(sentul).title("BLI Learning Institute"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sentul));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }


}
