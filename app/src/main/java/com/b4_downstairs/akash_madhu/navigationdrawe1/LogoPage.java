package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class LogoPage extends AppCompatActivity {

    private static int TIME = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_page);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(com.b4_downstairs.akash_madhu.navigationdrawe1.LogoPage.this,
                        com.b4_downstairs.akash_madhu.navigationdrawe1.Slide_show.class);
                startActivity(intent);
                finish();
            }
        }, TIME);


    }
}
