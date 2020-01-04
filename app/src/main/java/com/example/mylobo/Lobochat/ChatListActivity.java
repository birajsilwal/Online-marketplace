package com.example.mylobo.Lobochat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;

public class ChatListActivity extends AppCompatActivity {

    RelativeLayout llwithfriendnameinchatlist;
    ImageView ivBackLobochatlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        llwithfriendnameinchatlist = findViewById(R.id.llwithfriendnameinchatlist);
        ivBackLobochatlist = findViewById(R.id.ivBackLobochatlist);

        ivBackLobochatlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatListActivity.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        llwithfriendnameinchatlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatListActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
