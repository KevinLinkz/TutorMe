package com.example.me.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.me.R;
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

    public Home() {
        // Required empty public constructor
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
                Toast.makeText(root.getContext(), mTitle[position], Toast.LENGTH_LONG).show();

            }
        });

        return root;
//        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
