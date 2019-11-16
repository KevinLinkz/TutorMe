package com.example.me.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.me.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileDetailDescription extends Fragment {

    private View root;
    private String strDescription = "";

    public ProfileDetailDescription() {
        // Required empty public constructor
    }


    public ProfileDetailDescription(String strDescription) {
        this.strDescription = strDescription;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_profile_detail_description, null);
        TextView lblDescription = root.findViewById(R.id.lblDescription);
        lblDescription.setText(strDescription);
        return root;
    }



}
