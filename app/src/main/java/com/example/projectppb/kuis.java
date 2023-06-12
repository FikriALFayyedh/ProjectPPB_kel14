package com.example.projectppb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class kuis extends AppCompatActivity {

    TextView mtvSkor, mtvSoal;
    RadioGroup mrgPilihanJawaban;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3, mrbPilihanJawaban4;
    Button mbtnSubmit;
    ImageView mbackhome;
    int skor=0;
    int arr;
    int x;
    int tsalah=0;
    int tbenar=0;
    String jawaban;

    soal soalPG = new soal();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_kuis);
        mbackhome = (ImageView) findViewById(R.id.backhome);

        mbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(kuis.this, MainActivity.class);
                startActivity(i);
            }
        });

//        mtvSkor = (TextView) findViewById(R.id.tvSkor);
        mtvSoal = (TextView) findViewById(R.id.tvSoal);
        mrgPilihanJawaban = (RadioGroup) findViewById(R.id.rgPilihanJawaban);
        mrbPilihanJawaban1 = (RadioButton) findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = (RadioButton) findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = (RadioButton) findViewById(R.id.rbPilihanJawaban3);
        mrbPilihanJawaban4= (RadioButton) findViewById(R.id.rbPilihanJawaban4);
        mbtnSubmit = (Button) findViewById(R.id.btnSubmit);

//        mtvSkor.setText(""+skor);
        setKonten();

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cekJawaban();
            }
        });
    }


    public void setKonten(){
        mrgPilihanJawaban.clearCheck();
        arr = soalPG.pertanyaan.length;
        if(x >= arr){
            String jumlahSkor = String.valueOf(skor);

            String jsalah = String.valueOf(tsalah);
            String jbenar = String.valueOf(tbenar);

            Intent i = new Intent(kuis.this, hasil.class);

            i.putExtra("skorAkhir",jumlahSkor);
            i.putExtra("skorSalah",jsalah);
            i.putExtra("skorBenar",jbenar);

            i.putExtra("activity","PilihanGanda");
            startActivity(i);
        }else{

            mtvSoal.setText(soalPG.getPertanyaan(x));
            mrbPilihanJawaban1.setText(soalPG.getPilihanJawaban1(x));
            mrbPilihanJawaban2.setText(soalPG.getPilihanJawaban2(x));
            mrbPilihanJawaban3.setText(soalPG.getPilihanJawaban3(x));
            mrbPilihanJawaban4.setText(soalPG.getPilihanJawaban4(x));
            jawaban = soalPG.getJawabanBenar(x);

        }
        x++;
    }

    public void cekJawaban(){
        if(mrbPilihanJawaban1.isChecked()){

            if(mrbPilihanJawaban1.getText().toString().equals(jawaban)){
                skor = skor + 10;
                tbenar = tbenar + 1;
//                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();
            }else{
                tsalah = tsalah + 1;
//                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban2.isChecked()){

            if(mrbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor + 10;
                tbenar = tbenar + 1;
//                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();
            }else{
                tsalah = tsalah + 1;
//                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban3.isChecked()) {

            if (mrbPilihanJawaban3.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                tbenar = tbenar + 1;
//                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();
            } else {
                tsalah = tsalah + 1;
//                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban4.isChecked()){

                if(mrbPilihanJawaban4.getText().toString().equals(jawaban)){
                    skor = skor + 10;
                    tbenar = tbenar + 1;
//                    mtvSkor.setText(""+skor);
                    Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                    setKonten();
                }else{
                    tsalah = tsalah + 1;
//                    mtvSkor.setText(""+skor);
                    Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                    setKonten();
                }
        }else{
            Toast.makeText(this, "Silahkan pilih jawaban dulu!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed(){
        Toast.makeText(this, "Selesaikan kuis", Toast.LENGTH_SHORT).show();

    }
}