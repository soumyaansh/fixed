package com.example.soumyaanshroy.final_test_1.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soumyaanshroy.final_test_1.models.Buku;
import com.example.soumyaanshroy.final_test_1.R;
import com.example.soumyaanshroy.final_test_1.adapters.Recycler_View_Adapter;

import java.util.ArrayList;
import java.util.List;


public class GirlFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Buku> lstbukus;

    public GirlFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_girl,container,false);

        myrecyclerview = (RecyclerView) v.findViewById(R.id.recycler_girl_id);
        Recycler_View_Adapter recycler_view_adapter = new Recycler_View_Adapter(getContext(),lstbukus);
        myrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myrecyclerview.setAdapter(recycler_view_adapter);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        lstbukus = new ArrayList<Buku>();

        Buku buku1 = new Buku();
        buku1.setName("just do it");
        buku1.setThumbnail(R.drawable.girl_1);
        buku1.setPrice("399");

        Buku buku2 = new Buku();
        buku2.setName("Batman");
        buku2.setThumbnail(R.drawable.girl_2);
        buku2.setPrice("399");

        Buku buku3 = new Buku();
        buku3.setName("Deadpool");
        buku3.setThumbnail(R.drawable.girl_3);
        buku3.setPrice("399");

        Buku buku4 = new Buku();
        buku4.setName("Orange");
        buku4.setThumbnail(R.drawable.girl_4);
        buku4.setPrice("399");

        Buku buku5 = new Buku();
        buku5.setName("Triangle");
        buku5.setThumbnail(R.drawable.girl_5);
        buku5.setPrice("399");

        Buku buku6 = new Buku();
        buku6.setName("Me");
        buku6.setThumbnail(R.drawable.girl_6);
        buku6.setPrice("399");

        Buku buku7 = new Buku();
        buku7.setName("We");
        buku7.setThumbnail(R.drawable.girl_7);
        buku7.setPrice("399");

        Buku buku8 = new Buku();
        buku8.setName("Figgit");
        buku8.setThumbnail(R.drawable.girl_8);
        buku8.setPrice("399");



        lstbukus.add(buku1);
        lstbukus.add(buku2);
        lstbukus.add(buku3);
        lstbukus.add(buku4);
        lstbukus.add(buku5);
        lstbukus.add(buku6);
        lstbukus.add(buku7);
        lstbukus.add(buku8);



    }

}
