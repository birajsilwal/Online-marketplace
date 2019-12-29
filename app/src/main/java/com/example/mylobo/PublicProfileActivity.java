package com.example.mylobo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PublicProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_profile);

    }

    public void previous(View view){
        Intent i = new Intent(PublicProfileActivity.this, HomeScreen.class);
        startActivity(i);
    }

}
