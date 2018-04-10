package com.example.soumyaanshroy.sunker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Soumyaansh Roy on 20-03-2018.
 */

public class MainActivity extends AppCompatActivity {

    private Button signUpButton;
    private Button loginButton;

    private String str_user_password;
    private String str_user_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("USERVALUE","DEBUGGER STARTED SOUMYAANSH");

        EditText user_password  = (EditText)findViewById(R.id.text_pwd);
        str_user_password = user_password.getText().toString();
        Log.d("str_user_password",str_user_password);

        EditText user_number  = (EditText)findViewById(R.id.text_mobile);
        str_user_number = user_number.getText().toString();
        Log.d("str_user_number",str_user_number);

        signUpButton  = (Button)findViewById(R.id.btn_signup);
        signUpButton.setOnClickListener(signUpButtonOnClickListener);

        loginButton  = (Button)findViewById(R.id.btn_login);
        loginButton.setOnClickListener(loginButtonOnClickListener);



    }


    private View.OnClickListener loginButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loginButtonClicked();
            Log.d("USERVALUE","View.OnClickListener CLICKED");
        }
    };

    private void loginButtonClicked() {

        Log.d("USER NUMBER",str_user_number);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<User> returnedID = apiService.getUser(str_user_number);

        returnedID.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                String user_Name = response.body().getUser_Name();
                String user_Email = response.body().getUser_Email_ID();
                String user_Number = response.body().getUser_Contact_Number();

                Log.e("user_Name", user_Name);
                Log.e("user_Email", user_Email);
                Log.e("user_Number", user_Number);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("PASSWORD_PAGE", "Failure Response : ");// Response : null
            }
        });




        Intent myIntent = new Intent(MainActivity.this, HomeActivity.class);
        MainActivity.this.startActivity(myIntent);
    }




    private View.OnClickListener signUpButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signUpButtonClicked();
            Log.d("USERVALUE","View.OnClickListener CLICKED");
        }
    };

    private void signUpButtonClicked() {
        Log.d("USERVALUE","signUpButtonClicked CLICKED");

        // test the get api



        Intent myIntent = new Intent(MainActivity.this, SignupActivity.class);
        MainActivity.this.startActivity(myIntent);
    }



}
