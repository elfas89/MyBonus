package com.oracleteam.mybonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);



    }


    protected void returnBarcode(View view) {

        EditText barcode = findViewById(R.id.barcode);

        Intent intent = new Intent();
        intent.putExtra("barcode", barcode.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
