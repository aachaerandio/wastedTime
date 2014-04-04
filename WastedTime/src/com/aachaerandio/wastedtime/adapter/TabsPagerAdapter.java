package com.aachaerandio.wastedtime.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aachaerandio.wastedtime.ButtonFragment;
import com.aachaerandio.wastedtime.ListWastedTime;


public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Button fragment activity
            return new ButtonFragment();
        case 1:
            // List fragment activity
            return new ListWastedTime();
        case 2:
            // Other fragment activity
            return new ListWastedTime();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
}
