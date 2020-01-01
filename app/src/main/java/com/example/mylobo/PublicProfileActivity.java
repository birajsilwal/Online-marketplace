package com.example.mylobo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PublicProfileActivity extends AppCompatActivity {

    TextView tvProfileName;

    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_profile);

        tvProfileName = findViewById(R.id.tvProfileName);

        userName = getIntent().getStringExtra("profileName");
        tvProfileName.setText(userName);


    }

    public void previous(View view){
        Intent i = new Intent(PublicProfileActivity.this, HomeScreen.class);
        startActivity(i);
    }
}
