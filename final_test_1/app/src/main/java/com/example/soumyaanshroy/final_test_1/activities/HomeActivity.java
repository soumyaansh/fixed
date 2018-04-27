package com.example.soumyaanshroy.final_test_1.activities;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.soumyaanshroy.final_test_1.R;
import com.example.soumyaanshroy.final_test_1.adapters.MultiViewTypeAdapter;
import com.example.soumyaanshroy.final_test_1.fragments.BoyFragment;
import com.example.soumyaanshroy.final_test_1.fragments.GirlFragment;
import com.example.soumyaanshroy.final_test_1.fragments.ProfileFragment;
import com.example.soumyaanshroy.final_test_1.models.Data;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Soumyaansh Roy on 19-04-2018.
 */

public class HomeActivity extends AppCompatActivity {

    //---------------------------NAVIGATION CODE BELOW------------------------------------------
    private DrawerLayout dl;
    private ActionBarDrawerToggle toggle;
    //---------------------------NAVIGATION CODE BELOW------------------------------------------



    //---------------------------RECYCLER CODE BELOW------------------------------------------

    private RecyclerView mRecyclerView;
    Unbinder mUnbinder;

    //---------------------------RECYCLER CODE ABOVE------------------------------------------



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);







        //---------------------------SET RECYCLER CARDS BELOW SLIDER----------------------------

        mRecyclerView = (RecyclerView)findViewById(R.id.rv);

        mUnbinder = ButterKnife.bind(this);

        ArrayList<Data> list = new ArrayList<>();
        list.add(new Data(Data.VIEW_PAGER, "Hello. This is the View Pager view type with images", 0));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.disneys_cinderella));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_33));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_1));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_2));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_3));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_4));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_5));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_6));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_7));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_8));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_9));
        list.add(new Data(Data.IMAGE_TYPE, "A view type with Image and Textview", R.drawable.card_10));
        list.add(new Data(Data.IMAGE_TYPE, "Hi again. A view with Image and Textview", R.drawable.snow));

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list, this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

        //---------------------------SET RECYCLER CARDS BELOW SLIDER----------------------------





        //---------------------------NAVIGATION CODE BELOW------------------------------------------
        Log.d("HOME ACTIVITY", "DEBUGGER STARTED SOUMYAANSH");

        dl = (DrawerLayout) findViewById(R.id.dl);
        toggle = new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(toggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nv);
        nvDrawer.setItemTextColor(ColorStateList.valueOf(Color.DKGRAY));

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setupDrawerContent(nvDrawer);
        //---------------------------NAVIGATION CODE ABOVE------------------------------------------


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) mUnbinder.unbind();
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
           case R.id.orders:
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
            case R.id.orders:
                fragmentClass = ProfileFragment.class;
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
