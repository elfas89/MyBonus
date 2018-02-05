package com.oracleteam.mybonus;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SmsActivity extends AppCompatActivity {

    public static String LOG_TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        // here we are trying to validate user
        ValidateUser validateUser = new ValidateUser();
//        validateUser.execute();
        validateUser.execute("5000012345675");



        //5000012345675
        //0955418422

        // Get the Intent that started this activity and extract the string
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.TO_VALIDATE);
//
//        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(message);
//
//
//        // test locales here
//        // Get a string resource from your app's Resources
//        String hello = getResources().getString(R.string.hello_world);
//
//        // Or supply a string resource to a method that requires a string
////        TextView textViewHello = new TextView(this);
////        textView.setText(R.string.hello_world);
//
//        TextView textViewHello = findViewById(R.id.textViewHello);
//        textViewHello.setText(hello);

    }

    private class ValidateUser extends AsyncTask<String, Void, String>{

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "to e resultJson in da string";

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("http://web-service.gdv.name/api/validateuser.php"); //Enter URL here
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST"); // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
                httpURLConnection.setRequestProperty("Content-Type", "application/json"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                httpURLConnection.connect();

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("bc", "5000012345675");

                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes(jsonObject.toString());
                wr.flush();
                wr.close();


                int responseCode = httpURLConnection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    String line;
                    BufferedReader br=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        resultJson += line;
                    }
                }
//                else {response="";}



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

//            return null;
            return resultJson;
        }

//        @Override
//        protected String doInBackground(Void... params) {
//            // получаем данные с внешнего ресурса
//            try {
////                URL url = new URL("http://androiddocs.ru/api/friends.json");
////                URL url = new URL("http://web-service.gdv.name/api/validateuser.php");
//                URL url = new URL("http://web-service.gdv.name/api/validateuser.php?bc=5000012345675");
//
//                urlConnection = (HttpURLConnection) url.openConnection();
//                urlConnection.setRequestMethod("GET");
//                urlConnection.connect();
//
//                InputStream inputStream = urlConnection.getInputStream();
//                StringBuffer buffer = new StringBuffer();
//
//                reader = new BufferedReader(new InputStreamReader(inputStream));
//
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    buffer.append(line);
//                }
//
//                resultJson = buffer.toString();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return resultJson;
//        }


        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);

            // выводим целиком полученную json-строку
            Log.d(LOG_TAG, strJson);

            JSONObject dataJsonObj = null;

//            try {
//
//                dataJsonObj = new JSONObject(strJson);
//                JSONArray results = dataJsonObj.getJSONArray("results");
//
////                StringBuilder sb = new StringBuilder();
////                TextView textAgreement = findViewById(R.id.textAgreement);
////                String lineSeparator = System.lineSeparator();
//
//
//                // get all info
//                for (int i = 0; i < results.length(); i++) {
//                    JSONObject result = results.getJSONObject(i);
//
//                    //JSONObject contacts = friend.getJSONObject("contacts");
//
//                    String userId = result.getString("USER_ID");
//                    String code = result.getString("CODE");
//                    String barcode = result.getString("BARCODE");
//                    String period = result.getString("PERIOD");
//                    String message = result.getString("MESSAGE");
//
//                    Log.d(LOG_TAG, "userId: " + userId);
//                    Log.d(LOG_TAG, "code: " + code);
//                    Log.d(LOG_TAG, "barcode: " + barcode);
//                    Log.d(LOG_TAG, "period: " + period);
//                    Log.d(LOG_TAG, "message: " + message);
//
//
////                    sb.append(value);
////                    sb.append(lineSeparator);
//
//                }
//
////                textAgreement.setText(sb);
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//


        }



    }

    protected void  smsValidate(View view){
        Toast.makeText(this, "you have clicked smsValidate", Toast.LENGTH_LONG).show();
    }
}
