package com.example.mylobo.myBooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;

public class myBooks extends AppCompatActivity {

    ImageView ivBackmyBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books);

        ivBackmyBooks = findViewById(R.id.ivBackmyBooks);

        ivBackmyBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myBooks.this, HomeScreen.class);
                startActivity(intent);
            }
        });
    }
}
