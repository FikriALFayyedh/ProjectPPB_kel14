package com.example.projectppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HasilKuis extends AppCompatActivity {

    private TextView tvNilai, tvMessage, tvHasil;
    private Button btnUlang;

    ImageView mbackhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis);

        tvNilai = findViewById(R.id.tvNilai);
        tvMessage = findViewById(R.id.tvMessage);
        btnUlang = findViewById(R.id.btnUlang);
        tvHasil = findViewById(R.id.tvHasil);

        int nilai = getIntent().getExtras().getInt("nilai");
        int benar = getIntent().getExtras().getInt("benar");
        int salah = getIntent().getExtras().getInt("salah");

        mbackhome = (ImageView) findViewById(R.id.backhome);

        mbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HasilKuis.this, MainActivity.class);
                startActivity(i);
            }
        });

        tvMessage.setText("Jawaban Benar: "+ benar +" . "+ "Jawaban Salah: " + salah);
        tvNilai.setText(String.valueOf(nilai));

        if(nilai == 100){
            tvHasil.setText("Kamu mendapatkan Nilai A, Kamu Lulus");
        }else if (nilai >= 80){
            tvHasil.setText("Kamu mendapatkan Nilai B, Kamu Lulus");
        }else if (nilai >= 60){
            tvHasil.setText("Kamu mendapatkan Nilai C, Kamu Remedi");
        }else if (nilai >= 40){
            tvHasil.setText("Kamu mendapatkan Nilai D, Kamu Remedi");
        }else if (nilai >= 20){
            tvHasil.setText("Kamu mendapatkan Nilai E, Kamu Remedi");
        }

        btnUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent back = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(back);
            }
        });
    }
}