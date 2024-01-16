package com.example.sqldbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,phone,dpt;
    Button save,display;
    TextView namedis,phonedis,dptdis;
    SQLiteDatabase db1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        name =(EditText) findViewById(R.id.name);
        phone =(EditText) findViewById(R.id.phone);
        dpt =(EditText) findViewById(R.id.dpt);

        save =(Button) findViewById(R.id.save);
        display =(Button) findViewById(R.id.display);

         namedis =(TextView) findViewById(R.id.named);
         phonedis =(TextView) findViewById(R.id.phoned);
         dptdis =(TextView) findViewById(R.id.deptd);



        super.onCreate(savedInstanceState);

        db obj =new db(this);
        db1 = obj.getWritableDatabase();



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerUser();
            }


        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db1 = openOrCreateDatabase("table",MODE_PRIVATE,null);
                String selectQuery = "SELECT * FROM userdetails";
                Cursor cursor = db1.rawQuery(selectQuery,null);

                if(cursor != null){
                    cursor.moveToFirst();
                    startManagingCursor(cursor);
                    while(!cursor.isAfterLast()){
                        String n = cursor.getString(1);
                        String no = cursor.getString(2);
                        String de = cursor.getString(3);
                        String Observation1 = "Name of the Employee: "+n;
                        String Observation2 = "Employee Number: "+no;
                        String Observation3 = "Department: "+de;
                        namedis.setText(Observation1);
                        phonedis.setText(Observation2);
                        dptdis.setText(Observation3);
                        Toast.makeText(getApplicationContext(),"Data is displayed of ", Toast.LENGTH_SHORT).show();
                        cursor.moveToNext();
                    }
                }
            }

        });
    }
    private void registerUser() {
        String na,ph,dt;
        db objdata =new db(this);

        na = name.getText().toString();
        ph = phone.getText().toString();
        dt = dpt.getText().toString();

        ContentValues values = new ContentValues();

        values.put("Name",na);
        values.put("Phone Number",ph);
        values.put("DEPARTMENT", dt);

        long ID =db1.insert("Details",null,values);
        Toast.makeText(MainActivity.this,"No of Records "+ ID,Toast.LENGTH_LONG).show();
        objdata.close();

    }
}