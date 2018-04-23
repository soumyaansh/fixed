package com.example.soumyaanshroy.final_test_1;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Soumyaansh Roy on 19-04-2018.
 */

public class HomeActivity extends AppCompatActivity {

    //---------------------------NAVIGATION CODE BELOW------------------------------------------
    private DrawerLayout dl;
    private ActionBarDrawerToggle toggle;
    //---------------------------NAVIGATION CODE BELOW------------------------------------------


    //---------------------------HOME SLIDER BELOW------------------------------------------
    ViewPager viewPager;
    private LinearLayout sliderDotPanel;
    private int dotsCount;
    private ImageView [] dots;
    //---------------------------HOME SLIDER ABOVE------------------------------------------



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);




        //---------------------------HOME SLIDER BELOW----------------------------------------------
        viewPager = (ViewPager)findViewById(R.id.home_view_pager_1);
        sliderDotPanel = (LinearLayout) findViewById(R.id.home_slider_dots_1);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];


        for(int i = 0;i< dotsCount;i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotPanel.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0;i< dotsCount;i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeTimerTask(),2000,4000);


        //---------------------------HOME SLIDER ABOVE----------------------------------------------




        //---------------------------NAVIGATION CODE BELOW------------------------------------------
        Log.d("HOME ACTIVITY", "DEBUGGER STARTED SOUMYAANSH");

        dl = (DrawerLayout) findViewById(R.id.dl);
        toggle = new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(toggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nv);

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setupDrawerContent(nvDrawer);
        //---------------------------NAVIGATION CODE ABOVE------------------------------------------


    }


    public class HomeTimerTask extends TimerTask{

        @Override
        public void run(){

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem()== 0 ){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }







    private void setupDrawerContent(NavigationView navigationView) {
        Log.d("HOME ACTIVITY", "INSIDE setupDrawerContent");
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("HOME ACTIVITY", "INSIDE onOptionsItemSelected");
        if(toggle.onOptionsItemSelected(item)){
            Log.d("HOME ACTIVITY", "INSIDE IF onOptionsItemSelected");
            selectItemDrawer(item);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


   public boolean isAnyItemSelected(MenuItem menuItem){

        boolean selected = false;

       switch (menuItem.getItemId()){

           case R.id.boys_section:
               selected = true;
               break;
           case R.id.girls_section:
               selected = true;
               break;
           case R.id.settings:
               selected = true;
               break;
       }

       return selected;
    }


    public void selectItemDrawer(MenuItem menuItem) {

        Log.d("HOME ACTIVITY", "INSIDE selectItemDrawer "+menuItem.getItemId());
        Fragment myFragment = null;
        Class fragmentClass;

        switch (menuItem.getItemId()){

            case R.id.boys_section:
                fragmentClass = BoyFragment.class;
                break;
            case R.id.girls_section:
                fragmentClass = GirlFragment.class;
                break;
            case R.id.settings:
                fragmentClass = SettingFragment.class;
                break;

            default:
                fragmentClass = BoyFragment.class;
                break;
        }
        try {
            myFragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flcontent,myFragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());

        Log.d("HOME ACTIVITY", "CLOSE DRAWERS");
        boolean notFirstTime = isAnyItemSelected(menuItem);

        if(notFirstTime){
            dl.closeDrawer(Gravity.START,true);
        }


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }


}
