package com.example.olivecostcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;


public class HavaDurumu extends AppCompatActivity {

    public TextView t1_sicaklik, t2_sehir, t3_durum, t4_tarih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hava_durumu);

        t1_sicaklik = (TextView) findViewById(R.id.sicak);
        t2_sehir = (TextView) findViewById(R.id.sehir);
        t3_durum = (TextView) findViewById(R.id.durum);
        t4_tarih = (TextView) findViewById(R.id.tarih);


        find_weather();

    }

    public void find_weather() {

        String url = "https://api.openweathermap.org/data/2.5/weather?q=Bursa,tr&appid=6d04331ec0b88a2633f9df91d3109496&units=Imperial";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String sicak = (main_object.getString("temp"));
                    String durum = object.getString("description");
                    String sehir = response.getString("name");

                    t2_sehir.setText(sehir);
                    t3_durum.setText(durum);

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM=EEEE");
                    String formatted_date = sdf.format(calendar.getTime());
                    t4_tarih.setText(formatted_date);

                    double temp_int = Double.parseDouble(sicak);
                    double centi = (temp_int - 32) / 1.800;

                    centi = Math.round(centi);
                    int i = (int) centi;

                    t1_sicaklik.setText(String.valueOf(i));

                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errrr = "";
            }
        }
        );

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);

    }

    public void Bul(View view){
        Intent i = new Intent(getBaseContext(),HavaDurumu.class);
        startActivity(i);
    }
}




