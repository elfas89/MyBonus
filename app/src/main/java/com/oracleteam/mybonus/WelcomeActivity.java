package com.oracleteam.mybonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class WelcomeActivity extends AppCompatActivity {
    final String LOG_TAG = "MyLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //start MainActivity and finish splash screen
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();

        boolean LOGIN = false;

        ////////////////////////////////////////////////
        /*get login state from database here!!!!!!!!!!*/
        ///////////////////////////////////////////////


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
