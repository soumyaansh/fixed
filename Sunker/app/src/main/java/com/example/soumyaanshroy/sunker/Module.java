package com.example.soumyaanshroy.sunker;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Soumyaansh Roy on 23-03-2018.
 */

public class Module {

    @SerializedName("module")
    private String module;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
