package com.example.healthandsocial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1;
    ListView listview;
    SQLiteOpenHelper s1;
    SQLiteDatabase sqlitedb;
    DatabseHandler myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e1 = findViewById(R.id.phone);
        b1 = findViewById(R.id.add);
        b2 = findViewById(R.id.delete);
        b3 = findViewById(R.id.view);
        listview = findViewById(R.id.list);

        myDB= new DatabseHandler(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sr = e1.getText().toString();
                addData(sr);
                Toast.makeText(Register.this,"Data Added Successfully",Toast.LENGTH_LONG).show();
                e1.setText("");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlitedb = myDB.getWritableDatabase();
                String x = e1.getText().toString();
                DeleteData(x);
                Toast.makeText(Register.this,"Data Deleted Successfully",Toast.LENGTH_LONG).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
    }

    private void loadData() {
        ArrayList<String>theList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if(data.getCount()==0){
            Toast.makeText(Register.this,"THERE IS NO DATA",Toast.LENGTH_LONG).show();
        }
        else{
            while (data.moveToNext()){
                theList.add(data.getString(1));
                ArrayAdapter listAdapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listview.setAdapter((android.widget.ListAdapter) listAdapter);
            }
        }
    }

    private int DeleteData(String x) {

       return sqlitedb.delete(DatabseHandler.TABLE_NAME, DatabseHandler.col2 + "=?", new String[]{x});
    }

    private void addData(String newEntry) {
        boolean insertData = myDB.addData(newEntry);
        if(insertData==true){
            Toast.makeText(Register.this,"Data Enrolled",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(Register.this,"DATA Not Enrolled",Toast.LENGTH_LONG).show();
        }
    }
}