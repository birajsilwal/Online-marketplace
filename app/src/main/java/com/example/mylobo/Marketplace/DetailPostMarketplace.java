package com.example.mylobo.Marketplace;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mylobo.R;

public class DetailPostMarketplace extends AppCompatActivity {

    private static String TAG = "DetailPostMarketplace";

    ImageView ivImageDMp, ivBackDMp;
    TextView tvTitleMp, tvDescription;
    TextView etPriceMp;
    TextView tvSeller;


    String title, username, description;
    String price;
    int image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_marketplace);

//        PostMarketplace postMarketplace = new PostMarketplace();

        ivImageDMp = findViewById(R.id.ivImageDMp);
        tvTitleMp = findViewById(R.id.tvTitleMp);
        etPriceMp = findViewById(R.id.etPriceMp);
        tvSeller = findViewById(R.id.tvSeller);
        tvDescription = findViewById(R.id.tvDescription);
        ivBackDMp = findViewById(R.id.ivBackDMp);

        ivBackDMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPostMarketplace.this, Marketplace.class);
                startActivity(intent);
            }
        });

        title = getIntent().getStringExtra("title");
        price = getIntent().getStringExtra("price");
        username = getIntent().getStringExtra("username");
        description = getIntent().getStringExtra("description");
        Log.e(TAG, "Error in Detail Marketplace");

        image = getIntent().getIntExtra("image", 0);
//        image = getIntent().getData(Uri);

        tvSeller.setText(username);
        tvTitleMp.setText(title);
        etPriceMp.setText(price);
        tvDescription.setText(description);

//        ivImageDMp.setImageResource(image);
        Glide.with(this).load(image).into(ivImageDMp);
    }
}
