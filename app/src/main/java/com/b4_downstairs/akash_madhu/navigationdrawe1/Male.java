package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Male extends AppCompatActivity {

    TextView test;
    EditText inputmale;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);

        test = findViewById(R.id.genmale);
        inputmale = findViewById(R.id.inputmale);
        btn_next = findViewById(R.id.button);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (inputmale.getText().toString().isEmpty()) {
                    Toast.makeText(Male.this, "Please Enter The Field", Toast.LENGTH_SHORT).show();
                } else {


//TYPE iN
                    String name = inputmale.getText().toString().trim();

                    String Message1 = "" + name;

                    String file_name1 = "name_male";

                    try {
                        FileOutputStream fileOutputStream1 = openFileOutput(file_name1, MODE_PRIVATE);
                        fileOutputStream1.write(Message1.getBytes());
                        fileOutputStream1.close();
                        Toast.makeText(Male.this, "Name Saved", Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(Male.this);
                    SharedPreferences.Editor editor = wmbPreference.edit();
                    editor.putBoolean("GENDER", false);
                    editor.commit();

                    Intent intent = new Intent(Male.this, com.b4_downstairs.akash_madhu.navigationdrawe1.Calculate_Month.class);
                    startActivity(intent);
                    finish();


                }


            }
        });


        gett();


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
            test.setText(stringBuffer.toString());


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
