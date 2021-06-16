package com.example.olivecostcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class islemlerYap2 extends AppCompatActivity {
    EditText SicaklikAl;
    Button btnToast;

    public  void showMyToast(String title ,String massage){
        Toast myToast = new Toast(this);
        LinearLayout pnlToast = new LinearLayout(this);
        pnlToast.setOrientation(LinearLayout.VERTICAL);
        pnlToast.setBackgroundColor(Color.BLACK);
        pnlToast.setPadding(50,50,50,50);

        TextView txtTitle = new TextView(this);
        txtTitle.setText(title);
        txtTitle.setTextSize(25);
        txtTitle.setTextColor(Color.YELLOW);
        pnlToast.addView(txtTitle);

        TextView txtMessage = new TextView(this);
        txtMessage.setText(massage);
        txtMessage.setTextSize(25);
        txtMessage.setTextColor(Color.WHITE);
        pnlToast.addView(txtMessage);

        myToast.setGravity(Gravity.CENTER,0,0);
        myToast.setDuration(Toast.LENGTH_LONG);
        myToast.setView(pnlToast);
        myToast.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islemler_yap2);
        SicaklikAl = findViewById(R.id.SicaklikAl);
        btnToast = (Button)findViewById(R.id.btnToast);



        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sic = Integer.parseInt(SicaklikAl.getText().toString());
                String sic2 =  String.valueOf(sic);
                if(10 <= sic && sic<=20){
                showMyToast("Dikkat",sic + " Derecede 2 defa sulama yapılması gerekir.Su Maliyeti hesabı yapılırken bu durum göz önüne alınarak yapılacaktır");
                }
                else if(0 <= sic && sic<10){
                    showMyToast("Dikkat",sic + " Derecede 1 defa sulama yapılması gerekir.Su Maliyeti hesabı yapılırken bu durum göz önüne alınarak yapılacaktır");
                }
                else if (sic <0){
                    showMyToast("Dikkat",sic + " Derecede sulama yapılmaması gerekir.Toprakta donma olabilir.Su Maliyeti hesabı yapılırken bu durum göz önüne alınarak yapılacaktır");

                }
            }
        });
    }
}