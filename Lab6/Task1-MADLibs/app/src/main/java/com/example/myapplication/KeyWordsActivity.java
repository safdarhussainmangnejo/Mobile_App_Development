package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KeyWordsActivity extends AppCompatActivity{
    private Button OkButton;
    private EditText KeyWordsText;
    private TextView WordSpecifierTextView;
    private TextView WordsLeftTextView;
    private Story objKeyWords;
    private Scanner mScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_words);

        OkButton = (Button) findViewById(R.id.button2);
        KeyWordsText = (EditText) findViewById(R.id.Keywords);
        WordSpecifierTextView = (TextView) findViewById(R.id.textView3);
        WordsLeftTextView = (TextView) findViewById(R.id.WordsLeftText);

        ArrayList<Integer> files = new ArrayList<>();
        files.add(R.raw.madlib0);
        files.add(R.raw.madlib1);
        files.add(R.raw.madlib2);
        files.add(R.raw.madlib3);
        files.add(R.raw.madlib4);

        Random random = new Random();
        int index = random.nextInt(files.size());
        int id = files.get(index);
        mScanner = new Scanner(getResources().openRawResource(id));
        objKeyWords= new Story(mScanner);

        WordsLeftTextView.setText(objKeyWords.getPlaceholderRemainingCount() + " word(s) left to complete ");
        WordSpecifierTextView.setText("Please add a/an "+objKeyWords.getNextPlaceholder());
        OkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!KeyWordsText.getText().toString().equals("")){
                    objKeyWords.FilledInPlaceholder(KeyWordsText.getText().toString());
                    if(objKeyWords.getNextPlaceholder().equals("")){
                        startShowStoryActivity(objKeyWords);
                    }else{
                        KeyWordsText.setText("");
                        WordsLeftTextView.setText(objKeyWords.getPlaceholderRemainingCount()+ " word(s) left to complete");
                        WordSpecifierTextView.setText(objKeyWords.getNextPlaceholder());
                    }
                }
            }
        });
    }

    private void startShowStoryActivity(Story story){
        Intent intent= new Intent(this, StoryDetailsActivity.class);
        intent.putExtra("story", story.toString());
        startActivity(intent);
    }
}