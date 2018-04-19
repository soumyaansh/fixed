package com.example.soumyaanshroy.final_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button signUpButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

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
        Intent myIntent = new Intent(LoginActivity.this, SlideAdapter.class);
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
