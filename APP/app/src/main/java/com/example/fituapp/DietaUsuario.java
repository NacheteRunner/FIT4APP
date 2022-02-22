package com.example.fituapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fituapp.datos.LoadImage;

public class DietaUsuario extends AppCompatActivity {

    private TextView tv_user_dietas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta_usuario);
        ImageView img = findViewById(R.id.iv_small_Dietas);
        new LoadImage(img).execute(PerfilUsuario.usu_loggeado.getFoto());
        tv_user_dietas = findViewById(R.id.tv_user_dieta);
        tv_user_dietas.setText(PerfilUsuario.usu_loggeado.getLogin_usuario());
    }


    public void onClick(View view){

        Intent intent = new Intent(this, PerfilUsuario.class);
        startActivity(intent);
    }
}