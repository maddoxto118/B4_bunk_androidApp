package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class account_info_male extends AppCompatActivity {

    DecimalFormat formatterDays, formaterPerc;

    TextView male, toastt, dialog;
    EditText inputmale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        formaterPerc = new DecimalFormat("#0.0");

        male = findViewById(R.id.finfo_name);

        toastt = findViewById(R.id.percentt);

        dialog = findViewById(R.id.bunker);
        String jack = readcontactPer();
        float perkk = Float.parseFloat(jack);

        if (perkk > 95) {
            dialog.setText("High Roller!");
        } else if (perkk > 90) {
            dialog.setText("Keep Going bruh!");
        } else if (perkk > 80) {
            dialog.setText("ohh! Average Bunk'er");
        } else if (perkk < 80) {
            dialog.setText("Bunker's HOME!");
        }


        toastt.setText(formaterPerc.format(perkk) + "%");

        getMaleName();


    }


    public void getMaleName() {

        try {
            String Message;
            FileInputStream fileInputStream = openFileInput("name_male");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            while ((Message = bufferedReader.readLine()) != null) {
                stringBuffer.append(Message + "\n");
            }
            //SET TEXT TO DISPLAY
            male.setText(stringBuffer.toString());


            //              daysLeft = Integer.parseInt(stringBuffer.toString());
            //      tvleave.setVisibility(View.VISIBLE);
            //       firstDays=stringBuffer.toString().trim();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String readcontactPer() {
        ContactDBHelper contactDBHelper = new ContactDBHelper(this);
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
