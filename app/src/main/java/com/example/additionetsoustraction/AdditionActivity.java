package com.example.additionetsoustraction;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdditionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Addition");
        setContentView(R.layout.activity_addition);
        TextView valeur1 = (TextView) findViewById(R.id.txtValeur1);
        TextView valeur2 = (TextView) findViewById(R.id.txtValeur2);

        Button send = (Button) findViewById(R.id.btnReturn);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("valeur1", valeur1.getText().toString());
                result.putExtra("valeur2", valeur2.getText().toString());
                result.putExtra("result", (Integer.parseInt(valeur1.getText().toString()) + Integer.parseInt(valeur2.getText().toString())));
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        });
    }
}