package com.example.soumyaanshroy.final_test_1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soumyaanshroy.final_test_1.R;
import com.example.soumyaanshroy.final_test_1.activities.CatalogDescActivity;
import com.example.soumyaanshroy.final_test_1.models.Product;

import java.util.List;

/**
 * Created by Soumyaansh Roy on 12-04-2018.
 */

public class Boy_Girl_Fragment_Recycler_Adapter extends RecyclerView.Adapter<Boy_Girl_Fragment_Recycler_Adapter.MyViewHolder> {

    private Context mContext;
    private List<Product> mData;


    public Boy_Girl_Fragment_Recycler_Adapter(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        v = mInflater.inflate(R.layout.boy_girl_cardview,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.card_title.setText(mData.get(position).getName());
        holder.card_thumbnail.setImageResource(mData.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView card_title;
        ImageView card_thumbnail;


        public MyViewHolder(View itemView) {
            super(itemView);


            card_title = (TextView) itemView.findViewById(R.id.card_title_id);
            card_thumbnail = (ImageView) itemView.findViewById(R.id.card_img);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    System.out.println(card_title + "--------------ITEM CLICKED--------------------");
                    Intent intent = new Intent(view.getContext(),CatalogDescActivity.class);
                    view.getContext().startActivity(intent);
                }
            });


        }
    }
}
