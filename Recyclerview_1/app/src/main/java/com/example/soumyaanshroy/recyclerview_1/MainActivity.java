package com.example.soumyaanshroy.recyclerview_1;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // ADD FRAGMENTS HERE

        adapter.addFragment(new FragmentBoy(),"Boy");
        adapter.addFragment(new FragmentGirl(),"Girl");
        adapter.addFragment(new FragmentFav(),"Favourite");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        // Remove shadow from action bar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);



    }
}
