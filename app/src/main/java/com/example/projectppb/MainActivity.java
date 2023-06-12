package com.example.projectppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView mlinePilGan;
    ImageView mLineVideo;
    ImageView mLineEssay;
    ImageView mLineEval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLineEssay = (ImageView) findViewById(R.id.linemateri);
        mLineVideo = (ImageView) findViewById(R.id.linevideo);
        mlinePilGan = (ImageView) findViewById(R.id.linekuis);
        mLineEval = (ImageView) findViewById(R.id.lineeval);

        mLineEssay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, materi.class);
                startActivity(i);
            }
        });

        mLineVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, video.class);
                startActivity(i);
            }
        });

        mlinePilGan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, kuis.class);
                startActivity(i);
            }
        });

        mLineEval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

    }
}