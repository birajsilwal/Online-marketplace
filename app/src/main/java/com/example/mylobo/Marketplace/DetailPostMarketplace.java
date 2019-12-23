package com.example.mylobo.Marketplace;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.R;
import com.example.mylobo.myLobos.Post;
import com.parse.ParseFile;

public class DetailPostMarketplace extends AppCompatActivity {

    ImageView ivImageMp;
    TextView tvTitleMp;
    EditText etPriceMp;
    TextView tvSeller;
    String title, username;
    String price;
    ParseFile image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_marketplace);

//        PostMarketplace postMarketplace = new PostMarketplace();

        ivImageMp = findViewById(R.id.ivImageMp);
        tvTitleMp = findViewById(R.id.tvTitleMp);
        etPriceMp = findViewById(R.id.etPriceMp);
        tvSeller = findViewById(R.id.tvSeller);

        title = getIntent().getStringExtra("title");
        price = getIntent().getStringExtra("price");
        username = getIntent().getStringExtra("username");
        tvSeller.setText(username);
        tvTitleMp.setText(title);
        etPriceMp.setText(price);

//        image = getIntent().getStringExtra(String.valueOf(image));
//        ivImageMp.setImageResource(image);
//        Glide.with(this).load(image.getUrl()).into(ivImageMp);

    }
}
