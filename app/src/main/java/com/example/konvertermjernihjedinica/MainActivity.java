package com.example.konvertermjernihjedinica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton buttonTemp, buttonPovr, buttonDulj, buttonMasa, buttonBrz, buttonVol;
    TextView odabir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTemp = findViewById(R.id.img_temperatura);
        buttonPovr = findViewById(R.id. imageButton_površina);
        buttonDulj = findViewById(R.id. imageButton_duljina);
        buttonMasa = findViewById(R.id. imageButton_Masa);
        buttonBrz = findViewById(R.id. imageButton_brzina);
        buttonVol = findViewById(R.id.imageButton_volumen);


        buttonTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(MainActivity.this, Temperatura.class );
                startActivity(temp);
            }
        });
        buttonDulj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dulj = new Intent(MainActivity.this, Duljina.class);
                startActivity(dulj);
            }
        });
        buttonMasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mas = new Intent(MainActivity.this, Masa.class);
                startActivity(mas);
            }
        });
        buttonVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vol = new Intent(MainActivity.this, Volumen.class);
                startActivity(vol);
            }
        });
        buttonPovr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pov = new Intent(MainActivity.this, Povrsina.class);
                startActivity(pov);
            }
        });
        buttonBrz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brz = new Intent(MainActivity.this, Brzina.class);
                startActivity(brz);
            }
        });






    }
}