package com.example.soumyaanshroy.final_test_1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Soumyaansh Roy on 24-04-2018.
 */

public class Tab2Fragment extends Fragment {

    private ListView mListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2_layout,container,false);

        mListView = (ListView) view.findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable://" + R.drawable.card_1, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.card_2, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.card_3, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.card_4, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.card_5, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.card_6, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.card_7, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.card_8, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.card_9, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.card_10, "Arizona Dessert"));



        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.card_layout_main, list);
        mListView.setAdapter(adapter);

        return view;
    }
}
