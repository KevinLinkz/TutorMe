package com.example.me.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.me.R;
import com.example.me.ui.activity.PinWallet;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletTopUp extends Fragment {

    private View root;
    public WalletTopUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_wallet_top_up, container, false);

        //BUTTON
        Button btnTopUp = root.findViewById(R.id.btnTopUp);
        btnTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), PinWallet.class)
                        .putExtra("Callback","TopUp");
                startActivity(i);
            }
        });
        return root;
    }

}
