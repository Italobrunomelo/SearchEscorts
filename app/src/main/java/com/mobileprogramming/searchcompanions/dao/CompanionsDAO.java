package com.mobileprogramming.searchcompanions.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mobileprogramming.searchcompanions.Companions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 17/05/2017.
 */

public class CompanionsDAO extends SQLiteOpenHelper {

    public CompanionsDAO(Context context) {
        super(context, "Search Companions", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Companions (name TEXT NOT NULL, information TEXT NOT NULL, " +
                "contact TEXT NOT NULL, location TEXT NOT NULL, status CHAR NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Companions;";
        db.execSQL(sql);
        onCreate(db);
    }

    //INSERT
    public void insert(Companions companions){
        String sql = "INSERT INTO Companions (name,email,phone) VALUES ('" +companions.getmName()+"','"+companions.getmInformation()+"','"+companions.getmContact()+"','"+companions.getmLocation()+"','"+companions.getmStatus()+"');";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    //GetAllCompanions
    public List<Companions> getAllCompanions(){
        String sql = "SELECT * FROM Companions;";
        SQLiteDatabase sqLiteDb = getReadableDatabase();
        Cursor cursor = sqLiteDb.rawQuery(sql, null);
        List<Companions> companion = new ArrayList<Companions>();

        while(cursor.moveToNext()){
            Companions companions = new Companions();
            companions.setmName(cursor.getString(cursor.getColumnIndex("name")));
            companions.setmInformation(cursor.getString(cursor.getColumnIndex("information")));
            companions.setmContact(cursor.getString(cursor.getColumnIndex("contact")));
            companions.setmLocation(cursor.getString(cursor.getColumnIndex("location")));
            companions.setmStatus(cursor.getString(cursor.getColumnIndex("status")));
            companion.add(companions);
        }

        sqLiteDb.close();

        return companion;
    }
}