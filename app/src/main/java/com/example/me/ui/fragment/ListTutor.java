package com.example.me.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;

import com.example.me.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListTutor extends Fragment {


    public ListTutor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_list_tutor, null);

        //SEARCH VIEW
        SearchView searchView =  root.findViewById(R.id.srcListTutor);
        searchView.setFocusable(false);

        return root;
//        return inflater.inflate(R.layout.fragment_list_tutor, container, false);
    }

}
