package com.example.mylobo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.MenuActivity.MenuActivitySettingPrivacy;

public class DeleteAccountActivity extends AppCompatActivity {

    Button btnCancelDelete, btnSubmitDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        btnSubmitDelete = findViewById(R.id.btnSubmitDelete);
        btnCancelDelete = findViewById(R.id.btnCancelDelete);

        btnSubmitDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteAccountActivity.this, DeleteAccountMessageActivity.class);
                startActivity(intent);
            }
        });


        btnCancelDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteAccountActivity.this, MenuActivitySettingPrivacy.class);
                startActivity(intent);
            }
        });

    }
}
