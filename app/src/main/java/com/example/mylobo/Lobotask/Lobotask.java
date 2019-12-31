package com.example.mylobo.Lobotask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;

public class Lobotask extends AppCompatActivity {

    ImageView ivBackLobotask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_lobotask);

        ivBackLobotask = findViewById(R.id.ivBackLobotask);
//        ivMenuLobotask = findViewById(R.id.ivMenuLobotask);

        ivBackLobotask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lobotask.this, HomeScreen.class);
                startActivity(intent);
            }
        });
    }
}
