package com.example.test_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("Test_android","Début des calculs");

                // déclaration des variables
                int nbjours = 0;

               // calcul du nombre de jours
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                EditText EditText_arrivee = (EditText) findViewById(R.id.date_ar);
                String str_arr = EditText_arrivee.getText().toString();

                EditText EditText_depart = (EditText) findViewById(R.id.date_dep);
                String str_dep = EditText_depart.getText().toString();

                try {
                    Date dateAvant = sdf.parse(str_arr);
                    Date dateApres = sdf.parse(str_dep);
                    long diff = dateApres.getTime() - dateAvant.getTime();
                    nbjours = (int)(diff / (1000*60*60*24));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String str_jours = Integer.toString(nbjours);

                // récupération du nombre de personne
                EditText EditText_nbpers = (EditText) findViewById(R.id.nbpers);
                String str_nbpres = EditText_nbpers.getText().toString();

                // récupération du tarif
                EditText EditText_tarif = (EditText) findViewById(R.id.nbpers2);
                String str_tarif = EditText_tarif.getText().toString();

                // passage des paramètres
                Intent myIntent = new Intent(MainActivity.this, NextActivity.class);
                myIntent.putExtra("text_nbpers", str_nbpres);
                myIntent.putExtra("text_tarif", str_tarif);
                myIntent.putExtra("text_jours", str_jours);
                startActivity(myIntent);
            }
        });
    }
}
