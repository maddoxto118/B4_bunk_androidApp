/*package com.b4_downstairs.akash_madhu.navigationdrawe1;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class xxxCalculate_Month extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate__month);






        //autocomplete the space that the user must type in so that we'll get the exact word match for Calculation
        final AutoCompleteTextView actv1 = (AutoCompleteTextView)findViewById(R.id.actv1);
        final AutoCompleteTextView actv2 = (AutoCompleteTextView)findViewById(R.id.actv2);

        Button btn = (Button)findViewById(R.id.btn);

        //autocompletion Image dropdown thing!
        ImageView image = (ImageView) findViewById(R.id.image);
        ImageView image1 = (ImageView) findViewById(R.id.image1);
        //these are for the arrays ie the two strings that are placed in the last of this prog file in wihch the autocomplete directory
        //takes place
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,join);
        actv1.setAdapter(adapter);
        ArrayAdapter<String>adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,endd);
        actv2.setAdapter(adapter1);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actv1.showDropDown();
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actv2.showDropDown();
            }
        });
        //The ABOVE are the ui section where the below are the coding secrion

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String startMonth = actv1.getText().toString().trim();
                String endMonth = actv2.getText().toString().trim();

                if(startMonth.compareTo("August")==0) {

                    if (endMonth.compareTo("August") == 0) {

                        int temp = 22;

                        String id ="1";
                        String name ="toatalDays"
                        String email =temp+"";


                        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
                        SQLiteDatabase database = contactDBHelper.getWritableDatabase();
                        contactDBHelper.addContact(Integer.parseInt(id),name,email,database);
                        contactDBHelper.close();
                        Toast.makeText(getActivity(), "Total days Saved", Toast.LENGTH_SHORT).show();




                        Intent intent = new Intent(xxxCalculate_Month.this,
                                MainActivity.class);

                        startActivity(intent);


                    }//END of If loop1.1 ie aug- aug18

                }//END of If loop1.1 ie aug



            }   //btn last line abd the below'});' #tag_1
        });     //tag_1 means these go together





    }//OnCreate list line


    private static final String[] join = new String[]{"August","September","October","November","December"  ,
            "January'19", "February'19","March'19","April'19","May'19","June'19","July'19","August'19","September'19"
            ,"October'19","November'19","December'19"
    };


    private static final String[] endd = new String[]{"August","September","October","November","December"  ,
            "January'19", "February'19","March'19","April'19","May'19","June'19","July'19","August'19","September'19"
            ,"October'19","November'19","December'19"};



} //LAST line


*/
