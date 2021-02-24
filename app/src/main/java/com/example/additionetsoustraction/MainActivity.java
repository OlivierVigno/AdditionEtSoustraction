package com.example.additionetsoustraction;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Menu principal");
        setContentView(R.layout.activity_main);
        Button addition = (Button) findViewById(R.id.buttonAdd);
        Button soustraction = (Button) findViewById(R.id.buttonSub);

        addition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdditionActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        soustraction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SoustractionActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                TextView t = (TextView) findViewById(R.id.txtResultat);
                String nombre1 = data.getStringExtra("valeur1");
                String nombre2 = data.getStringExtra("valeur2");
                int resultat = data.getIntExtra("result", 0);
                t.setText("Le boutton Addition a été touché: Le résultat de l'addition de " + nombre1 + " et " + nombre2 + " est: " + resultat);
            }
        } else if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                TextView t = (TextView) findViewById(R.id.txtResultat);
                String nombre1 = data.getStringExtra("valeur1");
                String nombre2 = data.getStringExtra("valeur2");
                int resultat = data.getIntExtra("result", 0);
                t.setText("Le boutton Soustraction a été touché: Le résultat de la soustraction de " + nombre1 + " et " + nombre2 + " est: " + resultat);
            }
        }
    }
}