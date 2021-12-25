package com.example.tpsqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbConnections extends SQLiteOpenHelper {
    private static String _name="MyDb";

    DbConnections(Context context){
        super(context,_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS clients(id integer primary key AUTOINCREMENT not null,"+
                "firstName text not null,lastName Text not null,mail text unique not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table IF EXISTS clients ");
        this.onCreate(db);
    }

    public void insertClientRow(String firstName,String lastName,String mail){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contVal=new ContentValues();
        contVal.put("firstName",firstName);
        contVal.put("lastName",lastName);
        contVal.put("mail",mail);
        db.insert("clients",null,contVal);
    }
    @SuppressLint("Range")
    public ArrayList displayAllClients(){
        ArrayList arr=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from clients",null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            arr.add(res.getString(res.getColumnIndex("id"))+":"+
                    res.getString(res.getColumnIndex("firstName"))+
                    ":"+res.getString(res.getColumnIndex("lastName"))+":"+
                    res.getString(res.getColumnIndex("mail")));
            res.moveToNext();
        }
        return arr;
    }
}
