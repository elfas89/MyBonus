package com.oracleteam.mybonus;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AgreementActivity extends AppCompatActivity {

    public static String LOG_TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        Toast.makeText(this, "AgreementActivity!!!!", Toast.LENGTH_LONG).show();

        new ParseTask().execute();
    }


    private class ParseTask extends AsyncTask<Void, Void, String> {


        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        @Override
        protected String doInBackground(Void... params) {
            // получаем данные с внешнего ресурса
            try {
//                URL url = new URL("http://androiddocs.ru/api/friends.json");
                URL url = new URL("http://web-service.gdv.name/api/getagreement.php");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                resultJson = buffer.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultJson;
        }


        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);

            // выводим целиком полученную json-строку
            Log.d(LOG_TAG, strJson);

            JSONObject dataJsonObj = null;
            String secondName = "";

            try {
//                dataJsonObj = new JSONObject(strJson);
//                JSONArray friends = dataJsonObj.getJSONArray("friends");
//
//                // 1. достаем инфо о втором друге - индекс 1
//                JSONObject secondFriend = friends.getJSONObject(1);
//                secondName = secondFriend.getString("name");
//                Log.d(LOG_TAG, "Второе имя: " + secondName);
//
//                // 2. перебираем и выводим контакты каждого друга
//                for (int i = 0; i < friends.length(); i++) {
//                    JSONObject friend = friends.getJSONObject(i);
//
//                    JSONObject contacts = friend.getJSONObject("contacts");
//
//                    String phone = contacts.getString("mobile");
//                    String email = contacts.getString("email");
//                    String skype = contacts.getString("skype");
//
//                    Log.d(LOG_TAG, "phone: " + phone);
//                    Log.d(LOG_TAG, "email: " + email);
//                    Log.d(LOG_TAG, "skype: " + skype);

                dataJsonObj = new JSONObject(strJson);
                JSONArray results = dataJsonObj.getJSONArray("results");

                StringBuilder sb = new StringBuilder();
                TextView textAgreement = findViewById(R.id.textAgreement);
                String lineSeparator = System.lineSeparator();


                // get all info
                for (int i = 0; i < results.length(); i++) {
                    JSONObject result = results.getJSONObject(i);

                    //JSONObject contacts = friend.getJSONObject("contacts");

                    String id = result.getString("ID");
                    String type = result.getString("TYPE");
                    String value = result.getString("VALUE");
                    String lastDate = result.getString("LAST_DATE");

//                    Log.d(LOG_TAG, "id: " + id);
//                    Log.d(LOG_TAG, "type: " + type);
                    Log.d(LOG_TAG, "value: " + value);
//                    Log.d(LOG_TAG, "lastDate: " + lastDate);


                    sb.append(value);
                    sb.append(lineSeparator);



                }

                textAgreement.setText(sb);


            } catch (JSONException e) {
                e.printStackTrace();
            }





        }
    }



}
