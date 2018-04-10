package com.example.soumyaanshroy.sunker;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Soumyaansh Roy on 22-03-2018.
 */

public class TestResponse {

    @SerializedName("$oid")
    private String id;

    // Getter Methods

    public String getid() {
        return id;
    }

    // Setter Methods

    public void setid( String id ) {
        this.id = id;
    }


}
