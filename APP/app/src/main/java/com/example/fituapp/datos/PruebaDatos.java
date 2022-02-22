package com.example.fituapp.datos;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fituapp.LoginActivity;
import com.example.fituapp.R;

public class PruebaDatos extends AppCompatActivity {

    TextView tv_cuatro;
    TextView tv_dos;
    TextView tv_tres;
    SharedPreferences sharedPreferences;
    public static final String MY_PREFERENCES = "MyPrefs";
    public static final String USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_datos);

        sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        tv_dos = findViewById(R.id.textView2);
        tv_tres = findViewById(R.id.textView3);
        tv_cuatro = findViewById(R.id.textView4);

        tv_dos.setText(sharedPreferences.getString("USERNAME", "ninguno"));
        tv_tres.setText(sharedPreferences.getString("ID", "defecto"));
        tv_cuatro.setText(LoginActivity.sId_usuario);

    }
}