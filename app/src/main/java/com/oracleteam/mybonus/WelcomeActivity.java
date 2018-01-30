package com.oracleteam.mybonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //start MainActivity and finish splash screen
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


    }
}
