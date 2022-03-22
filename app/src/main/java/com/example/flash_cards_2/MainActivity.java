package com.example.flash_cards_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView;
    TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.question);
        answerTextView = findViewById(R.id.right_answer);

        answerTextView.setVisibility(View.INVISIBLE);
        questionTextView.setOnClickListener(view -> {
            questionTextView.setVisibility(View.INVISIBLE);
            answerTextView.setVisibility(View.VISIBLE);

            Toast.makeText(MainActivity.this, "Enter your text", Toast.LENGTH_SHORT).show();
            Log.i("Andreza", "Entered onClick");

        });
        
        ImageView addQuestionImageView = findViewById(R.id.plustn);
        addQuestionImageView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
            startActivityForResult(intent, 100);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult((requestCode), resultCode, data);
        if (requestCode == 100) // this 100 needs to match the 100 we used when we called startActivityForResult!
        {
            if (data != null) {
                String questionString = data.getExtras().getString("Question_key");
                String answerString = data.getExtras().getString("Answer_key");
                questionTextView.setText(questionString);
                answerTextView.setText(answerString);

            }
        }
    }
}