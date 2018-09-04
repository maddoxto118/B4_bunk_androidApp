package com.b4_downstairs.akash_madhu.navigationdrawe1;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class Calculate_Month extends AppCompatActivity {


    private static final String[] join = new String[]{"August", "September", "October", "November", "December",
            "January'19", "February'19", "March'19", "April'19", "May'19", "June'19", "July'19", "August'19", "September'19"
            , "October'19", "November'19", "December'19"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate__month);

/*
        SharedPreferences pref = getSharedPreferences("ActivityPREF2", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed2", false)){
            Intent intent = new Intent(this, com.b4_downstairs.akash_madhu.navigationdrawe1.MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed2", true);
            ed.commit();
        }
*/
        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun) {

            int trial = 1;


        } else {


            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        }


    }//OnCreate list line


} //LAST line
