package com.b4_downstairs.akash_madhu.navigationdrawe1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bfourbunk.db";

    public static final String CREATE_TABLE = "create table " + ContactContract.ContactEntry.TABLE_NAME +
            "(" + ContactContract.ContactEntry.CONTACT_ID + " number," + ContactContract.ContactEntry.NAME + " text," +
            ContactContract.ContactEntry.EMAIL + " text," + ContactContract.ContactEntry.PERCENT + " text);";

    public static final String DROP_TABLE = "drop table if exists " + ContactContract.ContactEntry.TABLE_NAME;


    public ContactDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operation", "Database Created... ");
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Database operation", "onCreate: Database Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
        Log.d("Database operation", "onCreate: Database UPdate!");

    }

    public void addContact(int id, String name, String email, String percent, SQLiteDatabase database) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.CONTACT_ID, id);
        contentValues.put(ContactContract.ContactEntry.NAME, name);
        contentValues.put(ContactContract.ContactEntry.EMAIL, email);
        contentValues.put(ContactContract.ContactEntry.PERCENT, percent);

        database.insert(ContactContract.ContactEntry.TABLE_NAME, null, contentValues);
        Log.d("Database operation", "add contact a row created");

    }

    public Cursor readCOntact(SQLiteDatabase database) {
        String[] projections = {ContactContract.ContactEntry.CONTACT_ID,
                ContactContract.ContactEntry.NAME,
                ContactContract.ContactEntry.EMAIL,
                ContactContract.ContactEntry.PERCENT};

        Cursor cursor = database.query(ContactContract.ContactEntry.TABLE_NAME,
                projections, null, null, null, null, null);

        return cursor;
    }


    public void updateCOntact(int id, String name, String email, String percent, SQLiteDatabase database) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactContract.ContactEntry.NAME, name);
        contentValues.put(ContactContract.ContactEntry.EMAIL, email);
        contentValues.put(ContactContract.ContactEntry.PERCENT, percent);

        String selection = ContactContract.ContactEntry.CONTACT_ID + "=" + id;

        database.update(ContactContract.ContactEntry.TABLE_NAME, contentValues, selection, null);
        ;
    }


}
