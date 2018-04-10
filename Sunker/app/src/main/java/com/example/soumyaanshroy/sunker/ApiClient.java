package com.example.soumyaanshroy.sunker;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Soumyaansh Roy on 20-03-2018.
 */

public class ApiClient  {

    public static final String BASE_URL = "https://rc1hgrvykc.execute-api.ap-south-1.amazonaws.com/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
