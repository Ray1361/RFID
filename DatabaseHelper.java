package com.cybernaptics.rfidv3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context,"DatabaseNew.db", null, 1);
    }

    // create table user & table product;
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS user(email text PRIMARY KEY, password TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS prod(productID INTEGER PRIMARY KEY AUTOINCREMENT, prodName TEXT, prodWei TEXT, prodBin TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS bin(idBin INTEGER PRIMARY KEY AUTOINCREMENT, BIN_NAME TEXT, BIN_NUM TEXT);");
    }



    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists user;");
        db.execSQL("drop table if exists prod;");
        db.execSQL("drop table if exists bin;");
        onCreate(db);
    }

    //inserting user in table user
    public boolean insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("user", null, contentValues);
        if(ins ==-1) return false;
        else return true;
    }

    //insert product into table product
    public boolean productinsert(String prodName, String prodWei, String prodBin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("prodName",prodName);
        contentValues.put("prodWei",prodWei);
        contentValues.put("prodBin",prodWei);
        long ins = db.insert("prod", null, contentValues);
        if(ins ==-1) return  false;
        else return true;
    }

    //checking if email exists;
    public Boolean checkmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email =?;", new String[]{email});
        if (cursor.getCount()>0) return false;
        else return true;
    }

    // checking the email and password @ login;
    public Boolean emailpassword(String mail, String password1){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select  * from user where email=? and password=?;", new String[]{mail,password1});
        if (cursor.getCount()>0) return true;
        else return false;
    }

    //display all data for product
    public Cursor getProduct(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =  getReadableDatabase().rawQuery("select * from prod;", null);
        return cursor;
    }

}
