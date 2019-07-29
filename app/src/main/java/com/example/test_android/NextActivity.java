package com.example.test_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class NextActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // déclaration des variables
        int nbpersonne = 0;
        double tarif = 0.0;
        int jours = 0;

        // affichage de la nouvelle activité
        setContentView(R.layout.test_layout);

        // récupération des paramètres
        Intent intent = getIntent();
        if (intent != null) {
            // nombre de jours
            String strjours = "";
            if (intent.hasExtra("text_jours")){
                strjours = intent.getStringExtra("text_jours");
                jours = Integer.parseInt(strjours);
                Log.i("Test_android/next","paramètre jours " + jours);
            }
            // nombre de personnes
            String strnb = "";
            if (intent.hasExtra("text_nbpers")){
                strnb = intent.getStringExtra("text_nbpers");
                nbpersonne = Integer.parseInt(strnb);
                Log.i("Test_android/next","paramètre nb personnes " + nbpersonne);
            }
            // tarif
            String strtarif = "";
            if (intent.hasExtra("text_tarif")){
                strtarif = intent.getStringExtra("text_tarif");
                tarif = Double.parseDouble(strtarif);
                Log.i("Test_android/next","paramètre tarif " + tarif);
            }
        }

        // Mise à jour de la date
        TextView date = (TextView)findViewById(R.id.Date);
        Date jour = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date.setText(dateFormat.format(jour));
        Log.i("Test_android/next","Date " + date);

        // Mise à jour du résultat
        TextView res = (TextView)findViewById(R.id.res);
        //double apayer = nbjour * nbpersonne * tarif;
        String stringdouble= Double.toString(jours * nbpersonne * tarif);
        res.setText(stringdouble);
        Log.i("Test_android/next","à payer " + res);

        // Sur clic du bouton retour, on revient à la page précédente
        Button myButton = (Button) findViewById(R.id.retour);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Test_android", "Retour au menu principal");

                Intent myIntent = new Intent(NextActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
