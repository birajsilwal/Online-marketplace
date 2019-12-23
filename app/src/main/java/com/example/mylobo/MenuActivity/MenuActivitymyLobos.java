package com.example.mylobo.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylobo.LoginActivity;
import com.example.mylobo.Marketplace.Marketplace;
import com.example.mylobo.R;
import com.example.mylobo.fragments.PostsFragment;
import com.example.mylobo.fragmentsMarketplace.ComposeFragmentMarketplace;
import com.example.mylobo.homeScreen;
import com.example.mylobo.myLobos.MainActivity;
import com.parse.ParseUser;

public class MenuActivitymyLobos extends AppCompatActivity {

    public static final String TAG = "MenuActivity";
    TextView tvHome;
    ImageView ivBackMenu;
    TextView tvLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu_activitymy_lobos);

    ivBackMenu = findViewById(R.id.ivBackMenu);
    tvHome = findViewById(R.id.tvHome);
    tvLogOut = findViewById(R.id.tvLogOut);

        ivBackMenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MenuActivitymyLobos.this, MainActivity.class);
            startActivity(i);
        }
    });

        tvHome.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MenuActivitymyLobos.this, homeScreen.class);
            startActivity(i);
        }
    });


        tvLogOut.setOnClickListener(new View.OnClickListener() {
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
