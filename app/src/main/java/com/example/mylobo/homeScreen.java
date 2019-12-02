package com.example.mylobo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mylobo.myBooks.myBooks;

public class homeScreen extends AppCompatActivity {

    Button btnMarketplace, btnMyLobos, btnMybooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnMarketplace = findViewById(R.id.btnMarketplace);
        btnMybooks = findViewById(R.id.btnMyBooks);
        btnMyLobos = findViewById(R.id.btnMyLobos);

        // takes to myLobos
        btnMyLobos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, MainActivity.class);
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
    }
}
