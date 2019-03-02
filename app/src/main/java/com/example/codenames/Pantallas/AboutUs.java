package com.example.codenames.Pantallas;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.codenames.R;
import com.example.codenames.fragments.tab1;
import com.example.codenames.fragments.tab2;
import com.example.codenames.fragments.tab3;

public class AboutUs extends AppCompatActivity implements tab1.OnFragmentInteractionListener,tab2.OnFragmentInteractionListener, tab3.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.sub1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.sub2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.sub3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewpager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new com.example.codenames.Clases.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
