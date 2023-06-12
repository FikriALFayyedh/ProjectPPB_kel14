package com.example.projectppb;

import static com.google.android.material.color.utilities.MaterialDynamicColors.error;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://login-project-ppb-80bc5-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText name = findViewById(R.id.name);
        final EditText password = findViewById(R.id.password);
        final Button loginbtn = findViewById(R.id.loginbtn);
        final TextView registernowbtn = findViewById(R.id.registernowbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nametxt = name.getText().toString().toLowerCase();
                final String passwordtxt = password.getText().toString();

                if(nametxt.isEmpty() || passwordtxt.isEmpty()){
                    Toast.makeText(login.this,"masukan data dengan benar", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(nametxt)){

                                final String getpassword = snapshot.child(nametxt).child("password").getValue(String.class);

                                if(getpassword.equals(passwordtxt)){
                                    Toast.makeText(login.this, "Login berhasil", Toast.LENGTH_SHORT).show();


                                    startActivity(new Intent(login.this, MainActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(login.this, "password salah", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(login.this, "password salah", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
        registernowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, register.class));
                finish();

            }
        });

    }
}