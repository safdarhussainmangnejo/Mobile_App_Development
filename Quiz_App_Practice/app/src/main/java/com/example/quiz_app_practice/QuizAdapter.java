package com.example.quiz_app_practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter  extends ArrayAdapter<Quiz> {

    Context context;
    int resource;
    List<Quiz> quizList;

    public QuizAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Quiz> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource=resource;
        this.quizList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        Quiz question1 = quizList.get(position);
        TextView questionId = convertView.findViewById(R.id.question);
        RadioButton radioButton1 = convertView.findViewById(R.id.ans1);
        RadioButton radioButton2 = convertView.findViewById(R.id.ans2);

        questionId.setText(question1.question);
        radioButton1.setText(question1.optionA);
        radioButton2.setText(question1.optionB);

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton r = (RadioButton) v;

                question1.setAnswer(r.getText().toString());
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton r = (RadioButton) v;

                question1.setAnswer(r.getText().toString());
            }
        });

        return convertView;
    }
}
