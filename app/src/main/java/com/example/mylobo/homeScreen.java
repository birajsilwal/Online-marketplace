package com.example.mylobo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mylobo.Lobochat.ChatActivity;
import com.example.mylobo.Marketplace.Marketplace;
import com.example.mylobo.myBooks.myBooks;
import com.example.mylobo.myLobos.MainActivity;

public class homeScreen extends AppCompatActivity {

    Button btnMarketplace, btnMyLobos, btnMybooks, btnLobochat;
    ImageView ivMarketplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnMarketplace = findViewById(R.id.btnMarketplace);
        btnMybooks = findViewById(R.id.btnMyBooks);
        btnMyLobos = findViewById(R.id.btnMyLobos);
        ivMarketplace = findViewById(R.id.ivMarketplace);
        btnLobochat = findViewById(R.id.btnLobochat);

        // takes to mylobos
        btnMyLobos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // takes to Marketplace
        ivMarketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, Marketplace.class);
                startActivity(intent);
            }
        });

        // takes to Marketplace
        btnMarketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, Marketplace.class);
                startActivity(intent);
            }
        });

        // takes to myBooks
        btnMybooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, myBooks.class);
                startActivity(intent);
            }
        });

        btnLobochat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
