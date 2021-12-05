package com.example.labexamsafdar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView UserScore1, UserScore2;
    ImageView UserImg1, UserImg2;
    Button Hitme, Stand;
    int Score1 = 0, Score2 = 0;
    Random randomVal = new Random();
    Boolean turn = false;
    int S1 = 0;
    int S2 =0;
    Boolean stand1 =false;

    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ace, R.drawable.jack, R.drawable.king, R.drawable.queen,
            R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ace, R.drawable.jack, R.drawable.king, R.drawable.queen,
            R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ace, R.drawable.jack, R.drawable.king, R.drawable.queen,
            R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ace, R.drawable.jack, R.drawable.king, R.drawable.queen};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserImg1 = findViewById(R.id.imageViewUser1);
        UserImg2 = findViewById(R.id.imageViewUser2);

        UserScore1 = findViewById(R.id.textViewScore1);
        UserScore2 = findViewById(R.id.textViewScore2);

        Hitme = findViewById(R.id.buttonHit);
        Stand = findViewById(R.id.buttonStand);

        if((S1<=21 && S2<=21) && S1>S2){
            Toast.makeText(this,"User1 Won", Toast.LENGTH_LONG).show();
        }
        else if((S1<=21 && S2<=21) && S2>S1){
            Toast.makeText(this,"User2 Won", Toast.LENGTH_LONG).show();
        }
    }


    public void onHit(View view) {

        if(turn==false){
            Score1=0;

            int val1 = randomVal.nextInt(52);
            UserImg1.setImageResource(images[val1]);
            findScore(val1);
            S1 = S1+Score1;
            UserScore1.setText("Score: "+S1);
            turn = true;
        }

        else if(turn){
            Score1=0;

            //S2=Score1;
            int val1 = randomVal.nextInt(52);
            UserImg2.setImageResource(images[val1]);
            findScore(val1);
            S2 = S2+Score1;
            UserScore2.setText("Score: "+S2);
            turn = false;
        }


    }

    public void findScore(int scor) {

        if (images[scor] == R.drawable.one) {
            Score1 += 1;
        } else if (images[scor] == R.drawable.two) {
            Score1 += 2;
        } else if (images[scor] == R.drawable.three) {
            Score1 += 3;
        } else if (images[scor] == R.drawable.four) {
            Score1 += 4;
        } else if (images[scor] == R.drawable.five) {
            Score1 += 5;
        } else if (images[scor] == R.drawable.six) {
            Score1 += 6;
        } else if (images[scor] == R.drawable.seven) {
            Score1 += 7;
        } else if (images[scor] == R.drawable.eight) {
            Score1 += 8;
        } else if (images[scor] == R.drawable.nine) {
            Score1 += 9;
        }
        else if(images[scor]==R.drawable.ace){
            Score1 +=10;
        }
        else if(images[scor]==R.drawable.queen){
            Score1 +=10;
        }
        else if(images[scor]==R.drawable.king){
            Score1 +=10;
        }
        else if(images[scor]==R.drawable.jack){
            Score1 +=10;
        }
    }

    public void OnStand(View view){

        if(turn==false){
            S1=0;

        }

    }

}