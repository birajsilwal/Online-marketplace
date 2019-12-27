package com.example.mylobo.Marketplace;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mylobo.R;
import com.parse.GetDataCallback;
import com.parse.ParseFile;

public class DetailPostMarketplace extends AppCompatActivity {

    private static String TAG = "DetailPostMarketplace";

    ImageView ivImageDMp;
    TextView tvTitleMp;
    EditText etPriceMp;
    TextView tvSeller;
    String title, username;
    String price;
    int image;
    PostMarketplace postMarketplace;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_marketplace);

//        PostMarketplace postMarketplace = new PostMarketplace();

        ivImageDMp = findViewById(R.id.ivImageDMp);
        tvTitleMp = findViewById(R.id.tvTitleMp);
        etPriceMp = findViewById(R.id.etPriceMp);
        tvSeller = findViewById(R.id.tvSeller);

        title = getIntent().getStringExtra("title");
        price = getIntent().getStringExtra("price");
        username = getIntent().getStringExtra("username");
        Log.e(TAG, "Error in Detail Marketplace");

        image = getIntent().getIntExtra("image", 0);
//        image = getIntent().getData(Uri);

        tvSeller.setText(username);
        tvTitleMp.setText(title);
        etPriceMp.setText(price);

//        ivImageDMp.setImageResource(image);
        Glide.with(this).load(image).into(ivImageDMp);
    }
}
