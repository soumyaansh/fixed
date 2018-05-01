package com.example.soumyaanshroy.final_test_1.models;

import java.util.ArrayList;

/**
 * Created by Soumyaansh Roy on 26-04-2018.
 */

public class Data {

    public static final int VIEW_PAGER = 0;
    public static final int IMAGE_TYPE = 1;
    public static final int TABLE_TYPE = 2;

    public int type;
    public String text;
    public Integer image;
    public Integer[] images; // when type is VIEW_PAGES send multiple images

    public Data(int type, String text,Integer image,Integer[] images) {

        this.type = type;
        this.text = text;
        this.image = image;
        this.images= images;
    }

}
