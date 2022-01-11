package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoryDetailsActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mNextStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_details);

        mTextView = (TextView) findViewById(R.id.textView4);
        mNextStory = (Button) findViewById(R.id.button3);

        Intent intent = getIntent();
        String stringThing = intent.getStringExtra("story");
        mTextView.setText(Html.fromHtml(stringThing));
        mNextStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
    }

    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}