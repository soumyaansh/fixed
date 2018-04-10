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
 * Created by Soumyaansh Roy on 21-03-2018.
 */

public class SignupActivity extends AppCompatActivity {

    private Button registerbtn;
    private String strUserName;
    private String strUserAge;
    private String strUserNumber;
    private String strUserEmail;
    private String strUserLocation;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Log.d("SIGNUP","DEBUGGER STARTED SOUMYAANSH");

        registerbtn = (Button)findViewById(R.id.btn_next);
        registerbtn.setOnClickListener(signupButtonOnClickListener);

    }

    private View.OnClickListener signupButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signupButtonClicked();
            Log.d("SIGNUP","View.OnClickListener CLICKED");
        }
    };

    private void signupButtonClicked() {
        Log.d("SIGNUP","signupButtonClicked CLICKED");


        EditText userName  = (EditText)findViewById(R.id.text_username);
        strUserName = userName.getText().toString();
        Log.d("SIGNUP",strUserName);

        EditText userAge  = (EditText)findViewById(R.id.text_age);
        strUserAge = userAge.getText().toString();
        Log.d("SIGNUP",strUserAge);

        EditText userNumber  = (EditText)findViewById(R.id.text_number);
        strUserNumber = userNumber.getText().toString();
        Log.d("SIGNUP",strUserNumber);

        EditText userEmail  = (EditText)findViewById(R.id.text_email);
        strUserEmail = userEmail.getText().toString();
        Log.d("SIGNUP",strUserEmail);

        EditText userLocation  = (EditText)findViewById(R.id.text_location);
        strUserLocation = userLocation.getText().toString();
        Log.d("SIGNUP",strUserLocation);

        /*ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TestResponse> returnedID = apiService.createUser(strUserName,strUserAge,strUserNumber,strUserEmail,strUserLocation);

        returnedID.enqueue(new Callback<TestResponse>() {
            @Override
            public void onResponse(Call<TestResponse> call, Response<TestResponse> response) {

                TestResponse examples = response.body();
                Log.e("SIGNUP", "RESPONSE ID IS : " + response.body().getid());// Response : null

            }

            @Override
            public void onFailure(Call<TestResponse> call, Throwable t) {
                Log.e("SIGNUP", "SIGNUP RESPONSE FAILED ");// Response : null
            }
        });
*/


        Intent pwdIntent = new Intent(SignupActivity.this, PasswordActivity.class);
        pwdIntent.putExtra("user_contact",strUserNumber);
        SignupActivity.this.startActivity(pwdIntent);
    }

}
