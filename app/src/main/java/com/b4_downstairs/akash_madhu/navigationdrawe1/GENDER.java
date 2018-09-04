package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GENDER extends AppCompatActivity {

    ImageView fimage, ficon, mimage, micon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);


        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("GENDER", true);
        if (isFirstRun) {

            int trial = 1;


        } else {


            Intent intent = new Intent(this, Calculate_Month.class);
            startActivity(intent);
            finish();

        }


        fimage = findViewById(R.id.imageView6);
        mimage = findViewById(R.id.imageView7);

        ficon = findViewById(R.id.imageView5);
        micon = findViewById(R.id.imageView4);


        fimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Sex = "Female";
                //WRITING IN FILE
                String Message = "" + Sex;
                String file_name = "Gender_female";
                try {
                    FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
                    fileOutputStream.write(Message.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(GENDER.this, "Female", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String Sexx = "1";
                //WRITING IN FILE
                String Messagee = "" + Sexx;
                String file_namee = "ffemale";
                try {
                    FileOutputStream fileOutputStream1 = openFileOutput(file_namee, MODE_PRIVATE);
                    fileOutputStream1.write(Messagee.getBytes());
                    fileOutputStream1.close();
                    Toast.makeText(GENDER.this, "Female", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(GENDER.this, com.b4_downstairs.akash_madhu.navigationdrawe1.mfemale.class);
                startActivity(intent);
                finish();


            }
        });

        ficon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Sex = "Female";
                //WRITING IN FILE
                String Message = "" + Sex;
                String file_name = "Gender_female";
                try {
                    FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
                    fileOutputStream.write(Message.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(GENDER.this, "Female", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String Sexx = "1";
                //WRITING IN FILE
                String Messagee = "" + Sexx;
                String file_namee = "ffemale";
                try {
                    FileOutputStream fileOutputStream1 = openFileOutput(file_namee, MODE_PRIVATE);
                    fileOutputStream1.write(Messagee.getBytes());
                    fileOutputStream1.close();
                    Toast.makeText(GENDER.this, "Female", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(GENDER.this, com.b4_downstairs.akash_madhu.navigationdrawe1.mfemale.class);
                startActivity(intent);
                finish();


            }
        });


        mimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Sex = "Male";
                //WRITING IN FILE
                String Message = "" + Sex;
                String file_name = "Gender_male";
                try {
                    FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
                    fileOutputStream.write(Message.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(GENDER.this, "Male", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String Sexx = "0";
                //WRITING IN FILE
                String Messagee = "" + Sexx;
                String file_namee = "ffemale";
                try {
                    FileOutputStream fileOutputStream1 = openFileOutput(file_namee, MODE_PRIVATE);
                    fileOutputStream1.write(Messagee.getBytes());
                    fileOutputStream1.close();
                    Toast.makeText(GENDER.this, "Female", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(GENDER.this, com.b4_downstairs.akash_madhu.navigationdrawe1.Male.class);
                startActivity(intent);
                finish();


            }
        });

        micon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Sex = "Male";
                //WRITING IN FILE
                String Message = "" + Sex;
                String file_name = "Gender_male";
                try {
                    FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
                    fileOutputStream.write(Message.getBytes());
                    fileOutputStream.close();

                    Toast.makeText(GENDER.this, "Male", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String Sexx = "0";
                //WRITING IN FILE
                String Messagee = "" + Sexx;
                String file_namee = "ffemale";
                try {
                    FileOutputStream fileOutputStream1 = openFileOutput(file_namee, MODE_PRIVATE);
                    fileOutputStream1.write(Messagee.getBytes());
                    fileOutputStream1.close();
                    Toast.makeText(GENDER.this, "Female", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(GENDER.this, com.b4_downstairs.akash_madhu.navigationdrawe1.Male.class);
                startActivity(intent);
                finish();


            }
        });


    }
}
