package com.example.olivecostcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class hesaplamaSayfasi extends AppCompatActivity {

    EditText enText;
    EditText boyText;
    EditText aralikText;
    EditText ilacCap;
    EditText ilacYukseklik;
    EditText budamaisci;
    EditText boruMetreFiyat;
    EditText damlaticiAralik;
    EditText aracsayisi;
    EditText makineAdet;
    EditText sicaklikText;
    RadioButton sivi,granul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesaplama_sayfasi);

        enText = findViewById(R.id.enText);
        boyText = findViewById(R.id.boyText);
        aralikText =findViewById(R.id.aralikText);
        ilacCap = findViewById(R.id.ilacCap);
        ilacYukseklik =findViewById(R.id.ilacYukseklik);
        budamaisci = findViewById(R.id.budamaisci);
        boruMetreFiyat = findViewById(R.id.boruMetreFiyat);
        damlaticiAralik = findViewById(R.id.damlaticiAralik);
        aracsayisi = findViewById(R.id.aracSayisi);
        makineAdet = findViewById(R.id.makineAdet);
        sicaklikText = findViewById(R.id.sicaklikText);
        sivi = (RadioButton)findViewById(R.id.r1);
        granul = (RadioButton)findViewById(R.id.r2);





    }

    public void Hesapla(View view){


        int en = Integer.parseInt(enText.getText().toString());
        int boy = Integer.parseInt(boyText.getText().toString());

        int ekimAraligi = Integer.parseInt(aralikText.getText().toString());
        int agacCap = Integer.parseInt(ilacCap.getText().toString());
        int agacyuseklik = Integer.parseInt(ilacYukseklik.getText().toString());
        int budamaiscisayisi = Integer.parseInt(budamaisci.getText().toString());
        int sicaklik =Integer.parseInt(sicaklikText.getText().toString());

        int boruAralik = Integer.parseInt(damlaticiAralik.getText().toString());
        int borumetrefyt = Integer.parseInt(boruMetreFiyat.getText().toString());
        int traktorAdet = Integer.parseInt(aracsayisi.getText().toString());
        int makineSayisi = Integer.parseInt(makineAdet.getText().toString());

        Intent i = new Intent(getBaseContext(), islemlerYap.class);

        int sonuc= en*boy;
        String sonuc2 = String.valueOf(sonuc);
        i.putExtra("Alan :",sonuc2);
        int tohumAdeti = (en/ekimAraligi)*(boy/ekimAraligi);
        String tohumsonuc = String.valueOf(tohumAdeti);
        i.putExtra("TohumAdet :",tohumsonuc);

        if(sivi.isChecked()){
            int gubreMiktari = (tohumAdeti*3) / 10;
            String gubreSayi = String.valueOf(gubreMiktari);
            i.putExtra("Gübre :",gubreSayi);

            int gubreFiyati = gubreMiktari*36;
            String gubreMaliyet = String.valueOf(gubreFiyati);
            i.putExtra("GubreTl :",gubreMaliyet);
        }
        else if(granul.isChecked()){
            int gubreMiktari = (tohumAdeti*3) / 10;
            String gubreSayi = String.valueOf(gubreMiktari);
            i.putExtra("Gübre :",gubreSayi);

            int gubreFiyati = gubreMiktari*21;
            String gubreMaliyet = String.valueOf(gubreFiyati);
            i.putExtra("GubreTl :",gubreMaliyet);
        }



        int tohumFiyati = (tohumAdeti*19);
        String tohumfiyat = String.valueOf(tohumFiyati);
        i.putExtra("tohumFiyat :",tohumfiyat);

        int ilacinFiyat = (((agacCap*agacyuseklik)/2)*tohumAdeti/3);
        String ilacfiyatsonuc =String.valueOf(ilacinFiyat);
        i.putExtra("ilacFiyat :",ilacfiyatsonuc);

        int ilacMaliyeti =(ilacinFiyat*19);
        String ilacmaliyetsonuc = String.valueOf(ilacMaliyeti);
        i.putExtra("ilacMaliyet :",ilacmaliyetsonuc);

        double budamaMaliyeti = ((tohumAdeti/budamaiscisayisi)/5)*(10*budamaiscisayisi);
        String budamamaliyetsonuc = String.valueOf(budamaMaliyeti);
        i.putExtra("budamaMaliyet :",budamamaliyetsonuc);

        int boruUzunluk = ((boy/boruAralik)-1)*en;
        String boruMetre = String.valueOf(boruUzunluk);
        i.putExtra("boruMetre :",boruMetre);

        int boruMaliyet = boruUzunluk*borumetrefyt;
        String borumaliyetsonuc = String.valueOf(boruMaliyet);
        i.putExtra("BoruPara :",borumaliyetsonuc);
        //Sıcaklıga göre günlük sulama maliyeti

        if(10 < sicaklik && sicaklik<=20){
        int damlatmaSuMiktari = (tohumAdeti*2*3)/10 ;
        String damlatmaSu = String.valueOf(damlatmaSuMiktari);
        i.putExtra("SuLitre :",damlatmaSu);

            int suyunFiyati = (damlatmaSuMiktari*42)/10;
            String suyunMaliyeti = String.valueOf(suyunFiyati);
            i.putExtra("SuParasi :",suyunMaliyeti);

        }

        if( 20 <sicaklik){
            int damlatmaSuMiktari = (tohumAdeti*2*3)/10 ;
            String damlatmaSu = String.valueOf(damlatmaSuMiktari);
            i.putExtra("SuLitre :",damlatmaSu);

            int suyunFiyati = (damlatmaSuMiktari*42)/10;
            String suyunMaliyeti = String.valueOf(suyunFiyati);
            i.putExtra("SuParasi :",suyunMaliyeti);

        }

        if(0 <= sicaklik && sicaklik<10){
            int damlatmaSuMiktari = (tohumAdeti*3) /10 ;
            String damlatmaSu = String.valueOf(damlatmaSuMiktari);
            i.putExtra("SuLitre :",damlatmaSu);

            int suyunFiyati = (damlatmaSuMiktari*42)/10;
            String suyunMaliyeti = String.valueOf(suyunFiyati);
            i.putExtra("SuParasi :",suyunMaliyeti);

        }
        if(sicaklik<0){
            int damlatmaSuMiktari = 0 ;
            String damlatmaSu = String.valueOf(damlatmaSuMiktari);
            i.putExtra("SuLitre :",damlatmaSu);

            int suyunFiyati = 0;
            String suyunMaliyeti = String.valueOf(suyunFiyati);
            i.putExtra("SuParasi :",suyunMaliyeti);

        }


        int traktorBenzinMiktari = ( en*boy*4*traktorAdet) /2000;
        String traktorBenzinLitre = String.valueOf(traktorBenzinMiktari);
        i.putExtra("Traktor :",traktorBenzinLitre);

        int traktorYakitFiyat = traktorBenzinMiktari * 7;
        String yakitFiyat = String.valueOf(traktorYakitFiyat);
        i.putExtra("YakitTr :",yakitFiyat);

        int makineBenzinMiktari = tohumAdeti /25;
        String makineYakit =String.valueOf(makineBenzinMiktari);
        i.putExtra("YakitMakine :",makineYakit);

        int makineYakitFiyat = makineBenzinMiktari*7;
        String makineFiyat = String.valueOf(makineYakitFiyat);
        i.putExtra("YakitMk :",makineFiyat);










            int sicaklikdegeri= (sicaklik)+1-1;
            String sicdegeri = String.valueOf(sicaklikdegeri);
            i.putExtra("Sicaklik :",sicdegeri);

       // i.putExtra("Sicaklik :",sicaklikText.getText().toString());









        startActivity(i);

    }
    public void havaDurumu(View view) {
        Intent i = new Intent(getBaseContext(), com.example.olivecostcalculator.HavaDurumu.class);
        startActivity(i);
    }
    public void BilgiAl(View view) {
        Intent i = new Intent(getBaseContext(), com.example.olivecostcalculator.islemlerYap2.class);
        startActivity(i);
    }




}

