package com.oracleteam.mybonus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class ApplicationActivity extends AppCompatActivity {
    final String LOG_TAG = "MyLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
    }

    protected void showBarcodePage(View view){
        Intent intent = new Intent(this, BarcodeActivity.class);
        startActivity(intent);
    }

    protected void showLocationsPage(View view){
        Intent intent = new Intent(this, LocationsActivity.class);
        startActivity(intent);
    }

    protected void showDiscountPage(View view){
        Intent intent = new Intent(this, DiscountActivity.class);
        startActivity(intent);
    }


}
