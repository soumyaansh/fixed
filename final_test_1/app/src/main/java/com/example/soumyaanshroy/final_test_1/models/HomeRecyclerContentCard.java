package com.example.soumyaanshroy.final_test_1.models;

/**
 * Created by Soumyaansh Roy on 26-04-2018.
 */

public class HomeRecyclerContentCard {
    private String imgURL;
    private String title;

    public HomeRecyclerContentCard(String imgURL, String title) {
        this.imgURL = imgURL;
        this.title = title;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
