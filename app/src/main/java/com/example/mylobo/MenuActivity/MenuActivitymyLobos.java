package com.example.mylobo.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.LoginActivity;
import com.example.mylobo.PublicProfileActivity;
import com.example.mylobo.R;
import com.example.mylobo.myLobos.MainActivity;
import com.parse.ParseUser;

public class MenuActivitymyLobos extends AppCompatActivity {

    public static final String TAG = "MenuActivityMarketplace";
    ImageView ivBackMenu;
    Button btnLogOut, btnHome, btnSetting, btnPublicProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu_mylobos);

    ivBackMenu = findViewById(R.id.ivBackMenuMp);
    btnHome = findViewById(R.id.btnHome);
    btnLogOut = findViewById(R.id.btnLogOut);
    btnSetting = findViewById(R.id.btnSetting);
    btnPublicProfile = findViewById(R.id.btnPublicProfile);

        ivBackMenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MenuActivitymyLobos.this, MainActivity.class);
            startActivity(i);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MenuActivitymyLobos.this, HomeScreen.class);
            startActivity(i);
            }
        });

        btnPublicProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivitymyLobos.this, PublicProfileActivity.class);
                startActivity(i);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivitymyLobos.this, MenuActivitySettingPrivacy.class);
                startActivity(i);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ParseUser.logOut();
            ParseUser currentUser = ParseUser.getCurrentUser();
            Intent i = new Intent(MenuActivitymyLobos.this, LoginActivity.class);
            startActivity(i);
//            finish();

        }
    });
    }
}
