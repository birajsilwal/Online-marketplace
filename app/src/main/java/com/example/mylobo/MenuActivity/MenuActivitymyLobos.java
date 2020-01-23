package com.example.mylobo.MenuActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.R;
import com.example.mylobo.myLobos.MainActivity;

public class MenuActivitymyLobos extends AppCompatActivity {

    public static final String TAG = "MenuActivityMarketplace";
    ImageView ivBackMenumylobo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu_mylobos);

    ivBackMenumylobo = findViewById(R.id.ivBackMenumylobo);

        ivBackMenumylobo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MenuActivitymyLobos.this, MainActivity.class);
            startActivity(i);
            }
        });
    }
}
