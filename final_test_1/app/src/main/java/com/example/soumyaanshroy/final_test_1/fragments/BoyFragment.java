package com.example.soumyaanshroy.final_test_1.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soumyaanshroy.final_test_1.models.Product;
import com.example.soumyaanshroy.final_test_1.R;
import com.example.soumyaanshroy.final_test_1.adapters.Boy_Girl_Fragment_Recycler_Adapter;

import java.util.ArrayList;
import java.util.List;


public class BoyFragment extends Fragment {


    View v;
    private RecyclerView myrecyclerview;
    private List<Product> lstbukuses;

    public BoyFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_boy,container,false);

        myrecyclerview = (RecyclerView) v.findViewById(R.id.recycler_boy_id);
        Boy_Girl_Fragment_Recycler_Adapter boyGirlFragmentRecycler__adapter = new Boy_Girl_Fragment_Recycler_Adapter(getContext(), lstbukuses);
        myrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myrecyclerview.setAdapter(boyGirlFragmentRecycler__adapter);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        lstbukuses = new ArrayList<Product>();

        Product product1 = new Product();
        product1.setName("just do it");
        product1.setThumbnail(R.drawable.justdoit);
        product1.setPrice("399");

        Product product2 = new Product();
        product2.setName("Batman");
        product2.setThumbnail(R.drawable.batman);
        product2.setPrice("399");

        Product product3 = new Product();
        product3.setName("Deadpool");
        product3.setThumbnail(R.drawable.dpool);
        product3.setPrice("399");

        Product product4 = new Product();
        product4.setName("Orange");
        product4.setThumbnail(R.drawable.orange);
        product4.setPrice("399");

        Product product5 = new Product();
        product5.setName("Triangle");
        product5.setThumbnail(R.drawable.triangle);
        product5.setPrice("399");

        Product product6 = new Product();
        product6.setName("Me");
        product6.setThumbnail(R.drawable.me);
        product6.setPrice("399");

        Product product7 = new Product();
        product7.setName("We");
        product7.setThumbnail(R.drawable.we);
        product7.setPrice("399");

        Product product8 = new Product();
        product8.setName("Figgit");
        product8.setThumbnail(R.drawable.figit);
        product8.setPrice("399");



        lstbukuses.add(product1);
        lstbukuses.add(product2);
        lstbukuses.add(product3);
        lstbukuses.add(product4);
        lstbukuses.add(product5);
        lstbukuses.add(product6);
        lstbukuses.add(product7);
        lstbukuses.add(product8);



    }




}
