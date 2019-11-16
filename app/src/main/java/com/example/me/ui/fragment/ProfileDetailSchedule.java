package com.example.me.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alamkanak.weekview.WeekView;
import com.example.me.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileDetailSchedule extends Fragment {

    private View root;
    private static final int TYPE_DAY_VIEW = 1;
    private static final int TYPE_THREE_DAY_VIEW = 2;
    private static final int TYPE_WEEK_VIEW = 3;
    private int mWeekViewType = TYPE_THREE_DAY_VIEW;
    private WeekView mWeekView;
    public ProfileDetailSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_profile_detail_schedule, container, false);
// Get a reference for the week view in the layout.
//        mWeekView = (WeekView) root.findViewById(R.id.weekView);
//
//// Set an action when any event is clicked.
//        mWeekView.setOnEventClickListener(mEventClickListener);
//
//// The week view has infinite scrolling horizontally. We have to provide the events of a
//// month every time the month changes on the week view.
//        mWeekView.setMonthChangeListener(mMonthChangeListener);
//
//// Set long press listener for events.
//        mWeekView.setEventLongPressListener(mEventLongPressListener);

        return root;
    }





}
