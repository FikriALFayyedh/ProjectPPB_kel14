package com.example.projectppb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectppb.modelData.Artikel;
import com.example.projectppb.modelData.Artikel;
import com.github.barteksc.pdfviewer.PDFView;

public class materi extends AppCompatActivity {

    ImageView mbackhome;
    public PDFView pdfMateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        mbackhome = (ImageView) findViewById(R.id.backhome);

        mbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {finish();}
        });

        pdfMateri = findViewById(R.id.pdfMateri);
        pdfMateri.fromAsset("Sistem_Informasi.pdf")
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .load();

    }
}