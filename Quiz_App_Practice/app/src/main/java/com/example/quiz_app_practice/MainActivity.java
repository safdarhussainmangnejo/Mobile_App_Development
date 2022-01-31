package com.example.quiz_app_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    QuizAdapter quizAdapter;
    ArrayList<Quiz> quizArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        quizArrayList = new ArrayList<>();

        quizArrayList.add(new Quiz("Who is founder of Pakistan?", "Quiad i Azam", "Allama Iqbal", "Quiad i Azam"));
        quizArrayList.add(new Quiz("Who is the current prime minister of Pakistan?", "Imran Khan", "Nawaz Sharif", "Imran Khan"));
        quizArrayList.add(new Quiz("Who is the HoD of CS Dept. at Sukkur IBA?", "Sajid Khan", "Javed Shahani", "Javed Shahani"));
        quizArrayList.add(new Quiz("How many academic blocks are there at Sukkur IBA?", "2", "3", "3"));

        quizAdapter = new QuizAdapter(this, R.layout.list_items, quizArrayList);
        listView.setAdapter(quizAdapter);

    }

    public void submit(View view){
        int score =0;

        Adapter adapter = (QuizAdapter) listView.getAdapter();

        for(int i=0; i<adapter.getCount(); i++){
            Quiz question = (Quiz) adapter.getItem(i);

            if((question.getAnswer()!=null)){
                if (question.getAnswer().equals(question.getCorrectAnswer())){
                    score++;
                }

            }

            Toast.makeText(this, "Score: " +score+ " Out of "+ adapter.getCount(), Toast.LENGTH_LONG).show();
        }
    }
}