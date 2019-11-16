package com.example.me.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.me.R;
import com.example.me.ui.activity.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Account extends Fragment {

    private View root;

    public Account() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment]
        root = inflater.inflate(R.layout.fragment_account, container, false);
        TextView lblLogout = root.findViewById(R.id.lblLogout);
        lblLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(root.getContext(), "Logout Application", Toast.LENGTH_LONG).show();
//                Intent i = new Intent(LoginActivity.this, BasicActivity.class);
                Intent i = new Intent(root.getContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        return root;
    }

}
