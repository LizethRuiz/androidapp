package com.example.codenames.Clases;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.codenames.fragments.tab1;
import com.example.codenames.fragments.tab2;
import com.example.codenames.fragments.tab3;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;
    public PagerAdapter(FragmentManager fm, int NumberofTabs){
        super(fm);
        this.mNoOfTabs = NumberofTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                tab1 tab1 = new tab1();
                return tab1;
            case 1:
                tab2 tab2 = new tab2();
                return tab2;
            case 2:
                tab3 tab3 = new tab3();
                return tab3;
             default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
