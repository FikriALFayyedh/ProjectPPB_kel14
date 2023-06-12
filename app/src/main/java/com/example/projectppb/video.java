package com.example.projectppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.net.HttpCookie;

public class video extends AppCompatActivity {

    int[] images = {R.drawable.gurudigital, R.drawable.kelasmultimedia, R.drawable.tanicyber, R.drawable.menuvideo, R.drawable.menuvideo, R.drawable.menuvideo, R.drawable.menuvideo, R.drawable.menuvideo, R.drawable.menuvideo, R.drawable.menuvideo};

    String[] jby = {"Apa itu Sistem Komputer", "pengertian Sistem Komputer", "Dasar Sistem Komputer"};

    String[] byNumber = {"Guru Digital", "Kelas Multimedia", "Tani Cyber"};

    String[] urls = {"https://youtu.be/gSImFfrlsE0","https://youtu.be/eQZzRbAXct8","https://youtu.be/i_Axh3IwFbY"};
    ListView lView;

    ListAdapter lAdapter;

    ImageView mbackhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mbackhome = (ImageView) findViewById(R.id.backhome);

        mbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(video.this, MainActivity.class);
                startActivity(i);
            }
        });

        lView = (ListView) findViewById(R.id.vidlist);

        lAdapter = new ListAdapter(video.this,jby,byNumber,images, urls);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private HttpCookie uri;

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(video.this, jby[i]+" by "+byNumber[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}