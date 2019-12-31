package com.example.mylobo.Lobotask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;

public class LobotaskMain extends AppCompatActivity {

    ImageView ivBackLobotask;
    Button btnNewTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_lobotask);

        ivBackLobotask = findViewById(R.id.ivBackLobotask);
        btnNewTask = findViewById(R.id.btnNewTask);

        btnNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LobotaskMain.this, Todo.class);
                startActivity(intent);
            }
        });

        ivBackLobotask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LobotaskMain.this, HomeScreen.class);
                startActivity(intent);
            }
        });
    }
}
