package com.vehicledetails.rcdetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.vehicledetails.rcdetails.Fragments.RcFragment;
import com.vehicledetails.rcdetails.Fragments.RecentFragment;
import com.vehicledetails.rcdetails.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {





    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;

    private RcFragment rcFragment;
    private RecentFragment recentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("RC Details By Vehicle Number");
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_car);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_recent);


    }


    class ViewPagerAdapter
            extends FragmentPagerAdapter {

        public ViewPagerAdapter(
                @NonNull FragmentManager fm)
        {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position)
        {
            Fragment fragment = null;
            if (position == 0)
                fragment = new RcFragment();
            else if (position == 1)
                fragment = new RecentFragment();



            return fragment;
        }

        @Override
        public int getCount()
        {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            String title = null;
            if (position == 0)
                title = "RC Details";
            else if (position == 1)
                title = "Recent";

            return title;
        }
    }

}