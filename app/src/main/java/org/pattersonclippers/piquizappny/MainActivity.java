package org.pattersonclippers.piquizappny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionTV;
    Button trueBTN, falseBTN, scoreBTN;
    String showAnswer;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = (TextView) findViewById(R.id.questionTV);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        scoreBTN = (Button) findViewById(R.id.scoreBTN);
        showAnswer = "";
        score = 0;

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAnswer = "You got it wrong!";
                int duration = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(getApplicationContext(), showAnswer, duration);
                t.show();
            }
        });

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAnswer = "You got it right!";
                int duration = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(getApplicationContext(), showAnswer, duration);
                t.show();
                score = score + 1;
            }
        });

        scoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                myIntent.putExtra("score", score);
                startActivity(myIntent);
            }
        });

    }
}