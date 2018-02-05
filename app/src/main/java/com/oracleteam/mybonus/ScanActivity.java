package com.oracleteam.mybonus;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;



public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler
{
    private ZXingScannerView mScannerView;
    public static String LOG_TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_scan);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
        Log.d(LOG_TAG, "GO");
      //  Toast.makeText(this, "GO!!!!", Toast.LENGTH_LONG).show();

    }

//    protected void returnBarcode() {
//
//        EditText barcode = findViewById(R.id.barcode);
//
//        Intent intent = new Intent();
//        intent.putExtra("barcode", barcode.getText().toString());
//        setResult(RESULT_OK, intent);
//        finish();
//    }


    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume


    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
        Log.d(LOG_TAG, "onPause");

    }

    @Override
    public void handleResult(Result rawResult) {

        // Do something with the result here
        Log.d(LOG_TAG, rawResult.getText()); // Prints scan results
        Log.d(LOG_TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        // If you would like to resume scanning, call this method below:
       // mScannerView.resumeCameraPreview(this);

        Intent intent = new Intent();
        intent.putExtra("barcode", rawResult.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

    }

}
