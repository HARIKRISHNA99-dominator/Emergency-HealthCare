package com.example.healthandsocial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabseHandler extends SQLiteOpenHelper {
    public static final String DataBase_NAME = "mylist_db";
    public static final String TABLE_NAME = "mylist_data";
    public static final String col1 = "ID";
    public static final String col2 = "ITEM1";

public DatabseHandler(Context context){super(context,DataBase_NAME,null,1);}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createtable = "CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+"ITEM1 TEXT)";
        sqLiteDatabase.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
String a = "DROP TABLE IF EXISTS " +TABLE_NAME;
sqLiteDatabase.execSQL(a);
onCreate(sqLiteDatabase);
    }
    public boolean addData(String item1){

    SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2,item1);

        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getListContents(){
    SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

    Cursor data = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
    return data;
    }
}
