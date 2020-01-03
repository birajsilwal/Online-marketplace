package com.example.mylobo.PublicProfile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;

public class PublicProfileEditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_profile_editor);

    }

    public void previous(View view){
        Intent i = new Intent(PublicProfileEditorActivity.this, HomeScreen.class);
        startActivity(i);
    }
}
