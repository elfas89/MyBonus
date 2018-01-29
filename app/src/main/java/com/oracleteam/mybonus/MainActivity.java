package com.oracleteam.mybonus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String TAG = "myLogs";

    private  static  int SPLASH_TIME_OUT = 8000;


// ПЫЩ!!
    // try to commit into WORKING matafakaz
    //22222
    //
    //from ands
    //FROM BRA4O
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);




//    CheckBox checkTermsAndCond = findViewById(R.id.checkTermsAndCond);
//    Button enterButton = findViewById(R.id.enterButton);





        String text = "";
        String link = getResources().getString(R.string.terms_and_conditions_link);
        String linkStart = " <a href='"+ link +"'> ";
        String linkEnd = " </a>";

        TextView textTermsAndCond = findViewById(R.id.textTermsAndCond);
        textTermsAndCond.setClickable(true);
        textTermsAndCond.setMovementMethod(LinkMovementMethod.getInstance());
//        text = "Agreee with <a href='http://www.google.com'> Google </a>";
//        text = getResources().getString((R.string.terms_and_conditions_link));

        text = getResources().getString(R.string.terms_and_conditions_part1) + linkStart + getResources().getString(R.string.terms_and_conditions_part2) + linkEnd;

        textTermsAndCond.setText(Html.fromHtml(text));







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
