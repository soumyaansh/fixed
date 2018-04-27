package com.example.soumyaanshroy.final_test_1.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.soumyaanshroy.final_test_1.R;
import com.example.soumyaanshroy.final_test_1.adapters.OnBoardSlideAdapter;

/**
 * Created by Soumyaansh Roy on 19-04-2018.
 */

public class OnboardActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout dotlayout;
    private TextView[] dotstv;
    private int[] layouts;
    private Button btnSkip;
    private Button btnNext;

    private OnBoardSlideAdapter onBoardSlideAdapter;


    public Button getBtnSkip() {
        return btnSkip;
    }

    public void setBtnSkip(Button btnSkip) {
        this.btnSkip = btnSkip;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean b = isFirstTimeStartApp();
        Log.d("ON BOARD", "is first time user "+ b );

        /*if(!isFirstTimeStartApp()){
            startHomeActivity();
            finish();
        }*/

        setContentView(R.layout.onboard_activity);


        viewPager = findViewById(R.id.view_pager);
        dotlayout = findViewById(R.id.dotLayout);

        btnNext = (Button) findViewById(R.id.btn_next);
        btnSkip = (Button) findViewById(R.id.btn_skip);

        Log.d("ON BOARD", "onCreate");

        setStatusBarTransparent();


        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeActivity();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int currentPage = viewPager.getCurrentItem() + 1 ;
                if(currentPage < layouts.length){
                    // move to next page

                    viewPager.setCurrentItem(currentPage);
                }else {
                    startHomeActivity();
                }
            }
        });

        layouts = new int[] {R.layout.slide_1,R.layout.slide_2,R.layout.slide_3};
        onBoardSlideAdapter = new OnBoardSlideAdapter(getApplicationContext(),layouts);
        viewPager.setAdapter(onBoardSlideAdapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // last page
            if(position == layouts.length-1){
                 btnNext.setText("START");
                 btnSkip.setVisibility(View.GONE);
            }else {
                btnNext.setText("NEXT");
                btnSkip.setVisibility(View.VISIBLE);
            }
            setDotStatus(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setDotStatus(0);

    }

    private boolean isFirstTimeStartApp(){

        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag",true);

    }

    private void setFirstTimeStartStatus(boolean stt){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putBoolean("FirstTimeStartFlag",stt);
        editor.commit();

    }

    private void setDotStatus(int page){
        dotlayout.removeAllViews();
        dotstv = new TextView[layouts.length];
        for (int i =0;i<dotstv.length;i++){
            dotstv[i] = new TextView(this);
            dotstv[i].setText(Html.fromHtml("&#8226;"));
            dotstv[i].setTextSize(30);
            dotstv[i].setTextColor(Color.parseColor("#a9b4bb"));
            dotlayout.addView(dotstv[i]);
        }

        // set current dot active

        if(dotstv.length > 0){
            dotstv[page].setTextColor(Color.parseColor("#ffffff"));
        }
    }

    private void startHomeActivity(){
        setFirstTimeStartStatus(false);
        startActivity(new Intent(OnboardActivity.this,HomeActivity.class));
        finish();
    }

    private void setStatusBarTransparent(){

        if(Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
