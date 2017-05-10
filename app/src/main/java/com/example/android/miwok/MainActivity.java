package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbers = (TextView) findViewById(R.id.numbers);
        TextView cFamily = (TextView) findViewById(R.id.family);
        TextView cColors = (TextView) findViewById(R.id.colors);
        TextView cPhrases = (TextView) findViewById(R.id.phrases);


        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        cFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, FamilyActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        cColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, ColorsActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        cPhrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, PhrasesActivity.class);

                // Start the new activity
                startActivity(numbersIntent);
            }
        });
        // Set the content of the activity to use the activity_main.xml layout file

    }


    public void openNumbersList(View view){
        Intent i = new Intent(this, NumbersActivity.class);
        startActivity(i);
    }
}