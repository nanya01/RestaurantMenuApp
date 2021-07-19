package com.example.restaurantmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    EditText login_name, password;
    Button btn_login;
    TextView register;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.register);
        login_name = findViewById(R.id.editText_name);
        password = findViewById(R.id.editText_password);
        btn_login = findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login_name.getText().toString().equalsIgnoreCase("peter") && password.getText().toString().equals("admin")) {
                     intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
}