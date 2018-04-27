package com.example.soumyaanshroy.final_test_1.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soumyaanshroy.final_test_1.R;
import com.example.soumyaanshroy.final_test_1.models.Buku;

import java.util.List;

/**
 * Created by Soumyaansh Roy on 12-04-2018.
 */

public class Recycler_View_Adapter extends RecyclerView.Adapter<Recycler_View_Adapter.MyViewHolder> {

    private Context mContext;
    private List<Buku> mData;

    public Recycler_View_Adapter(Context mContext, List<Buku> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        v = mInflater.inflate(R.layout.cardview_item_popup,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_buku_title.setText(mData.get(position).getName());
        holder.img_buku_thumbnail.setImageResource(mData.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_buku_title;
        ImageView img_buku_thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);


            tv_buku_title = (TextView) itemView.findViewById(R.id.buku_title_id);
            img_buku_thumbnail = (ImageView) itemView.findViewById(R.id.buku_img_id);



        }
    }
}
