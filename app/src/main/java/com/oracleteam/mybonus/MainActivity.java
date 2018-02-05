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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    final int PHONE_NUMBER_LENGTH = 10;
    final int BARCODE_LENGTH = 13;

    protected  static  final String TO_VALIDATE = "com.oracleteam.mybonus.MESSAGE";



// do not need any comments here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//    CheckBox checkTermsAndCond = findViewById(R.id.checkTermsAndCond);
//    Button enterButton = findViewById(R.id.enterButton);




        // Terms and Conditions

        // v1 - link
//        String text = "";
//        String link = getResources().getString(R.string.terms_and_conditions_link);
//        String linkStart = " <a href='"+ link +"'> ";
//        String linkEnd = " </a>";
//
//        TextView textTermsAndCond = findViewById(R.id.textTermsAndCond);
//        textTermsAndCond.setClickable(true);
//        textTermsAndCond.setMovementMethod(LinkMovementMethod.getInstance());
////        text = "Agreee with <a href='http://www.google.com'> Google </a>";
////        text = getResources().getString((R.string.terms_and_conditions_link));
//
//        text = getResources().getString(R.string.terms_and_conditions_part1) + linkStart + getResources().getString(R.string.terms_and_conditions_part2) + linkEnd;
//
//        textTermsAndCond.setText(Html.fromHtml(text));


        // v2 - json, activity
        //made via onClick for now



    }

    protected void showAgreement(View view){
        Intent intent = new Intent(this, AgreementActivity.class);
        startActivity(intent);
    }



    protected void scanCardRun(View view){
//        System.out.println("scanCardRun launches HERE");
//        Log.d(TAG, "scanCardRun launches HERE");
//        Toast.makeText(this, "scanCardRun launches HERE", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, ScanActivity.class);
        //startActivity(intent);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String barcode = data.getStringExtra("barcode");

        TextView cardNumber = findViewById(R.id.cardNumber);
        cardNumber.setText(barcode);
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



        // bunch of validations here
        EditText phoneNumber = findViewById(R.id.phoneNumber);
        TextView cardNumber = findViewById(R.id.cardNumber);

        int phoneNumberLength = phoneNumber.getText().length();
        int cardNumberLength = cardNumber.getText().length();

        Log.d(LOG_TAG, "phoneNumberLength: " + phoneNumberLength);
        Log.d(LOG_TAG, "cardNumberLength: " + cardNumberLength); //check for XXXs!


        // ....



        // need to validate user and phone via sms
        Intent intent = new Intent(this, SmsActivity.class);
        startActivity(intent);



        // Do something in response to button
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);

    }

}
