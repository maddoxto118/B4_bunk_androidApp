package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ChatFragment extends Fragment {

    String stat_bunkdays = "";
    String stat_Total = "";
    String stat_Percent = "";
    DecimalFormat formatterDays, formaterPerc;

    private TextView show_text, show_bunk, show_perk;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stat, container, false);

        String info = "";
        show_text = view.findViewById(R.id.tvStats);
        show_bunk = view.findViewById(R.id.tvStats1);
        show_perk = view.findViewById(R.id.tvStats2);

        formatterDays = new DecimalFormat("#0");
        formaterPerc = new DecimalFormat("#0.0");

        readStringfromDB();

        float a, b, c;
        float st_t = Float.parseFloat(stat_Total);
        float st_bd = Float.parseFloat(stat_bunkdays);
        float st_perk = Float.parseFloat(stat_Percent);

        info = info + "\n\n" + "Total Days  :" + formatterDays.format(st_t) + "\nBunk Days  :" + formatterDays.format(st_bd) + "\nPercentage :" + formaterPerc.format(st_perk) + "%\n";

        show_text.setText("Total Days  : " + formatterDays.format(st_t));
        show_bunk.setText("Bunk Days  : " + formatterDays.format(st_bd));
        show_perk.setText("Percentage : " + formaterPerc.format(st_perk) + "%");
        return view;
    }


    public void readStringfromDB() {
        stat_Total = readcontactTot();
        stat_bunkdays = readcontactBunk();
        stat_Percent = readcontactPer();

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
            info = info + "\n\n" + "Total Days :" + b + "\n     Bunk'd Days: " + a + "\n     Percentage :" + c + "%\n";
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


}
