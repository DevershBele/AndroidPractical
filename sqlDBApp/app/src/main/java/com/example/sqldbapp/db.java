package com.example.sqldbapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class db extends SQLiteOpenHelper {
    public static final int Database_Version =1;
    private static final String Database_name ="Details";

    public db(Context context){ super(context,Database_name,null,Database_Version);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE userdetails(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
        "Name TEXT NOT NULL ,EmpPhone TEXT NOT NULL,Dpt TEXT NOT NULL"+ ") ";

        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

    }
}
