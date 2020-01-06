package com.example.mylobo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class DeleteAccountMessageActivity extends AppCompatActivity {

    TextView tvGotoLoginpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account_message);

        tvGotoLoginpage  = findViewById(R.id.tvGotoLoginpage);

        tvGotoLoginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                Intent intent = new Intent(DeleteAccountMessageActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
