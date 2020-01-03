package com.example.mylobo.Lobotask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.Lobotask.Project.Project;
import com.example.mylobo.Lobotask.Todo.Todo;
import com.example.mylobo.R;

public class LobotaskMain extends AppCompatActivity {

    ImageView ivBackLobotask;
    Button btnNewTask;
    Button btnNewGroupProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_lobotask);

        ivBackLobotask = findViewById(R.id.ivBackLobotask);
        btnNewTask = findViewById(R.id.btnNewTask);
        btnNewGroupProject = findViewById(R.id.btnNewGroupProject);

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

        btnNewGroupProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LobotaskMain.this, Project.class);
                startActivity(intent);
            }
        });
    }
}
