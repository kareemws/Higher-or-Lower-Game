package com.example.kareemwaleed.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random generator;
    private Double randomDouble;
    private Integer randomInteger;
    private Integer challengeCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generator = new Random();
        updateRandomInteger();
        challengeCounter = 1;
    }

    public void submit(View view)
    {
        EditText guessingField = (EditText) findViewById(R.id.guessingField);
        if(guessingField.getText().length() == 0)
            Toast.makeText(getApplicationContext(), "Enter a number !", Toast.LENGTH_LONG).show();
        else
        {
            Integer userGuess = Integer.parseInt(guessingField.getText().toString());
            TextView challengeLabel = (TextView) findViewById(R.id.challengeLabel);
            if(userGuess == randomInteger)
            {
                Toast.makeText(getApplicationContext(), "You got it Right !!", Toast.LENGTH_LONG).show();
                updateRandomInteger();
                challengeCounter++;
                challengeLabel.setText("Challenge#" + challengeCounter.toString());
            }
            else if(userGuess < randomInteger)
                Toast.makeText(getApplicationContext(), "Too Low", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Too High", Toast.LENGTH_LONG).show();
            guessingField.setText(null);
        }
    }

    private void updateRandomInteger()
    {
        randomDouble = generator.nextDouble();
        randomInteger = (int)(randomDouble * 80 - 40);
    }
}
