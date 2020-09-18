package com.mypet.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "Animal.db";
    public final static int VERSION = 1;
    public final static String TABLE_NAME = "Animal_table";
    public final static String COL_1 = "ID";
    public final static String COL_2 = "Name";
    public final static String COL_3 = "Type";
    public final static String COL_4 = "State";

    public ArrayList<String> petNames = new ArrayList<String>();


    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE_NAME+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,TYPE TEXT,STATE TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String type, String state){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,type);
        contentValues.put(COL_4,state);
        long result =  db.insert(TABLE_NAME, null,contentValues);
        if (result== -1){
            return false;
        }else return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
