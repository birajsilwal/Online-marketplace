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
import com.example.mylobo.PublicProfileActivity;
import com.example.mylobo.R;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;

public class DetailPostMarketplace extends AppCompatActivity {

    private static String TAG = "DetailPostMarketplace";

    ImageView ivBackDMp;
    ImageView ivImageDMp;
    TextView tvTitleMp, tvDescription, tvSeePublicProfile;
    TextView etPriceMp;
    TextView tvSeller;

    String title, username, description;
    String price;
    ParseFile image;
    String objectId;

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
        tvSeePublicProfile = findViewById(R.id.tvSeePublicProfile);

        title = getIntent().getStringExtra("title");
        price = getIntent().getStringExtra("price");
        username = getIntent().getStringExtra("username");
        description = getIntent().getStringExtra("description");
        objectId = getIntent().getStringExtra("objectId");

        tvSeller.setText(username);
        tvTitleMp.setText(title);
        etPriceMp.setText(price);
        tvDescription.setText(description);

        String todoId = getIntent().getStringExtra("todo_id");
        ParseQuery<PostMarketplace> query = ParseQuery.getQuery(PostMarketplace.class);
        query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK); // or CACHE_ONLY
        query.getInBackground(objectId, new GetCallback<PostMarketplace>() {
                    public void done(PostMarketplace item, ParseException e) {
                        if (e == null) {
                            Log.i(TAG, "Item Found");
                            image = item.getImage();
                            Glide.with(DetailPostMarketplace.this).load(image.getUrl()).into(ivImageDMp);
                        }
                        else{
                            Log.i(TAG, "Item not Found");
                        }
                    }
                });

        ivBackDMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPostMarketplace.this, Marketplace.class);
                startActivity(intent);
            }
        });

        tvSeePublicProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPostMarketplace.this, PublicProfileActivity.class);
                intent.putExtra("profileName", username);
                startActivity(intent);
            }
        });
    }
}