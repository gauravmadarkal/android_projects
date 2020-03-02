package com.gauravm.booksdbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by USER on 21-06-2017.
 */

public class databasehelper extends SQLiteOpenHelper {
    //create variables for storing the database parameters
    private static final int DATABASEVERSION = 1;
    private static final String DATABASENAME = "booksdb";
    public static final String TABLENAME = "bookdetails";
    public static final String KEYID = "_id";
    public static final String KEYAUTHORNAME = "author";
    public static final String KEYBOOKNAME = "bookname";
    public static final String KEYPUBLISHER = "publisher";


    public databasehelper(Context context) {
        //pass the db name and version to the parent class
        //1.constructor for creating database in internal storage
        //super(context, DATABASENAME, null, DATABASEVERSION);
        //2.constructor to create database in external storage
        super(context,
                context.getExternalFilesDir(null).getAbsolutePath()+"/"+DATABASENAME,
                null,
                DATABASEVERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strcreatequery = "CREATE TABLE " + TABLENAME
                + " ("
                + KEYID + " integer primary key,"
                + KEYAUTHORNAME + " text,"
                + KEYBOOKNAME + " text,"
                + KEYPUBLISHER + " text)";
        db.execSQL(strcreatequery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists" + TABLENAME);
        onCreate(db);
    }

    public void addbooks(String author, String bookname, String publisher) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEYAUTHORNAME, author);
        cv.put(KEYBOOKNAME, bookname);
        cv.put(KEYPUBLISHER, publisher);
        db.insert(TABLENAME, null, cv);
        db.close();
    }
    public Cursor getallbooks(){
        SQLiteDatabase db =this.getReadableDatabase();
      //create the query to fetch all records from table
        String strselectquery="SELECT * FROM "+TABLENAME;
        //pass the query to rawQuery which returns a cursor object
        Cursor mcursor=db.rawQuery(strselectquery,null);
        //check if cursor is null if not then move the cursor
        //to first position
        if(mcursor!=null)
        {mcursor.moveToFirst();}
        return mcursor;

    }
    public void deleteEntry(long row){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLENAME,KEYID+"="+row,null);
    }
    public void updateEntry(long row,String book,String author,String publisher){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        //these fields should be your string variables of
        //the changed values
        cv.put(KEYBOOKNAME,book);
        cv.put(KEYAUTHORNAME,author);
        cv.put(KEYPUBLISHER,publisher);
        db.update(TABLENAME, cv, "_id="+row, null);
    }

}