package com.example.soumyaanshroy.final_test_1;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.net.Network;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;



/**
 * Created by Soumyaansh Roy on 19-04-2018.
 */

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Log.d("HOME ACTIVITY", "DEBUGGER STARTED SOUMYAANSH");


        dl = (DrawerLayout) findViewById(R.id.dl);
        toggle = new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(toggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nv);

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setupDrawerContent(nvDrawer);



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
