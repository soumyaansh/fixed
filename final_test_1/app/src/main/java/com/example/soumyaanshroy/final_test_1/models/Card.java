package com.example.soumyaanshroy.final_test_1.models;

/**
 * Created by Soumyaansh Roy on 23-04-2018.
 */

public class Card {

    private int imgURL;
    private String title;

    public Card(int imgURL, String title) {
        this.imgURL = imgURL;
        this.title = title;
    }

    public int getImgURL() {
        return imgURL;
    }

    public void setImgURL(int imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}