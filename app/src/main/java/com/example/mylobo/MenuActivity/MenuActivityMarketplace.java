package com.example.mylobo.MenuActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.Marketplace.Marketplace;
import com.example.mylobo.Marketplace.YourListingsActivity;
import com.example.mylobo.PublicProfile.PublicProfileEditorActivity;
import com.example.mylobo.R;


public class MenuActivityMarketplace extends AppCompatActivity {

    public static final String TAG = "MenuActivityMarketplace";
    Button btnYourlistings, btnHome;
    ImageView ivBackMenuMp;
    Button btnPublicProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_marketplace);

        btnYourlistings = findViewById(R.id.btnYourlistings);
        ivBackMenuMp = findViewById(R.id.ivBackMenuMp);
        btnHome = findViewById(R.id.btnHome);
        btnPublicProfile = findViewById(R.id.btnPublicProfile);


        btnYourlistings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivityMarketplace.this, YourListingsActivity.class);
                startActivity(i);
            }
        });

        ivBackMenuMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivityMarketplace.this, Marketplace.class);
                startActivity(i);
//                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivityMarketplace.this, HomeScreen.class);
                startActivity(i);
            }
        });

        btnPublicProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivityMarketplace.this, PublicProfileEditorActivity.class);
                startActivity(i);
            }
        });
    }

}
