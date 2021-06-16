package com.example.olivecostcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class islemlerYap extends AppCompatActivity {
    TextView alanText;
    TextView sicaklikTxt;
    TextView tohumAdet;
    TextView tohumFiyat;
    TextView ilacKilo;
    TextView ilacFiyat;
    TextView budamaFiyat;
    TextView damlamaSuMiktari;
    TextView suFiyat;
    TextView boruMetresi;
    TextView boruFiyati;
    TextView traktorBenzin;
    TextView benzinFiyati;
    TextView gubreKilo;
    TextView gubreFiyat;
    TextView MakineBenzin;
    TextView makineBenzinTl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islemler_yap);
        alanText = findViewById(R.id.alanText);
        sicaklikTxt = findViewById(R.id.sicaklikTxt);
        tohumAdet = findViewById(R.id.tohumAdeti);
        tohumFiyat = findViewById(R.id.tohumFiyat);
        ilacKilo = findViewById(R.id.ilacKilo);
        ilacFiyat = findViewById(R.id.ilacFiyat);
        budamaFiyat = findViewById(R.id.budamaFiyat);
        damlamaSuMiktari = findViewById(R.id.damlamaSuMiktari);
        suFiyat = findViewById(R.id.suFiyat);
        boruMetresi = findViewById(R.id.boruMetresi);
        boruFiyati = findViewById(R.id.boruFiyati);
        traktorBenzin = findViewById(R.id.traktorBenzin);
        benzinFiyati = findViewById(R.id.benzimFiyati);
        MakineBenzin= findViewById(R.id.MakineBenzin);
        makineBenzinTl= findViewById(R.id.makineBenzinTl);
        gubreKilo = findViewById(R.id.gübreKilo);
        gubreFiyat= findViewById(R.id.gubreFiyat);




        Intent i = getIntent();
        String sonuc2 = i.getStringExtra("Alan :");
        alanText.setText(sonuc2);
        String tohumsonuc = i.getStringExtra("TohumAdet :");
        tohumAdet.setText(tohumsonuc);
        String tohumfiyat = i.getStringExtra("tohumFiyat :");
        tohumFiyat.setText(tohumfiyat);
        String sicdegeri = i.getStringExtra("Sicaklik :");
        sicaklikTxt.setText(sicdegeri);
        String ilacfiyatsonuc = i.getStringExtra("ilacFiyat :");
        ilacKilo.setText(ilacfiyatsonuc);
        String ilacmaliyetsonuc= i.getStringExtra("ilacMaliyet :");
        ilacFiyat.setText(ilacmaliyetsonuc);
        String budamamaliyetsonuc = i.getStringExtra("budamaMaliyet :");
        budamaFiyat.setText(budamamaliyetsonuc);
        String boruMetre = i.getStringExtra("boruMetre :");
        boruMetresi.setText(boruMetre);
        String borumaliyetsonuc = i.getStringExtra("BoruPara :");
        boruFiyati.setText(borumaliyetsonuc);
        String damlatmaSu = i.getStringExtra("SuLitre :");
        damlamaSuMiktari.setText(damlatmaSu);
        String suyunMaliyeti = i.getStringExtra("SuParasi :");
        suFiyat.setText(suyunMaliyeti);
        String traktorBenzinLitre = i.getStringExtra("Traktor :");
        traktorBenzin.setText(traktorBenzinLitre);
        String gubreSayi = i.getStringExtra("Gübre :");
        gubreKilo.setText(gubreSayi);
        String gubreMaliyet = i.getStringExtra("GubreTl :");
        gubreFiyat.setText(gubreMaliyet);
        String yakitFiyat = i.getStringExtra("YakitTr :");
        benzinFiyati.setText(yakitFiyat);

        String makineYakit = i.getStringExtra("YakitMakine :");
        MakineBenzin.setText(makineYakit);

        String makineFiyat = i.getStringExtra("YakitMk :");
        makineBenzinTl.setText(makineFiyat);



    }


}