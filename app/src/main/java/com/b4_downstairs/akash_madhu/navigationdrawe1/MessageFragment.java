package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

import br.com.bloder.magic.view.MagicButton;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class MessageFragment extends Fragment {

    AdView maddview;
    MagicButton Magic_btn;
    Button btnAbsent;
    String ru_bunkdays = "";
    String ru_Total = "";
    String ru_Percent = "";
    DecimalFormat formatterDays, formaterPerc;
    EditText updateAbss;
    int totaldays, bunk_days;
    float Percentage;
    private TextView show_text, side_text;
    private Boolean exit = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);


        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713\n");
        maddview = (AdView) view.findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        maddview.loadAd(adRequest);

        formatterDays = new DecimalFormat("#0");
        formaterPerc = new DecimalFormat("#0.0");

        show_text = view.findViewById(R.id.percentage1);
        side_text = view.findViewById(R.id.aad);

        updateAbss = view.findViewById(R.id.abss);

        btnAbsent = (Button) view.findViewById(R.id.plusTwo);


        Magic_btn = view.findViewById(R.id.magic_button);

        Magic_btn.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //FOR HIDING THE KEYBOARD After the button press
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                if (updateAbss.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter Bunk'd Days!", Toast.LENGTH_SHORT).show();
                } else {


                    updatePercentageData();
                    readStringfromDB();

                }

            }
        });


        readStringfromDB();
        float perkk = Float.parseFloat(ru_Percent);
        show_text.setText(formaterPerc.format(perkk) + "%");


        btnAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Making the EditText Field Not Empty

                if (updateAbss.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter all field", Toast.LENGTH_SHORT).show();
                } else {


                    updatePercentageData();
                    readStringfromDB();

                }


            }
        });


        return view;

    }//Last Line onCreate


    //##############################################################################################################################

    public void updatePercentageData() {


        int Id = 1;
        String info = "";

        int absent = Integer.parseInt(updateAbss.getText().toString().trim());

        float total = Float.parseFloat(ru_Total.trim());

        float check = Float.parseFloat(ru_bunkdays.trim());

        float abse = absent + check;
        float num = total - abse;

        float percc = num / total;
        float hundrd = percc * 100;

        if (hundrd < 0) {
            Toast.makeText(getActivity(), "Sorry Not Possible!", Toast.LENGTH_SHORT).show();
        } else {

            // float dash = absent;// + bunk_days;

            String PercentageF = hundrd + "";
            String BunkF = abse + "";
            String TotalF = total + "";

            ContactDBHelper contactDBHelper = new ContactDBHelper(getContext());
            SQLiteDatabase database = contactDBHelper.getReadableDatabase();
            //    contactDBHelper.updateCOntact(Id,Name,Emaill,per,database);


            contactDBHelper.updateCOntact(Id, BunkF, TotalF, PercentageF, database);

            info = info + "\n\n" + "Id   : " + Id + "\nbunk : " + abse + "\nTotal: " + total + "\nPer   " + PercentageF + "\n";


            //       Toast.makeText(getActivity(), "Result Compiled", Toast.LENGTH_SHORT).show();

            side_text.setText(info);
            show_text.setText(PercentageF);
            float perkk = Float.parseFloat(PercentageF);
            show_text.setText(formaterPerc.format(perkk) + "%");
            updateAbss.setText("");
            contactDBHelper.close();
        }

    }


    public void readStringfromDB() {
        ru_Total = readcontactTot();
        ru_bunkdays = readcontactBunk();
        ru_Percent = readcontactPer();

    }


    public String readcontactTot() {
        ContactDBHelper contactDBHelper = new ContactDBHelper(getContext());
        SQLiteDatabase database = contactDBHelper.getReadableDatabase();

        Cursor cursor = contactDBHelper.readCOntact(database);
        String info = "";
        String a = ";";
        String b = "";
        String c = "";

        while (cursor.moveToNext()) {
            String Id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            a = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            b = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            c = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.PERCENT));
            info = info + "\n\n" + "Id   : " + Id + "\nName : " + a + "\nEmail: " + b + "\nPer   " + c + "\n";
        }


        contactDBHelper.close();

        return b;
    }


    public String readcontactBunk() {
        ContactDBHelper contactDBHelper = new ContactDBHelper(getContext());
        SQLiteDatabase database = contactDBHelper.getReadableDatabase();

        Cursor cursor = contactDBHelper.readCOntact(database);
        String info = "";
        String a = ";";
        String b = "";
        String c = "";

        while (cursor.moveToNext()) {
            String Id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            a = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            b = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            c = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.PERCENT));
            info = info + "\n\n" + "Id   : " + Id + "\nName : " + a + "\nEmail: " + b + "\nPer   " + c + "\n";
        }


        contactDBHelper.close();

        return a;
    }


    public String readcontactPer() {
        ContactDBHelper contactDBHelper = new ContactDBHelper(getContext());
        SQLiteDatabase database = contactDBHelper.getReadableDatabase();

        Cursor cursor = contactDBHelper.readCOntact(database);
        String info = "";
        String a = ";";
        String b = "";
        String c = "";

        while (cursor.moveToNext()) {
            String Id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            a = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            b = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            c = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.PERCENT));
            info = info + "\n\n" + "Id   : " + Id + "\nName : " + a + "\nEmail: " + b + "\nPer   " + c + "\n";
        }


        contactDBHelper.close();

        return c;
    }


}//Last Line Message FRAG  EOF  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
