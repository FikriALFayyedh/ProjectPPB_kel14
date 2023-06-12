package com.example.projectppb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class hasil extends AppCompatActivity {

    TextView mtvHasilAkhir;
    TextView mtvSalah;
    TextView mtvBenar;
    Button mbtnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);

        mtvSalah = (TextView) findViewById(R.id.tvSkorSalah);
        mtvBenar = (TextView) findViewById(R.id.tvSkorBenar);

        mbtnMenu = (Button) findViewById(R.id.btnMenu);

        setSkor();

        mbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hasil.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void setSkor(){

        String activity = getIntent().getStringExtra("activity");
        String skorPilGan = getIntent().getStringExtra("skorAkhir");
        String skorEssay = getIntent().getStringExtra("skorAkhir2");

        String tsalah = getIntent().getStringExtra("skorSalah");
        String tbenar = getIntent().getStringExtra("skorBenar");

        if(activity.equals("PilihanGanda")){
            mtvHasilAkhir.setText("Score : "+skorPilGan+"/100");
            mtvSalah.setText("Salah : "+tsalah);
            mtvBenar.setText("Benar : "+tbenar);
        }else{

        }
    }

    public void onBackPressed(){
        Toast.makeText(this, "Tidak bisa kembali, silahkan tekan menu", Toast.LENGTH_SHORT).show();

    }
}