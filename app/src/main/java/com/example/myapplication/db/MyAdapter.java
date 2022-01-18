package com.example.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyAdapter {
    // DB name
    public static final String DATABASE_NAME = "chetu";

    //Table name
    public static final String TABLE_NAME = "trainee";

    //DB Version
    public static final int DB_VERSION = 1;

    // Table Columns name
    public static final String COL_ROW = "serialNo";
    public static final String COL_PHOTO = "photo";
    public static final String COL_FNAME = "fname";
    public static final String COL_LNAME = "lname";
    public static final String COL_PHONE = "phone";
    public static final String COL_EMAIL = "email";

//    "CAREATE TABLE trainee(col1 dataType, col1 dataType, col1 dataType, col1 dataType, col1 dataType)"

    String createDB = "CREATE TABLE "+TABLE_NAME+" ("+COL_ROW+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_PHOTO+" text, "+COL_FNAME+" text, "+COL_LNAME+" text, "+COL_PHONE+" text, "+COL_EMAIL+" text"+")";

    private SQLiteDatabase sqLiteDatabase;
    private MyDatabase myDatabase;
    public MyAdapter(Context context){
        myDatabase = new MyDatabase(context);
    }

    public MyAdapter openDatabase(){
        sqLiteDatabase = myDatabase.getWritableDatabase();
        return this;
    }




    public class MyDatabase extends SQLiteOpenHelper{

        public MyDatabase(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(createDB);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
