package com.b4_downstairs.akash_madhu.navigationdrawe1;


import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class CalculateMonthFragment extends Fragment {

    //  private TextView read_id,update_id,read_total,read_bunked,read_perse;

    private static final String[] join = new String[]{"June", "July", "August", "September", "October", "November", "December",
            "January'19", "February'19", "March'19", "April'19", "May'19", "June'19", "July'19", "August'19", "September'19"
            , "October'19", "November'19", "December'19"
    };
    private static final String[] endd = new String[]{"June", "July", "August", "September", "October", "November", "December",
            "January'19", "February'19", "March'19", "April'19", "May'19", "June'19", "July'19", "August'19", "September'19"
            , "October'19", "November'19", "December'19"};
    int june = 21, july = 22, jjj = 43;
    int August = 23;
    int September = 43, October = 66, November = 88, December = 109, January19 = 132, February19 = 152, March19 = 173, April19 = 195, May19 = 218;
    int June19 = 238, July19 = 261, August19 = 283, September19 = 304, October19 = 327, November19 = 348, December19 = 370;
    private Boolean exit = false;


    public CalculateMonthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculate_month, container, false);

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun) {

            int trial = 1;
        } else {


            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);

        }


        Button btn = (Button) view.findViewById(R.id.btn);

        //autocomplete the space that the user must type in so that we'll get the exact word match for Calculation
        final AutoCompleteTextView actv1 = (AutoCompleteTextView) view.findViewById(R.id.actv1);
        final AutoCompleteTextView actv2 = (AutoCompleteTextView) view.findViewById(R.id.actv2);


        //autocompletion Image dropdown thing!
        ImageView image = (ImageView) view.findViewById(R.id.image);
        ImageView image1 = (ImageView) view.findViewById(R.id.image1);
        //these are for the arrays ie the two strings that are placed in the last of this prog file in wihch the autocomplete directory
        //takes place
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, join);
        actv1.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, endd);
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

                String startMonth = actv2.getText().toString().trim();
                String endMonth = actv1.getText().toString().trim();


//Aug to ___
                JuneToDash(startMonth, endMonth);
                JulyToDash(startMonth, endMonth);
                AugToDash(startMonth, endMonth);
                septToDash(startMonth, endMonth);
                octoToDash(startMonth, endMonth);
                novToDash(startMonth, endMonth);
                decoToDash(startMonth, endMonth);
                janIPToDash(startMonth, endMonth);
                febIPToDash(startMonth, endMonth);
                marIPToDash(startMonth, endMonth);
                aprilIPToDash(startMonth, endMonth);

                mayIPToDash(startMonth, endMonth);
                juneIPToDash(startMonth, endMonth);
                julyIPToDash(startMonth, endMonth);
                augIPToDash(startMonth, endMonth);
                septIPToDash(startMonth, endMonth);

                octoIPToDash(startMonth, endMonth);
                novoIPToDash(startMonth, endMonth);
                decoIPToDash(startMonth, endMonth);


            }   //btn last line abd the below'});' #tag_1
        });     //tag_1 means these go together

        return view;
    }

    public void findMonth(int temp) {

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);


        String id = "1";
        String name = "0";
        String email = temp + "";
        String per = "100";
        //Writing the data
        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
        SQLiteDatabase database = contactDBHelper.getWritableDatabase();
        contactDBHelper.addContact(Integer.parseInt(id), name, email, per, database);
        contactDBHelper.close();


        SharedPreferences.Editor editor = wmbPreference.edit();
        editor.putBoolean("FIRSTRUN", false);
        editor.commit();

    }

    public void JuneToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("June") == 0) {
            if (endMonth.compareTo("June") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = june;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);


            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("July") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 43;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("August") == 0) {

                //RUNs Only ONCE

                SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getActivity());
                boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);

                if (isFirstRun) {   //for ADDING Total_days in DATABASE
                    int temp = 23 + jjj;
                    String id = "1";
                    String name = "0";
                    String email = temp + "";
                    String per = "100";
                    //Writing the data
                    ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
                    SQLiteDatabase database = contactDBHelper.getWritableDatabase();
                    contactDBHelper.addContact(Integer.parseInt(id), name, email, per, database);
                    contactDBHelper.close();

                    Toast.makeText(getActivity(), "Working Days Created", Toast.LENGTH_SHORT).show();


                    SharedPreferences.Editor editor = wmbPreference.edit();
                    editor.putBoolean("FIRSTRUN", false);
                    editor.commit();
                }

//INTENT FRAG TO ACTIVITY

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- aug18
            else if (endMonth.compareTo("September") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 43 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("October") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 66 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- oct18
            else if (endMonth.compareTo("November") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 88 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- nov18

            else if (endMonth.compareTo("December") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 109 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- dec18

            else if (endMonth.compareTo("January'19") == 0) {
                //for ADDING Total_days in DATABASE

                int temp = 132 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- jan19

            else if (endMonth.compareTo("February'19") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 152 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- feb19

            else if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19" + jjj) == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 + jjj;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- dec19

        }//END of If loop1.1 ie aug
    }
//-------------------june done---------


    public void JulyToDash(String startMonth, String endMonth) {
        if (startMonth.compareTo("July") == 0) {

            if (endMonth.compareTo("July") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 22;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("August") == 0) {

                //RUNs Only ONCE

                SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getActivity());
                boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);

                if (isFirstRun) {   //for ADDING Total_days in DATABASE
                    int temp = 23 + 22;
                    String id = "1";
                    String name = "0";
                    String email = temp + "";
                    String per = "100";
                    //Writing the data
                    ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
                    SQLiteDatabase database = contactDBHelper.getWritableDatabase();
                    contactDBHelper.addContact(Integer.parseInt(id), name, email, per, database);
                    contactDBHelper.close();

                    Toast.makeText(getActivity(), "Working Days Created", Toast.LENGTH_SHORT).show();


                    SharedPreferences.Editor editor = wmbPreference.edit();
                    editor.putBoolean("FIRSTRUN", false);
                    editor.commit();
                }

//INTENT FRAG TO ACTIVITY

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- aug18
            else if (endMonth.compareTo("September") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 43 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("October") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 66 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- oct18
            else if (endMonth.compareTo("November") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 88 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- nov18

            else if (endMonth.compareTo("December") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 109 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- dec18

            else if (endMonth.compareTo("January'19") == 0) {
                //for ADDING Total_days in DATABASE

                int temp = 132 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- jan19

            else if (endMonth.compareTo("February'19") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 152 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- feb19

            else if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 + july;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- dec19

        }//END of If loop1.1 ie aug
    }
//-------------------july done---------


    public void AugToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("August") == 0) {

            if (endMonth.compareTo("August") == 0) {

                //RUNs Only ONCE

                SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getActivity());
                boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);

                if (isFirstRun) {   //for ADDING Total_days in DATABASE
                    int temp = 23;
                    String id = "1";
                    String name = "0";
                    String email = temp + "";
                    String per = "100";
                    //Writing the data
                    ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
                    SQLiteDatabase database = contactDBHelper.getWritableDatabase();
                    contactDBHelper.addContact(Integer.parseInt(id), name, email, per, database);
                    contactDBHelper.close();

                    Toast.makeText(getActivity(), "Working Days Created", Toast.LENGTH_SHORT).show();


                    SharedPreferences.Editor editor = wmbPreference.edit();
                    editor.putBoolean("FIRSTRUN", false);
                    editor.commit();
                }

//INTENT FRAG TO ACTIVITY

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- aug18
            else if (endMonth.compareTo("September") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 43;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("October") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 66;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- oct18
            else if (endMonth.compareTo("November") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 88;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- nov18

            else if (endMonth.compareTo("December") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 109;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- dec18

            else if (endMonth.compareTo("January'19") == 0) {
                //for ADDING Total_days in DATABASE

                int temp = 132;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- jan19

            else if (endMonth.compareTo("February'19") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 152;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- feb19

            else if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- dec19

        }//END of If loop1.1 ie aug
    }


//----------------------SEPTEMBER to DASH_________________________________________________________

    public void septToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("September") == 0) {

            if (endMonth.compareTo("August") == 0) {

                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();

            }//END of If loop1.1 ie aug- aug18
            else if (endMonth.compareTo("September") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 43 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("October") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 66 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- oct18
            else if (endMonth.compareTo("November") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 88 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- nov18

            else if (endMonth.compareTo("December") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 109 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- dec18

            else if (endMonth.compareTo("January'19") == 0) {
                //for ADDING Total_days in DATABASE

                int temp = 132 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- jan19

            else if (endMonth.compareTo("February'19") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 152 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- feb19

            else if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - August;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

        }//END of If loop1.1 ie sept
    }


    //----------------------SEPTEMBER to DASH_________________________________________________________

    public void octoToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("October") == 0) {

            if (endMonth.compareTo("August") == 0) {

                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();

            }//END of If loop1.1 ie aug- aug18
            else if (endMonth.compareTo("September") == 0) {

                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();

            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("October") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 66 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- oct18
            else if (endMonth.compareTo("November") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 88 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- nov18

            else if (endMonth.compareTo("December") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 109 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- dec18

            else if (endMonth.compareTo("January'19") == 0) {
                //for ADDING Total_days in DATABASE

                int temp = 132 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- jan19

            else if (endMonth.compareTo("February'19") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 152 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- feb19

            else if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - September;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

        }//END of If loop1.1 ie oct
    }

    //----------------------NOvember to DASH_________________________________________________________

    public void novToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("November") == 0) {

            if (endMonth.compareTo("August") == 0) {

                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();

            }//END of If loop1.1 ie aug- aug18
            else if (endMonth.compareTo("September") == 0) {

                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();

            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("October") == 0) {


                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();


            }//END of If loop1.1 ie aug- oct18
            else if (endMonth.compareTo("November") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 88 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- nov18

            else if (endMonth.compareTo("December") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 109 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- dec18

            else if (endMonth.compareTo("January'19") == 0) {
                //for ADDING Total_days in DATABASE

                int temp = 132 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- jan19

            else if (endMonth.compareTo("February'19") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 152 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- feb19

            else if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - October;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

        }//END of If loop1.1 ie nov
    }


    //----------------------DECEMBER to DASH_________________________________________________________

    public void decoToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("December") == 0) {

            if (endMonth.compareTo("August") == 0) {

                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();

            }//END of If loop1.1 ie aug- aug18
            else if (endMonth.compareTo("September") == 0) {

                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();

            }//END of If loop1.1 ie aug- sept18

            else if (endMonth.compareTo("October") == 0) {


                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();

            }//END of If loop1.1 ie aug- oct18
            else if (endMonth.compareTo("November") == 0) {

                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();

            }//END of If loop1.1 ie aug- nov18

            else if (endMonth.compareTo("December") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 109 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }//END of If loop1.1 ie aug- dec18

            else if (endMonth.compareTo("January'19") == 0) {
                //for ADDING Total_days in DATABASE

                int temp = 132 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- jan19

            else if (endMonth.compareTo("February'19") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 152 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- feb19

            else if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - November;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

        }//END of If loop1.1 ie DEC
    }

    //----------------------JAN19 to DASH_________________________________________________________

    public void janIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("January'19") == 0) {


            if (endMonth.compareTo("January'19") == 0) {
                //for ADDING Total_days in DATABASE

                int temp = 132 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- jan19

            else if (endMonth.compareTo("February'19") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 152 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- feb19

            else if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - December;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie JAN19
    }

    //----------------------Feb19 to DASH_________________________________________________________

    public void febIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("February'19") == 0) {


            if (endMonth.compareTo("February'19") == 0) {

                //for ADDING Total_days in DATABASE

                int temp = 152 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- feb19

            else if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - January19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie FEB19
    }


    //----------------------Mar19 to DASH_________________________________________________________

    public void marIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("March'19") == 0) {


            if (endMonth.compareTo("March'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 173 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - February19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie MAR19
    }

//---------------------------------APRIL19--------------------------------------------

    public void aprilIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("April'19") == 0) {


            if (endMonth.compareTo("April'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 195 - March19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 - March19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - March19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - March19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - March19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - March19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - March19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - March19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - March19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie MAR19
    }

    //---------------------------------MAY19--------------------------------------------

    public void mayIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("May'19") == 0) {


            if (endMonth.compareTo("May'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 218 - April19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - April19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - April19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - April19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - April19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - April19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - April19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - April19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie MAR19
    }


    //---------------------------------JUNE19--------------------------------------------

    public void juneIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("June'19") == 0) {


            if (endMonth.compareTo("June'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 238 - May19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - May19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - May19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - May19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - May19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - May19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - May19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie JUNE
    }

    //---------------------------------JULY19--------------------------------------------

    public void julyIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("July'19") == 0) {


            if (endMonth.compareTo("July'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 261 - June19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - June19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - June19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - June19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - June19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - June19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie JULY
    }


    //---------------------------------AUGUST19--------------------------------------------

    public void augIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("August'19") == 0) {


            if (endMonth.compareTo("August'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 283 - July19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - July19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - July19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - July19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - July19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie AUGUST19
    }

    //---------------------------------SEPT19--------------------------------------------

    public void septIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("September'19") == 0) {


            if (endMonth.compareTo("September'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 304 - August19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - August19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - August19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - August19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie SEPT19
    }


    //---------------------------------OCTO19--------------------------------------------

    public void octoIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("October'19") == 0) {


            if (endMonth.compareTo("October'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 327 - September19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - September19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - September19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie OCTO19
    }


    //---------------------------------NOVO19--------------------------------------------

    public void novoIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("November'19") == 0) {


            if (endMonth.compareTo("November'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 348 - October19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie aug- mar19
            else if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - October19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie nNOVO19
    }


    //---------------------------------DEC19--------------------------------------------

    public void decoIPToDash(String startMonth, String endMonth) {
        //Aug to ___
        if (startMonth.compareTo("December'19") == 0) {


            if (endMonth.compareTo("December'19") == 0) {


                //for ADDING Total_days in DATABASE

                int temp = 370 - November19;
                findMonth(temp);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }//END of If loop1.1 ie sept- dec19

            else {
                Toast.makeText(getActivity(), "Oops...Not Possible!", Toast.LENGTH_SHORT).show();
            }

        }//END of If loop1.1 ie DEC19
    }


}// LAST EOF xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
