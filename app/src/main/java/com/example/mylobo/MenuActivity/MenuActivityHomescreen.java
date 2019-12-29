package com.example.mylobo.MenuActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;

public class MenuActivityHomescreen extends AppCompatActivity {

    ImageView ivBackMenuMp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_homescreen);

        ivBackMenuMp = findViewById(R.id.ivBackMenuMp);

        ivBackMenuMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivityHomescreen.this, HomeScreen.class);
                startActivity(intent);
            }
        });

    }
}
