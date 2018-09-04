package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class kno_gneder extends AppCompatActivity {

    TextView test;
    int token = 200;


    String malee = "";
    String femalee = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kno_gneder);

        test = findViewById(R.id.malee);

        float jojo = 0;

        gettf1();


        jojo = Float.parseFloat(femalee);

        int i = 0;

        if (i < jojo) {
            //      Toast.makeText(this, "Ohh yeag", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, acountinfo_female.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, account_info_male.class);
            startActivity(intent);
            finish();

        }


        //    Intent intent = new Intent(this, MainActivity.class);
        //    startActivity(intent);


    }


    public void getFEMale() {

        try {
            String Message;
            FileInputStream fileInputStream = openFileInput("Gender_female");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            while ((Message = bufferedReader.readLine()) != null) {
                stringBuffer.append(Message + "\n");
            }
            //SET TEXT TO DISPLAY
            malee = stringBuffer.toString();


            //              daysLeft = Integer.parseInt(stringBuffer.toString());
            //      tvleave.setVisibility(View.VISIBLE);
            //       firstDays=stringBuffer.toString().trim();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gett() {

        try {
            String Message;
            FileInputStream fileInputStream = openFileInput("Gender_male");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            while ((Message = bufferedReader.readLine()) != null) {
                stringBuffer.append(Message + "\n");
            }
            //SET TEXT TO DISPLAY
            malee = stringBuffer.toString();
            //   test.setText(stringBuffer.toString());


            //              daysLeft = Integer.parseInt(stringBuffer.toString());
            //      tvleave.setVisibility(View.VISIBLE);
            //       firstDays=stringBuffer.toString().trim();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void gettf1() {

        try {
            String Message;
            FileInputStream fileInputStream = openFileInput("ffemale");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            while ((Message = bufferedReader.readLine()) != null) {
                stringBuffer.append(Message + "\n");
            }
            //SET TEXT TO DISPLAY
            femalee = stringBuffer.toString();
            test.setText("wot" + femalee);

            //   test.setText(stringBuffer.toString());


            //              daysLeft = Integer.parseInt(stringBuffer.toString());
            //      tvleave.setVisibility(View.VISIBLE);
            //       firstDays=stringBuffer.toString().trim();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
