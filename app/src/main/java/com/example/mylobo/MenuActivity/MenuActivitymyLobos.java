package com.example.mylobo.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylobo.LoginActivity;
import com.example.mylobo.R;
import com.example.mylobo.homeScreen;
import com.example.mylobo.myLobos.MainActivity;
import com.parse.ParseUser;

public class MenuActivitymyLobos extends AppCompatActivity {

    public static final String TAG = "MenuActivityMarketplace";
    TextView btnHome;
    ImageView ivBackMenu;
    TextView btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu_mylobos);

    ivBackMenu = findViewById(R.id.ivBackMenuMp);
    btnHome = findViewById(R.id.btnHome);
    btnLogOut = findViewById(R.id.btnLogOut);

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
            Intent i = new Intent(MenuActivitymyLobos.this, homeScreen.class);
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
