package com.mobileprogramming.luxurygirl.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.renderscript.Sampler;

import com.mobileprogramming.luxurygirl.model.Girls;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

/**
 * Created by italo on 17/05/2017.
 */

public class GirlsDAO extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbLuxuryGirls";
    private static final String TABELA = "Girls";
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String INFORMATION_GIRL = "information";
    private static final String CONTACT = "contact";
    private static final String STATUS = "status";
    private static final String[] COLUNAS = {NAME, AGE, INFORMATION_GIRL, CONTACT, STATUS};

    public GirlsDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE '" + TABELA + "' ('" + EMAIL + "' TEXT NOT NULL, '" + NAME + "' TEXT NOT NULL, '" + AGE + "' TEXT NOT NULL, '" + INFORMATION_GIRL + "' TEXT NOT NULL, '" + CONTACT + "' TEXT NOT NULL, '" + STATUS + "' TEXT NOT NULL, imagem BOLB);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS '" + TABELA + "';";
        db.execSQL(sql);
        onCreate(db);
    }

    //INSERT
    public void insert(Girls girls) {
        /*String sql = "INSERT INTO Girls (name,age,information,contact,status,imagem) VALUES ('" + girls.getmName() + "','" + girls.getmAge() + "','" + girls.getmInformation() + "','" + girls.getmContact() + "','" + girls.getmStatus() + "','" + girls.getmImagem() + "');";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();*/

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL, girls.getmEmail());
        values.put(NAME, girls.getmName());
        values.put(AGE, girls.getmAge());
        values.put(INFORMATION_GIRL, girls.getmInformation());
        values.put(CONTACT, girls.getmContact());
        values.put(STATUS, girls.getmStatus());
        values.put("imagem", girls.getmImagem());
        db.insert(TABELA, null, values);
        db.close();
    }

    // TESTAR!!!!!!!!!!!!!
    public String updateGirl(Girls girls) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String name;
        if (girls.getmImagem() != null) {
            values.put(EMAIL, girls.getmEmail());
            values.put(NAME, girls.getmName());
            values.put(AGE, girls.getmAge());
            values.put(INFORMATION_GIRL, girls.getmInformation());
            values.put(CONTACT, girls.getmContact());
            values.put(STATUS, girls.getmStatus());
            values.put("imagem", girls.getmImagem());

            name = valueOf(db.update(TABELA, values, NAME + " = ?", new String[]{girls.getmName()}));
            db.insert(TABELA, null, values);
            db.close();
        } else {
            values.put(EMAIL, girls.getmEmail());
            values.put(NAME, girls.getmName());
            values.put(AGE, girls.getmAge());
            values.put(INFORMATION_GIRL, girls.getmInformation());
            values.put(CONTACT, girls.getmContact());
            values.put(STATUS, girls.getmStatus());

            name = valueOf(db.update(TABELA, values, NAME + " = ?", new String[]{girls.getmName()}));
            db.insert(TABELA, null, values);
            db.close();
        }
        return name;
    }

    //DELETE
    public String delete(String email) {
        String sql = "DELETE FROM '" + TABELA + "' WHERE '" + EMAIL + "' = '" + email + "';";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();

        return email;
    }

    //BUSCAR UMA GIRL
    public Girls getGirl(String email) {
        String sql = "SELECT * FROM '" + TABELA + "' WHERE '" + EMAIL + "' = '" + email + "';";

        SQLiteDatabase sqLiteDb = getReadableDatabase();
        Cursor cursor = sqLiteDb.rawQuery(sql, null);

        if (cursor == null) {
            sqLiteDb.close();

            return null;

        } else {
            Girls girls = new Girls();
            girls.setmEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
            girls.setmName(cursor.getString(cursor.getColumnIndex(NAME)));
            girls.setmAge(cursor.getString(cursor.getColumnIndex(AGE)));
            girls.setmInformation(cursor.getString(cursor.getColumnIndex(INFORMATION_GIRL)));
            girls.setmContact(cursor.getString(cursor.getColumnIndex(CONTACT)));
            girls.setmStatus(cursor.getString(cursor.getColumnIndex(STATUS)));
            girls.setmImagem(cursor.getBlob(cursor.getColumnIndex("imagem")));

            sqLiteDb.close();

            return girls;
        }
    }

    //BUSCAR TODAS AS GIRLS
    public List<Girls> getAllGirls() {
        String sql = "SELECT * FROM '" + TABELA + "';";
        SQLiteDatabase sqLiteDb = getReadableDatabase();
        Cursor cursor = sqLiteDb.rawQuery(sql, null);

        List<Girls> girl = new ArrayList<Girls>();
        while (cursor.moveToNext()) {
            Girls girls = new Girls();
            girls.setmEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
            girls.setmName(cursor.getString(cursor.getColumnIndex(NAME)));
            girls.setmAge(cursor.getString(cursor.getColumnIndex(AGE)));
            girls.setmInformation(cursor.getString(cursor.getColumnIndex(INFORMATION_GIRL)));
            girls.setmContact(cursor.getString(cursor.getColumnIndex(CONTACT)));
            girls.setmStatus(cursor.getString(cursor.getColumnIndex(STATUS)));
            girls.setmImagem(cursor.getBlob(cursor.getColumnIndex("imagem")));
            girl.add(girls);
        }
        sqLiteDb.close();
        return girl;
    }
}