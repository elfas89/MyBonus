package com.oracleteam.mybonus;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String TAG = "myLogs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//    CheckBox checkTermsAndCond = findViewById(R.id.checkTermsAndCond);
//    Button enterButton = findViewById(R.id.enterButton);


    }



    protected void scanCardRun(View view){
//        System.out.println("scanCardRun launches HERE");
//        Log.d(TAG, "scanCardRun launches HERE");
//        Toast.makeText(this, "scanCardRun launches HERE", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, ScanActivity.class);
        startActivity(intent);
    }


    protected void changeEnterButton(View view){
//        System.out.println("check this flag and changeEnterButton HERE");
//        Log.d(TAG, "check this flag and changeEnterButton HERE");
//        Toast.makeText(this, "check this flag and changeEnterButton HERE", Toast.LENGTH_LONG).show();

        CheckBox checkTermsAndCond = findViewById(R.id.checkTermsAndCond);
        Button enterButton = findViewById(R.id.enterButton);


        int colorGray = getResources().getColor(R.color.colorGray);
        int colorPurple = getResources().getColor(R.color.colorPurple);

        boolean i = checkTermsAndCond.isChecked();
        if (i == true) {
            enterButton.setEnabled(true);
            enterButton.setBackgroundColor(colorPurple);
        } else {
            enterButton.setEnabled(false);
            enterButton.setBackgroundColor(colorGray);
        }

    }


    protected void enterApplication(View view){
        Intent intent = new Intent(this, ApplicationActivity.class);
        startActivity(intent);
    }

}
