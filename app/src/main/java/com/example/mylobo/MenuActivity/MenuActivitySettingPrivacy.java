package com.example.mylobo.MenuActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.DeleteAccountActivity;
import com.example.mylobo.R;

public class MenuActivitySettingPrivacy extends AppCompatActivity {

    ImageView ivBackSettingandPrivacy;
    TextView tvDeleteAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_setting_privacy);

        ivBackSettingandPrivacy = findViewById(R.id.ivBackSettingandPrivacy);
        tvDeleteAccount = findViewById(R.id.tvDeleteAccount);

        ivBackSettingandPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivitySettingPrivacy.this, MenuActivityHomescreen.class);
                startActivity(intent);
            }
        });


        tvDeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivitySettingPrivacy.this, DeleteAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
