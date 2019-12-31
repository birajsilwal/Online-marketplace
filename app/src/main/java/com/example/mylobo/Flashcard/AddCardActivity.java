package com.example.mylobo.Flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.R;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        String  question = getIntent().getStringExtra("question");
        String  correct_answer = getIntent().getStringExtra("correct_answer");

        ((EditText) findViewById(R.id.question)).setText(question);
        ((EditText) findViewById(R.id.correct_answer)).setText(correct_answer);


        findViewById(R.id.cancel_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        findViewById(R.id.save_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = ((EditText) findViewById(R.id.question)).getText().toString();
                String correct_answer = ((EditText) findViewById(R.id.correct_answer)).getText().toString();


                if(question.length() == 0 || correct_answer.length() == 0 ){
                    Toast.makeText(getApplicationContext(), "Must enter all question and answer.", Toast.LENGTH_SHORT).show();
                }else {
                    Intent data = new Intent();
                    data.putExtra("question", question);
                    data.putExtra("correct_answer", correct_answer);

                    setResult(RESULT_OK, data);
                    finish();
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });
    }
}