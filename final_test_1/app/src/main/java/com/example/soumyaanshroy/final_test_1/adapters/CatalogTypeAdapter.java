package com.example.soumyaanshroy.final_test_1.adapters;

/**
 * Created by Soumyaansh Roy on 26-04-2018.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.soumyaanshroy.final_test_1.R;
import com.example.soumyaanshroy.final_test_1.models.Data;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CatalogTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Data> dataSet;
    Context mContext;
    int total_types;
    int page = 0;

    public CatalogTypeAdapter(ArrayList<Data> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = data.size();
    }


    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.catalog_ll_dots)
        LinearLayout ll_dots;
        @BindView(R.id.catalog_vp_slider)
        ViewPager mvViewPager;

        public TextTypeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class TableTypeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.product_title)
        TextView product_title;
        @BindView(R.id.product_price)
        TextView product_price;

        public TableTypeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.type)
        TextView tvtype;
        @BindView(R.id.img)
        ImageView iv;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ButtonTypeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.type)
        TextView type;


        public ButtonTypeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case Data.VIEW_PAGER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog_viewpager, parent, false);
                return new TextTypeViewHolder(view);
            case Data.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_type, parent, false);
                return new ImageTypeViewHolder(view);
            case Data.TABLE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog_table_layout, parent, false);
                return new TableTypeViewHolder(view);
        }
        return null;


    }


    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return Data.VIEW_PAGER;
            case 1:
                return Data.IMAGE_TYPE;
            case 2:
                return Data.TABLE_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        Data object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case Data.VIEW_PAGER:

                    final SliderPagerAdapter sliderPagerAdapter = new SliderPagerAdapter((Activity) mContext, object);
                    ((TextTypeViewHolder) holder).mvViewPager.setAdapter(sliderPagerAdapter);
                    ((TextTypeViewHolder) holder).mvViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                            addBottomDots(position, ((TextTypeViewHolder) holder).ll_dots);
                            page = position;
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });

                    addBottomDots(0, ((TextTypeViewHolder) holder).ll_dots);
                    final Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (sliderPagerAdapter.getCount() == page) {
                                page = 0;
                            } else {
                                page++;
                            }
                            ((TextTypeViewHolder) holder).mvViewPager.setCurrentItem(page);
                            h.postDelayed(this, 2000);
                        }
                    }, 1000);

                    break;
                case Data.IMAGE_TYPE:
                    ((ImageTypeViewHolder) holder).tvtype.setText(object.text);
                    ((ImageTypeViewHolder) holder).iv.setImageResource(object.image);
                    break;

                case Data.TABLE_TYPE:
                    ((TableTypeViewHolder) holder).product_title.setText(object.text);
                    ((TableTypeViewHolder) holder).product_price.setText(object.text);
                    break;

            }
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    //showing dots on screen
    private void addBottomDots(int currentPage, LinearLayout ll_dots) {
        TextView[] dots = new TextView[dataSet.get(0).images.length];
        ll_dots.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(mContext);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#343434"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#A2A2A2"));
    }

}