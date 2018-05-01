package com.example.soumyaanshroy.final_test_1.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.soumyaanshroy.final_test_1.R;
import com.example.soumyaanshroy.final_test_1.adapters.OnBoardSlideAdapter;


public class LoginActivity extends AppCompatActivity {

    private Button signUpButton;
    private Button loginButton;
    String toastMsg = "";
    private Context context;


    private void fetchImages(Context context){

        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;


        switch(screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                toastMsg = "Large screen";
                Log.d("LOGIN PAGE", "SCREEN SIZE IS: "+ toastMsg );
                break;
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                toastMsg = "Normal screen";
                Log.d("LOGIN PAGE", "SCREEN SIZE IS: "+ toastMsg );
                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                toastMsg = "Small screen";
                Log.d("LOGIN PAGE", "SCREEN SIZE IS: "+ toastMsg );
                break;
            default:
                toastMsg = "Screen size is neither large, normal or small";
                Log.d("LOGIN PAGE", "SCREEN SIZE IS: "+ toastMsg );
        }

        // ------------------------ check the density -----------------------------


        int density = getResources().getDisplayMetrics().densityDpi;
        Log.d("LOGIN PAGE", "----------SCREEN DENSITY IS:-------- "+ density );


        switch(density)
        {
            case DisplayMetrics.DENSITY_LOW:
                Toast.makeText(context, "LDPI", Toast.LENGTH_SHORT).show();
                Log.d("LOGIN PAGE", "SCREEN DENSITY IS LDPI " );
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                Toast.makeText(context, "MDPI", Toast.LENGTH_SHORT).show();
                Log.d("LOGIN PAGE", "SCREEN DENSITY IS MDPI" );
                break;
            case DisplayMetrics.DENSITY_HIGH:
                Toast.makeText(context, "HDPI", Toast.LENGTH_SHORT).show();
                Log.d("LOGIN PAGE", "SCREEN DENSITY IS HDPI" );
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                Toast.makeText(context, "XHDPI", Toast.LENGTH_SHORT).show();
                Log.d("LOGIN PAGE", "SCREEN DENSITY IS XHDPI" );
                break;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //-------------CALL IMAGES CHECKING THE SCREEN SIZE----------------------

        context = getApplicationContext();
        fetchImages(context);

        //-----------------------------------
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);

        Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();

        signUpButton  = (Button)findViewById(R.id.btn_signup);
        signUpButton.setOnClickListener(signUpButtonOnClickListener);

        loginButton  = (Button)findViewById(R.id.btn_login);
        loginButton.setOnClickListener(loginButtonOnClickListener);




    }

    private View.OnClickListener loginButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loginButtonClicked();
        }
    };

    private void loginButtonClicked() {
        Intent myIntent = new Intent(LoginActivity.this, OnBoardSlideAdapter.class);
        LoginActivity.this.startActivity(myIntent);
    }

    private View.OnClickListener signUpButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signUpButtonClicked();
        }
    };

    private void signUpButtonClicked() {
        Intent myIntent = new Intent(LoginActivity.this, SignupActivity.class);
        LoginActivity.this.startActivity(myIntent);
    }
}
