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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class mfemale extends AppCompatActivity {

    TextView test;
    EditText inputfemale;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mfemale);


        inputfemale = findViewById(R.id.name);
        btn_next = findViewById(R.id.button);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (inputfemale.getText().toString().isEmpty()) {
                    Toast.makeText(mfemale.this, "Please Enter The Field", Toast.LENGTH_SHORT).show();
                } else {


//TYPE iN
                    String name = inputfemale.getText().toString().trim();

                    String Message1 = "" + name;

                    String file_name1 = "name_female";

                    try {
                        FileOutputStream fileOutputStream1 = openFileOutput(file_name1, MODE_PRIVATE);
                        fileOutputStream1.write(Message1.getBytes());
                        fileOutputStream1.close();
                        Toast.makeText(mfemale.this, "Name Saved", Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(mfemale.this);
                    SharedPreferences.Editor editor = wmbPreference.edit();
                    editor.putBoolean("GENDER", false);
                    editor.commit();


                    Intent intent = new Intent(mfemale.this, com.b4_downstairs.akash_madhu.navigationdrawe1.Calculate_Month.class);
                    startActivity(intent);
                    finish();


                }


            }
        });


    }


}