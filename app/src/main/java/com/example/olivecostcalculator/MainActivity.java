package com.example.olivecostcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnHesaplamayaBasla;
    Button btnHakkindaSayfasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHesaplamayaBasla = findViewById(R.id.btn_hesaplamaya_basla);
        btnHakkindaSayfasi = findViewById(R.id.btn_hakkinda);

        btnHakkindaSayfasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sayfaHakkinda = new Intent(MainActivity.this,hakkinda.class);
                startActivity(sayfaHakkinda);

            }
        });
        btnHesaplamayaBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent islemleregit = new Intent(MainActivity.this,hesaplamaSayfasi.class);
                startActivity(islemleregit);
            }
        });
    }
}