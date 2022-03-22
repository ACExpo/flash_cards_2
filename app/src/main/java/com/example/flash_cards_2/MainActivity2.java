package com.example.flash_cards_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.xbtn).setOnClickListener(view -> finish());

        findViewById(R.id.savebtn).setOnClickListener(view -> {
            Intent data;
            data = new Intent();
            String inputQuestion = ((EditText) findViewById(R.id.editText1)).getText().toString();
            if (inputQuestion.isEmpty()){
                ((TextView) findViewById(R.id.editText1)).setText("Create your own question");
            } else {
                ((TextView) findViewById(R.id.editText1)).setText(inputQuestion);
            }
            String inputAnswer = ((EditText) findViewById(R.id.editText2)).getText().toString();
            if (inputQuestion.isEmpty()){
                ((TextView) findViewById(R.id.editText2)).setText("Create your own answer");
            } else {
                ((TextView) findViewById(R.id.editText2)).setText(inputQuestion);
            data.putExtra("Question_key", inputQuestion);
            data.putExtra("Answer_key", inputAnswer);
            setResult(RESULT_OK, data);
            finish();}
        });
    }
}