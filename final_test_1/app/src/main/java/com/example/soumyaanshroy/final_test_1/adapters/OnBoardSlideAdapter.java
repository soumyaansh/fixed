package com.example.soumyaanshroy.final_test_1.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.soumyaanshroy.final_test_1.R;


/**
 * Created by Soumyaansh Roy on 17-04-2018.
 */

public class OnBoardSlideAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private int[] layouts;

    public OnBoardSlideAdapter(Context context, int[] layouts) {
        this.context = context;
        this.layouts = layouts;
    }


    // list of images
    public int[] lst_images = {
            R.drawable.tee_1,
            R.drawable.tee_2,
            R.drawable.tee_3};


    // list of titles
    public String[] lst_title = {
            "GREEN",
            "BLUE",
            "GRAY",

    }   ;

    // list of descriptions
    public String[] lst_description = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89)
    };


    public OnBoardSlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d("SLIDE ADAPTER", "inside instantiateItem");

        Log.d("SLIDE ADAPTER", "inside  position "+ position + "instantiateItem");

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layouts[position],container,false);
        Log.d("SLIDE ADAPTER", "view:  "+ view);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       View view = (View) object;
       container.removeView(view);
    }

}
