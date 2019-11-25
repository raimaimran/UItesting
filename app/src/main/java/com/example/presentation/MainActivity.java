package com.example.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt= (TextView) findViewById(R.id.redirectsignup);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, signUp.class);
                startActivity(intent);
            }
        });

        btn = (Button) findViewById(R.id.bssignin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText uname = findViewById(R.id.bsemailid);
                if (uname.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "You must enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (uname.getText().toString().contains("@") != true)
                {
                    Toast.makeText(getApplicationContext(), "You must enter a valid email.", Toast.LENGTH_SHORT).show();
                    return;
                }
                EditText pass = findViewById(R.id.bspassword);
                if (pass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "You must enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, homePage.class);

                intent.putExtra("UserName", uname.getText().toString());
                startActivity(intent);

            }
        });
    }

}

