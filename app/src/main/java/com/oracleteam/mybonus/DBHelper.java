package com.oracleteam.mybonus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.oracleteam.mybonus.SmsActivity.LOG_TAG;

/**
 * Created by ranokf on 17.02.18.
 */

class DBHelper extends SQLiteOpenHelper {


        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table aid_user ("
                    + "user_id integer primary key autoincrement,"
                    + "barcode text,"
                    + "phone1 text,"
                    + "phone2 text,"
                    + "phone3 text,"
                    + "name text,"
                    + "last_name text,"
                    + "middle_name text,"
                    + "amount integer,"
                    + "discount integer,"
                    + "attribute1 text,"
                    + "attribute2 text,"
                    + "attribute3 text,"
                    + "attribute4 text,"
                    + "attribute5 text,"
                    + "last_date date,"
                    + "registration_date date"
                    + ");");
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(LOG_TAG, "--- onUpgrade database ---");
    }
}
