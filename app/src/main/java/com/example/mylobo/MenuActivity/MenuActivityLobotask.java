package com.example.mylobo.MenuActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.Lobotask.LobotaskMain;
import com.example.mylobo.R;

public class MenuActivityLobotask extends AppCompatActivity {

    ImageView ivBackMenuLobotask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lobotask);

        ivBackMenuLobotask = findViewById(R.id.ivBackMenuLobotask);

        ivBackMenuLobotask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivityLobotask.this, LobotaskMain.class);
                startActivity(intent);
            }
        });
    }
}
