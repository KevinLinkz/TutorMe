package com.example.me.dao.general.schedule;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabScheduleAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public TabScheduleAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
