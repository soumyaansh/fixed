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
 * Created by Soumyaansh Roy on 24-03-2018.
 */

public class PasswordActivity extends AppCompatActivity {

    private Button signUpButton;
    private String user_contact;
    private String str_user_password;
    private String str_user_password_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Log.d("PASSWORD_PAGE","DEBUGGER STARTED SOUMYAANSH");

        user_contact = this.getIntent().getExtras().getString("user_contact");

        signUpButton  = (Button)findViewById(R.id.btn_signup);
        Log.d("PASSWORD_PAGE","DEBUGGER BUTTON CLICKED");

        signUpButton.setOnClickListener(signUpButtonOnClickListener);
        Log.d("PASSWORD_PAGE","DEBUGGER BUTTON CLICKED ENDED");
    }

    private View.OnClickListener signUpButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signUpButtonClicked();
            Log.d("PASSWORD_PAGE","View.OnClickListener CLICKED");
        }
    };

    private void signUpButtonClicked() {
        Log.d("PASSWORD_PAGE","signUpButtonClicked CLICKED");

        EditText user_password  = (EditText)findViewById(R.id.txt_pwd);
        str_user_password = user_password.getText().toString();
        Log.d("PASSWORD_PAGE",str_user_password);

        EditText user_password_confirm  = (EditText)findViewById(R.id.txt_pwd_confirm);
        str_user_password_confirm = user_password_confirm.getText().toString();
        Log.d("PASSWORD_PAGE",str_user_password_confirm);



        // test the get api
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Module> returnedID = apiService.updatePassword(user_contact,str_user_password_confirm);

        returnedID.enqueue(new Callback<Module>() {
            @Override
            public void onResponse(Call<Module> call, Response<Module> response) {

                if (response.body() == null) {
                    Log.e("PASSWORD_PAGE", "PASSORD SUCCESSFULL: ");
                }

            }

            @Override
            public void onFailure(Call<Module> call, Throwable t) {
                Log.e("PASSWORD_PAGE", "Failure Response : ");// Response : null
            }
        });

        Intent myIntent = new Intent(PasswordActivity.this, HomeActivity.class);
        PasswordActivity.this.startActivity(myIntent);
    }

}
