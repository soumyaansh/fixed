package com.example.soumyaanshroy.sunker;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Soumyaansh Roy on 20-03-2018.
 */

public interface ApiInterface {


    @GET("api/user/get/{contact}")
    Call<User> getUser(@Path("contact") String contact);

    @GET("api/user/create/{userName}/{userAge}/{userContact}/{userEmail}/{location}")
    Call<TestResponse> createUser(@Path("userName") String userName, @Path("userAge") String userAge, @Path("userContact") String userContact, @Path("userEmail") String userEmail, @Path("location") String location);

    @GET("api/user/update/{contact}/{pwd}")
    Call<Module>  updatePassword(@Path("contact") String contact, @Path("pwd") String pwd);


}
