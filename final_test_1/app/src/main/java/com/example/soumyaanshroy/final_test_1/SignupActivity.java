package com.example.soumyaanshroy.final_test_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Soumyaansh Roy on 17-04-2018.
 */

public class SignupActivity extends AppCompatActivity{


    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);


        submitButton  = (Button)findViewById(R.id.btn_submit);
        submitButton.setOnClickListener(submitButtonOnClickListener);

    }

    private View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            submitButtonClicked();
        }
    };

    private void submitButtonClicked() {
        Intent myIntent = new Intent(SignupActivity.this, OnboardActivity.class);
        SignupActivity.this.startActivity(myIntent);


    }
}
