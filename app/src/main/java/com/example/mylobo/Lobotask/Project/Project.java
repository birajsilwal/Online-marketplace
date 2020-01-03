package com.example.mylobo.Lobotask.Project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.Lobotask.LobotaskMain;
import com.example.mylobo.R;

public class Project extends AppCompatActivity {

    TextView tvCS351_Snake;
    ImageView ivBackProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        tvCS351_Snake = findViewById(R.id.tvCS351_Snake);
        ivBackProject = findViewById(R.id.ivBackProject);

        tvCS351_Snake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Project.this, ProjectSnake.class);
                startActivity(intent);
            }
        });

        //TODO: add project menu activity

        ivBackProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Project.this, LobotaskMain.class);
                startActivity(intent);
            }
        });
    }
}
