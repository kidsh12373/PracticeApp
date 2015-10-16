package com.example.practiceapp3;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper
{

    private static final String DATABASE = "Register1.db";
    private static final int DATABASE_VER = 1;
    private static final String DATATABLE = "data1";
    private static final String COL_NAME = "name";
    private static final String COL_PASS = "pass";
    private static final String COL_DOB = "dob";
    private static final String COL_DESIGNATION = "designation";
    private static final String COL_PHONE = "phone";

	public DBhelper(Context context) {
		super(context, DATABASE, null, DATABASE_VER);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

        String CREATE_TABLE = "CREATE TABLE " + DATATABLE + "(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME
                + " VARCHAR, " + COL_PASS + " VARCHAR, " + COL_DOB + " VARCHAR, " + COL_DESIGNATION + " VARCHAR, "
                + COL_PHONE + " VARCHAR " + ")";
        db.execSQL(CREATE_TABLE);
	}
	
    public void insertData(String name, String pass, String dob, String designation, String phone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_PASS, pass);
        values.put(COL_DOB, dob);
        values.put(COL_DESIGNATION, designation);
        values.put(COL_PHONE, phone);
        db.insert(DATATABLE, null, values);
        db.close();
    }


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	
	}

    public Cursor IsValid(String name, String pass) {
        // TODO Auto-generated method stub
        String sql = "select name,pass from " + DATATABLE + " where " + COL_NAME + " = '" + name + "' and " + COL_PASS
                + " = '" + pass + "'";
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        return cursor;
    }
    public ArrayList<userInfo> retriveBasicInfo(String name) {
        // TODO Auto-generated method stub

        ArrayList<userInfo> arrayList = new ArrayList<userInfo>();
        userInfo info;
        String retrive = "select dob,designation,phone from " + DATATABLE + " where " + COL_NAME + " = '" + name + "' ";
        final Cursor cursor = getWritableDatabase().rawQuery(retrive, null);

        if (cursor != null) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                info = new userInfo();
                info.setDob(cursor.getString(cursor.getColumnIndex("dob")));
                info.setDesignation(cursor.getString(cursor.getColumnIndex("designation")));
                info.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                arrayList.add(info);
                cursor.moveToNext();
            }

        }
        cursor.close();
        SQLiteDatabase.releaseMemory();

        return arrayList;
    }

	
}
