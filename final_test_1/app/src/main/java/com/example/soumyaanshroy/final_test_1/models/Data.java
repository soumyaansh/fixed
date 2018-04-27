package com.example.soumyaanshroy.final_test_1.models;

/**
 * Created by Soumyaansh Roy on 26-04-2018.
 */



public class Data {

    public static final int VIEW_PAGER = 0;
    public static final int IMAGE_TYPE = 1;
    public static final int AUDIO_TYPE = 2;


    public int type;
    public int data;
    public String text;

    public Data(int type, String text, int data) {
        this.type = type;
        this.data = data;
        this.text = text;
    }

}
