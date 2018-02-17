package com.oracleteam.mybonus;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class WelcomeActivity extends AppCompatActivity {
    final String LOG_TAG = "MyLogs";

    DBHelper dbHelper;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //start MainActivity and finish splash screen
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();

        boolean LOGIN = false;

        Log.d(LOG_TAG, "before new DBHelper");

        // создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(this);

        Log.d(LOG_TAG, "after new DBHelper");

        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Log.d(LOG_TAG, "after conn to DB");


        //try to select this shit
        // делаем запрос всех данных из таблицы aid_user, получаем Cursor
        Cursor c = db.query("aid_user", null, null, null, null, null, null);

        Log.d(LOG_TAG, String.valueOf(c.getCount()));

        int count = c.getCount();

        if(count == 0){
            LOGIN = false;
        } else {
            LOGIN = true;
        }



        // закрываем подключение к БД
        dbHelper.close();

        ////////////////////////////////////////////////
        /*get login state from database here!!!!!!!!!!*/
        ///////////////////////////////////////////////

//        LOGIN = false;


        Intent intent;

        if (LOGIN){
            Log.d(LOG_TAG, "go to the app page ");
            intent = new Intent(this, ApplicationActivity.class);
        }
        else{
            Log.d(LOG_TAG, "go to the login(Main) page ");
            intent = new Intent(this, MainActivity.class);
        }

        startActivity(intent);
        finish();

    }
}
