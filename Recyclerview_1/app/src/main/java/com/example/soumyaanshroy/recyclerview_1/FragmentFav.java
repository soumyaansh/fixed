package com.example.soumyaanshroy.recyclerview_1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Soumyaansh Roy on 11-04-2018.
 */

public class FragmentFav extends Fragment{

    View v;

    public FragmentFav() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fav_fragment,container,false);

        return v;
    }
}
