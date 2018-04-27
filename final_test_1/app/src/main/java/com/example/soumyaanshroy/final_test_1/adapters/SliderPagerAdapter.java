package com.example.soumyaanshroy.final_test_1.adapters;

/**
 * Created by Soumyaansh Roy on 26-04-2018.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.soumyaanshroy.final_test_1.models.HomeRecyclerContentCard;
import com.squareup.picasso.Picasso;
import com.example.soumyaanshroy.final_test_1.R;
import java.util.ArrayList;


public class SliderPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    Activity activity;
    ArrayList<HomeRecyclerContentCard> image_arraylist;
    private Integer[] images = {R.drawable.home_slider_img_9,R.drawable.home_slider_img_10,R.drawable.home_slider_img_11};


    public SliderPagerAdapter(Activity activity, ArrayList<HomeRecyclerContentCard> image_arraylist) {
        this.activity = activity;
        this.image_arraylist = image_arraylist;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.layout_slider, container, false);
        ImageView im_slider = (ImageView) view.findViewById(R.id.im_slider);
        Picasso.with(activity.getApplicationContext())
                .load(images[position])
                .into(im_slider);


        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return images.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}