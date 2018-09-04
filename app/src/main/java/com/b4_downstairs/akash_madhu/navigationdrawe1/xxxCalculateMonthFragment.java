/* package com.b4_downstairs.akash_madhu.navigationdrawe1;


import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class xxxCalculateMonthFragment extends Fragment {

    private TextView read_id,update_id,read_total,read_bunked,read_perse;

    private Boolean exit = false;

    String RU_bunkdays;
    String RU_Total;
    String RU_Percent;
    EditText updateAbss;

    int totaldays, bunk_days;
    float perk;


    public xxxCalculateMonthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_calculate_month, container, false);

        read_id = view.findViewById(R.id.read_id);
        read_total = view.findViewById(R.id.read_total);
        read_bunked= view.findViewById(R.id.read_bunkd);

        update_id = view.findViewById(R.id.upadate_id);
        read_perse = view.findViewById(R.id.read_perse);
  //      update_email = view.findViewById(R.id.upadate_email);

        //update

        updateAbss = view.findViewById(R.id.updateAbs);


        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN1", true);
        if (isFirstRun)
        {
            Toast.makeText(getActivity(), "Toatl not accesed", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN1", false);
            editor.commit();
        }else{

           readThings();
            Toast.makeText(getActivity(), "Toatl accesed", Toast.LENGTH_SHORT).show();
        }






        //autocomplete the space that the user must type in so that we'll get the exact word match for Calculation
        final AutoCompleteTextView actv1 = (AutoCompleteTextView)view.findViewById(R.id.actv1);
        final AutoCompleteTextView actv2 = (AutoCompleteTextView)view.findViewById(R.id.actv2);

        Button btn = (Button)view.findViewById(R.id.btn);

        Button btnread = (Button)view.findViewById(R.id.btnRead);

        Button btnupdate = (Button)view.findViewById(R.id.btnUpdate);





        //autocompletion Image dropdown thing!
        ImageView image = (ImageView) view.findViewById(R.id.image);
        ImageView image1 = (ImageView) view.findViewById(R.id.image1);
        //these are for the arrays ie the two strings that are placed in the last of this prog file in wihch the autocomplete directory
        //takes place
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,join);
        actv1.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(),android.R.layout.simple_dropdown_item_1line,endd);
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



                //RUNs Only ONCE

                        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);

                        if (isFirstRun)
                        {   //for ADDING Total_days in DATABASE
                            int temp = 22;
                            String id ="1";
                            String name ="0";
                            String email =temp+"";
                            String per = "100";
                    //Writing the data
                            ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
                            SQLiteDatabase database = contactDBHelper.getWritableDatabase();
                            contactDBHelper.addContact(Integer.parseInt(id),name,email,per,database);
                            contactDBHelper.close();
/*
                            int temp1 = 50;
                            String id1 ="2";
                            String name1 ="Bunk Days!";
                            String email1 =temp1+"";
                            String per1 = "pp";
                            //Writing the data
                            ContactDBHelper contactDBHelper1 = new ContactDBHelper(getActivity());
                            SQLiteDatabase database1 = contactDBHelper1.getWritableDatabase();
                            contactDBHelper1.addContact(Integer.parseInt(id1),name1,email1,per1,database1);
                            contactDBHelper1.close();


                            int temp2 = 70;
                            String id2 ="3";
                            String name2 ="Percetage";
                            String email2 =temp2+"";
                            String per2 = "pp";
                            //Writing the data
                            ContactDBHelper contactDBHelper2 = new ContactDBHelper(getActivity());
                            SQLiteDatabase database2 = contactDBHelper2.getWritableDatabase();
                            contactDBHelper2.addContact(Integer.parseInt(id2),name2,email2,per2,database2);
                            contactDBHelper2.close();
*/

/*
                            Toast.makeText(getActivity(), "Total days Saved", Toast.LENGTH_SHORT).show();




                            SharedPreferences.Editor editor = wmbPreference.edit();
                            editor.putBoolean("FIRSTRUN", false);
                            editor.commit();
                        }else{


                            Toast.makeText(getActivity(), "0ops...Already Done That!", Toast.LENGTH_SHORT).show();
                        }



         //               Intent intent = new Intent(Calculate_Month.this,
           //                     MainActivity.class);
                //                        startActivity(intent);


                    }//END of If loop1.1 ie aug- aug18

                }//END of If loop1.1 ie aug



            }   //btn last line abd the below'});' #tag_1
        });     //tag_1 means these go together

        onBackPressed();


        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                readcontact();


            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                updateContact();


            }
        });





        return view;
    }



    private static final String[] join = new String[]{"August","September","October","November","December"  ,
            "January'19", "February'19","March'19","April'19","May'19","June'19","July'19","August'19","September'19"
            ,"October'19","November'19","December'19"
    };


    private static final String[] endd = new String[]{"August","September","October","November","December"  ,
            "January'19", "February'19","March'19","April'19","May'19","June'19","July'19","August'19","September'19"
            ,"October'19","November'19","December'19"};

    //read the database

    private void readcontact()
    {
        ContactDBHelper contactDBHelper = new ContactDBHelper(getContext());
        SQLiteDatabase database = contactDBHelper.getReadableDatabase();

        Cursor cursor = contactDBHelper.readCOntact(database);
        String info= "";

        while (cursor.moveToNext())
        {
            String Id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String Name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String Email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            String Perc = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.PERCENT));
            info = info+"\n\n"+"Id   : "+Id+"\nName : "+Name+"\nEmail: "+Email+"\nPer   "+Perc+"\n";
        }

        read_id.setText(info);
        contactDBHelper.close();
    }


    private void readThings()
    {
        ContactDBHelper contactDBHelper = new ContactDBHelper(getContext());
        SQLiteDatabase database = contactDBHelper.getReadableDatabase();

        Cursor cursor = contactDBHelper.readCOntact(database);
        String info= "";

        String Name="";
        String Perc="";
        String Email="";

        while (cursor.moveToNext())
        {
            String Id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            Name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            Email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            Perc = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.PERCENT));
            info = info+"\n\n"+"Id   : "+Id+"\nName : "+Name+"\nEmail: "+Email+"\nPer   "+Perc+"\n";
        }

     totaldays = Integer.parseInt(Email);
        RU_Total=Email;
        read_total.setText(totaldays+" waht");

        bunk_days = Integer.parseInt(Name);
        RU_bunkdays=Name;
        read_bunked.setText(bunk_days+" BunkD");

        perk = Float.parseFloat(Perc);
        RU_Percent=Name;
        read_perse.setText(perk+" %");

        contactDBHelper.close();
    }




    public void updateContact()
    {

     //   int Id = Integer.parseInt(updateId.getText().toString());

        int Id = 1;
        String info="";
        String AbseEnterd = updateAbss.getText().toString();
        Log.d("okkkkkkkkkkk", "updateContact: Okkkkkkkk");


    //    int absent = Integer.parseInt(abss.getText().toString().trim());

        float absent = Float.parseFloat(AbseEnterd);
        float total = totaldays;
        float check = bunk_days;
        float abse =absent + check;
        float num= total-abse;
        float percc = num/ total;
        float hundrd = percc*100;
        float dash = absent + check;


        float percentt = percc*100;

        String PercentageF=percentt+"Prr";
        String BunkF=dash+"Brr";
        String TotalF=total+"Trr";

        ContactDBHelper contactDBHelper = new ContactDBHelper(getContext());
        SQLiteDatabase database = contactDBHelper.getReadableDatabase();
    //    contactDBHelper.updateCOntact(Id,Name,Emaill,per,database);

        contactDBHelper.updateCOntact(Id,BunkF,TotalF,PercentageF,database);

        info = info+"\n\n"+"Id   : "+Id+"\nbunk : "+dash+"\nTotal: "+total+"\nPer   "+PercentageF+"\n";


        Toast.makeText(getActivity(), "Result is", Toast.LENGTH_SHORT).show();

        update_id.setText(info);
        updateAbss.setText("");
        contactDBHelper.close();

    }






    public void onBackPressed() {
        if (exit) {
            getActivity().finish(); // finish activity
        } else {
            Toast.makeText(getActivity(), "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }





}


        */