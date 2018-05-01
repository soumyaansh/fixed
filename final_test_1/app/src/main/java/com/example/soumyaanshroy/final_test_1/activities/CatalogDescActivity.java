package com.example.soumyaanshroy.final_test_1.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.example.soumyaanshroy.final_test_1.R;
import com.example.soumyaanshroy.final_test_1.adapters.CatalogTypeAdapter;
import com.example.soumyaanshroy.final_test_1.models.Data;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Soumyaansh Roy on 28-04-2018.
 */

public class CatalogDescActivity extends AppCompatActivity {

    //---------------------------RECYCLER CODE BELOW------------------------------------------

    private RecyclerView mRecyclerView;
    Unbinder mUnbinder;

    //---------------------------RECYCLER CODE ABOVE------------------------------------------

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog_desc_page);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        mRecyclerView = (RecyclerView)findViewById(R.id.rv_1);

        mUnbinder = ButterKnife.bind(this);

        Integer[] images = {R.drawable.home_slider_img_9,R.drawable.home_slider_img_10,R.drawable.home_slider_img_11};

        ArrayList<Data> list = new ArrayList<>();
        list.add(new Data(Data.VIEW_PAGER, "Hello.",null, images));
        list.add(new Data(Data.TABLE_TYPE, "from me",null, images));

        CatalogTypeAdapter adapter = new CatalogTypeAdapter(list, this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        finish();

        return super.onOptionsItemSelected(item);
    }


}
