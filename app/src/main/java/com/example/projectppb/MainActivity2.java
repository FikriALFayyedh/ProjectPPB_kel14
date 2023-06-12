package com.example.projectppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvSoal, tvTime;
    private Button btnSelanjutnya;
    private RadioGroup rgPilihan;
    private RadioButton rbA, rbB, rbC, rbD;
    private ImageView ivImage;
    int nomor = 0;
    int score = 0;
    int benar = 0, salah = 0;
    ImageView mbackhome;


    String Soal[] = new String[]{
            "Prosesor komputer bertanggung jawab atas",
            "Salah satu perangkat output pada komputer adalah",
            "Fungsi RAM dalam sistem komputer adalah",
            "Komponen inti dari motherboard adalah",
            "Sistem operasi adalah",
            "Berikut ini yang termasuk dalam perangkat input adalah",
            "Perangkat yang digunakan untuk menyimpan data jangka panjang pada komputer adalah",
            "Pada komputer, unit pengukuran kecepatan pemrosesan data disebut",
            "Perangkat lunak yang digunakan untuk mengakses dan menjelajahi internet disebut",
            "Dalam jaringan komputer, perangkat yang berfungsi sebagai penghubung antara jaringan lokal dengan jaringan eksternal (seperti internet) disebut",
    };

    String Option[] = new String[]{
            "Menyimpan data", "Menampilkan gambar", "Menjalankan instruksi", "Menghubungkan perangkat",
            "Mouse", "Monitor", "Keyboard", "RAM",
            "Menyimpan data jangka panjang", "Menghubungkan perangkat eksternal", "Menjalankan program aplikasi",  "Menyimpan data jangka pendek",
            "CPU", "RAM", "Hard Disk", "CD-ROM",
            "Perangkat keras komputer", "Program yang mengendalikan operasi komputer", "Unit penyimpanan data", "Sistem komunikasi komputer",
            "Printer", "Monitor", "Mouse", "Speaker",
            "CPU", "RAM", "Hard Disk", "USB Flash Drive",
            "Megabyte (MB)", "Megahertz (MHz)", "Gigabyte (GB)", "Gigahertz (GHz)",
            "Spreadsheet", "Browser", "Database", "Antivirus",
            "Modem", "Router", "Switch", "Hub",
    };

    String Jawaban[] = new String[]{
            "Menjalankan instruksi",
            "Monitor",
            "Menyimpan data jangka pendek",
            "CPU",
            "Program yang mengendalikan operasi komputer",
            "Mouse",
            "Hard Disk",
            "Megahertz (MHz)",
            "Browser",
            "Router",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvSoal = findViewById(R.id.tvSoal);
        tvTime = findViewById(R.id.tvTime);
        btnSelanjutnya = findViewById(R.id.btnSelanjutnya);
        rgPilihan = findViewById(R.id.rgPilihan);
        rbA = findViewById(R.id.rbA);
        rbB = findViewById(R.id.rbB);
        rbC = findViewById(R.id.rbC);
        rbD = findViewById(R.id.rbD);

        rgPilihan.check(0);

        tvSoal.setText(Soal[nomor]);
        rbA.setText(Option[0]);
        rbB.setText(Option[1]);
        rbC.setText(Option[2]);
        rbD.setText(Option[3]);

        new CountDownTimer(301000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                tvTime.setText(millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                tvTime.setText("Waktu Habis!");
                score = benar * 10;
                Intent next = new Intent(getApplicationContext(), HasilKuis.class);
                next.putExtra("nilai", score);
                next.putExtra("benar", benar);
                next.putExtra("salah", salah);
                startActivity(next);
            }
        }.start();

        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbA.isChecked() || rbB.isChecked() || rbC.isChecked() || rbD.isChecked()){

                    RadioButton Pilihan_User = findViewById(rgPilihan.getCheckedRadioButtonId());
                    String Jawaban_User = Pilihan_User.getText().toString();
                    rgPilihan.check(0);

                    if(Jawaban_User.equalsIgnoreCase(Jawaban[nomor])){
                        benar++;
                    }else{
                        salah++;
                    }
                    nomor++;
                    if(nomor < Soal.length){
                        tvSoal.setText(Soal[nomor]);

                        rbA.setText(Option[(nomor * 4) + 0]);
                        rbB.setText(Option[(nomor * 4) + 1]);
                        rbC.setText(Option[(nomor * 4) + 2]);
                        rbD.setText(Option[(nomor * 4) + 3]);
                    }else{
                        score = benar * 10;
                        Intent next = new Intent(getApplicationContext(), HasilKuis.class);
                        next.putExtra("nilai", score);
                        next.putExtra("benar", benar);
                        next.putExtra("salah", salah);
                        startActivity(next);
                    }

                }else {
                    Toast.makeText(MainActivity2.this, "Silahkan Pilih Jawaban Terlebih dahulu!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mbackhome = (ImageView) findViewById(R.id.backhome);

        mbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {finish();}
        });
    }
}