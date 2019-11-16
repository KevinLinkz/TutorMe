package com.example.me.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.me.R;
import com.example.me.dao.calendar.BasicActivity;
import com.example.me.ui.activity.MainActivity;
import com.example.me.ui.activity.ScanBarcode;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    private int[] mImages = new int[]{
            R.raw.image1,
            R.raw.image2,
            R.raw.image3,
            R.raw.image4,
            R.raw.image5
    };
    private String[] mTitle = new String[]{
            "Buah1",
            "Buah2",
            "Buah3",
            "Buah4",
            "Buah5"
    };
    private ViewGroup root;
    private boolean isParent = false;
    public Home() {
        // Required empty public constructor
    }

    public Home(boolean isParent) {
       this.isParent = isParent;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = (ViewGroup) inflater.inflate(R.layout.fragment_home, null);

        //SEARCH VIEW
        SearchView searchView = root.findViewById(R.id.srcMain);
        searchView.setFocusable(false);


        CarouselView crsView = root.findViewById(R.id.crd_promo);
        crsView.setPageCount(mImages.length);
        crsView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);

            }
        });
        crsView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
//                Toast.makeText(root.getContext(), mTitle[position], Toast.LENGTH_LONG).show();

            }
        });
        //BUTTON
        Button btnAttendance = (Button) root.findViewById(R.id.btn_attendance);
        btnAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(root.getContext(), "Scan Absent Barcode", Toast.LENGTH_LONG).show();
                Intent i = new Intent(root.getContext(), ScanBarcode.class);
                startActivity(i);
            }
        });

        Button btnReschedule = (Button) root.findViewById(R.id.btn_reschedule);
        btnReschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(root.getContext(), "Reschedule Event", Toast.LENGTH_LONG).show();
                Intent i = new Intent(root.getContext(), BasicActivity.class);
                startActivity(i);
            }
        });
        Button btn_reschedule_parent = (Button) root.findViewById(R.id.btn_reschedule_parent);
        btn_reschedule_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(root.getContext(), "Reschedule Event", Toast.LENGTH_LONG).show();
                Intent i = new Intent(root.getContext(), BasicActivity.class);
                startActivity(i);
            }
        });
        Button btn_wallet_top_up = (Button) root.findViewById(R.id.btn_wallet_top_up);
        btn_wallet_top_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(root.getContext(), MainActivity.class)
                        .putExtra("Fragment","TopUp");
                startActivity(i);
            }
        });
        Button btn_wallet_history = (Button) root.findViewById(R.id.btn_wallet_history);
        btn_wallet_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(root.getContext(), MainActivity.class)
                        .putExtra("Fragment","History");
                startActivity(i);
            }
        });
        //IS PARENT
        TextView lbl_schedule = root.findViewById(R.id.lbl_schedule);

        if (isParent){

            btn_reschedule_parent.setVisibility(View.VISIBLE);
            lbl_schedule.setText("Schedule of son");
            btnAttendance.setVisibility(View.INVISIBLE);
            btnReschedule.setVisibility(View.INVISIBLE);
        }else{
            btn_reschedule_parent.setVisibility(View.GONE);
        }
        return root;
//        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
