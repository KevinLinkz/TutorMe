package com.example.me.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.me.R;
import com.example.me.dao.general.schedule.ScheduleHistoryRecycleViewAdapter;
import com.example.me.dao.general.schedule.SchedulePendingRecycleViewAdapter;
import com.example.me.dao.general.schedule.ScheduleUpcomingRecycleViewAdapter;
import com.example.me.dao.general.tutorMe.TutorItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
    public class Schedule extends Fragment {

    private View root;
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mLayoutManager;

    public Schedule() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = (View) inflater.inflate(R.layout.fragment_schedule, null);

        //SEARCH VIEW
        SearchView searchView =  root.findViewById(R.id.srcHome);
        searchView.setFocusable(false);

        //TAB NAVIGATION
        TabLayout tabLayout = root.findViewById(R.id.tabSchedule);
        mRecycler = root.findViewById(R.id.rcySchedule);
        mRecycler.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(root.getContext());
        mRecycler.setLayoutManager(mLayoutManager);

        loadSchedulePending();
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                Toast.makeText(root.getContext(), "" + tab.getPosition(), Toast.LENGTH_LONG).show();
                    switch (tab.getPosition()){
                        case 0:
                            loadSchedulePending();
                            break;
                        case 1:
                            loadScheduleUpcoming();

                            break;
                        case 2:
                            loadScheduleHistory();

                            break;

                        default:
                            break;

                    }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    public void loadSchedulePending()
    {
        ArrayList<TutorItem> tutorItems = new ArrayList<>();
        tutorItems.add(new TutorItem(R.raw.pp1,"1", "Kevin Hertanto", 1000, 4.2,"2 Session","Math","Taman Baca Senopati, Jakarta","Lulusan terbaik dari kampus ternama di Jakarta 2015. Mengikuti semua pelatihan dan mendapatkan sertifikan yang terbaik."));
        tutorItems.add(new TutorItem(R.raw.pp2,"2", "Dudung", 1000, 2.2,"1 Session","Biology","Taman Baca Senopati, Jakarta","Lulusan terbaik dari kampus ternama di Jakarta 2015. Mengikuti semua pelatihan dan mendapatkan sertifikan yang terbaik."));
        tutorItems.add(new TutorItem(R.raw.pp3,"3", "Dadang", 2000, 3.8,"1 Session","Dance","Taman Baca Senopati, Jakarta","Lulusan terbaik dari kampus ternama di Jakarta 2015. Mengikuti semua pelatihan dan mendapatkan sertifikan yang terbaik."));

        SchedulePendingRecycleViewAdapter mSchedulePendingAdapter = new SchedulePendingRecycleViewAdapter(tutorItems);
        mRecycler.setAdapter(mSchedulePendingAdapter);
    }

    public void loadScheduleUpcoming()
    {
        ArrayList<TutorItem> tutorItems = new ArrayList<>();
        tutorItems.add(new TutorItem(R.raw.pp1,"1", "Kevin Hertanto", 1000, 4.2,"2 Session","Math","4 November 2019", "2-4 PM","Taman Baca Senopati, Jakarta",false));
        tutorItems.add(new TutorItem(R.raw.pp2,"2", "Dudung", 1000, 2.2,"1 Session","Biology","5 November 2019", "2-3 PM","Taman Jombloo, Jakarta",true));

        ScheduleUpcomingRecycleViewAdapter mScheduleUpcomingAdapter = new ScheduleUpcomingRecycleViewAdapter(tutorItems);
        mRecycler.setAdapter(mScheduleUpcomingAdapter);
    }

    public void loadScheduleHistory()
    {
        ArrayList<TutorItem> tutorItems = new ArrayList<>();
        tutorItems.add(new TutorItem(R.raw.pp4,"1", "Kevin Hertanto", 1000, 4.2,"2 Session","Math","1 November 2019", "9-10 AM","Jln Kamboja 5AB, Tomang Jakarta Barat"));
        tutorItems.add(new TutorItem(R.raw.pp1,"2", "Dudung", 1000, 2.2,"1 Session","Biology","2 November 2019", "10-11 AM","Lipo Mall Puri, Jakarta"));

        ScheduleHistoryRecycleViewAdapter mScheduleHistoryAdapter = new ScheduleHistoryRecycleViewAdapter(tutorItems);
        mRecycler.setAdapter(mScheduleHistoryAdapter);
    }


}
