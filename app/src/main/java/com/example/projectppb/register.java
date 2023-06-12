package com.example.projectppb;

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

import java.util.Locale;

public class register extends AppCompatActivity {

    DatabaseReference dataBaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://login-project-ppb-80bc5-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText name = findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);
        final EditText conpassword = findViewById(R.id.conpassword);

        final Button registerbtn = findViewById(R.id.registerbtn);
        final TextView loginnowbtn = findViewById(R.id.loginnowbtn);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nametxt = name.getText().toString().toLowerCase();
                final String emailtxt = email.getText().toString().toLowerCase();
                final String passwordtxt = password.getText().toString();
                final String conpasswordtxt = conpassword.getText().toString();

                if(nametxt.isEmpty() || emailtxt.isEmpty() || passwordtxt.isEmpty()){
                    Toast.makeText(register.this, "masukan data dengan benar", Toast.LENGTH_SHORT).show();
                }

                else if (!passwordtxt.equals(conpasswordtxt)) {
                    Toast.makeText(register.this, "masukan password dengan benar", Toast.LENGTH_SHORT).show();
                }

                else {
                    dataBaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.hasChild(nametxt)){
                                Toast.makeText(register.this, "email sudah terdaftar", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                dataBaseReference.child("users").child(nametxt).child("name").setValue(nametxt);
                                dataBaseReference.child("users").child(nametxt).child("email").setValue(emailtxt);
                                dataBaseReference.child("users").child(nametxt).child("password").setValue(passwordtxt);

                                Toast.makeText(register.this, "data berhasil dibuat", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this, login.class));
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
        loginnowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this, login.class));
                finish();
            }
        });

    }
}