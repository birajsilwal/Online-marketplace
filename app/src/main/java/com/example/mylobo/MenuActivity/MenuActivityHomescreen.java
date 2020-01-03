package com.example.mylobo.MenuActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.BookmarksActivity;
import com.example.mylobo.HomeScreen;
import com.example.mylobo.LoginActivity;
import com.example.mylobo.PublicProfile.PublicProfileEditorActivity;
import com.example.mylobo.R;
import com.parse.ParseUser;

public class MenuActivityHomescreen extends AppCompatActivity {

    private ImageView ivHome;
    private ImageView ivPublicProfileML;
    private ImageView ivBookmark;
    private ImageView ivSetting;
    private ImageView ivLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_homescreen);

        ImageView ivBackMenuHomescreen = findViewById(R.id.ivBackMenuHomescreen);
        Button btnHome = findViewById(R.id.btnHome);
        Button btnPublicProfile = findViewById(R.id.btnPublicProfile);
        Button btnBookmark = findViewById(R.id.btnBookmark);
        Button btnSetting = findViewById(R.id.btnSetting);
        Button btnLogOut = findViewById(R.id.btnLogOut);

        ivBackMenuHomescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivityHomescreen.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivityHomescreen.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        btnPublicProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivityHomescreen.this, PublicProfileEditorActivity.class);
                startActivity(intent);
            }
        });

        btnBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivityHomescreen.this, BookmarksActivity.class);
                startActivity(intent);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivityHomescreen.this, MenuActivitySettingPrivacy.class);
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                Intent i = new Intent(MenuActivityHomescreen.this, LoginActivity.class);
                startActivity(i);
            }
        });


    }
}
