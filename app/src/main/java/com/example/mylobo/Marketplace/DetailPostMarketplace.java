package com.example.mylobo.Marketplace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mylobo.Lobochat.ChatActivity;
import com.example.mylobo.PublicProfile.PublicProfileViewerActivity;
import com.example.mylobo.R;

public class DetailPostMarketplace extends AppCompatActivity {

    private static String TAG = "DetailPostMarketplace";

    ImageView ivBackDMp;
    ImageView ivImageDMp;
    TextView tvTitleMp, tvDescription, tvSeePublicProfile;
    TextView etPriceMp;
    TextView tvSeller;
    RelativeLayout rlLobochatinDetailMarketplace;

    String title, username, description;
    String price;
    String objectId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_marketplace);

        ivImageDMp = findViewById(R.id.ivImageDMp);
        tvTitleMp = findViewById(R.id.tvTitleMp);
        etPriceMp = findViewById(R.id.etPriceMp);
        tvSeller = findViewById(R.id.tvSeller);
        tvDescription = findViewById(R.id.tvDescription);
        ivBackDMp = findViewById(R.id.ivBackDMp);
        tvSeePublicProfile = findViewById(R.id.tvSeePublicProfile);
        rlLobochatinDetailMarketplace = findViewById(R.id.rlLobochatinDetailMarketplace);

        title = getIntent().getStringExtra("title");
        price = getIntent().getStringExtra("price");
        username = getIntent().getStringExtra("username");
        description = getIntent().getStringExtra("description");
        objectId = getIntent().getStringExtra("objectId");

        tvSeller.setText(username);
        tvTitleMp.setText(title);
        etPriceMp.setText(price);
        tvDescription.setText(description);

//        String todoId = getIntent().getStringExtra("todo_id");
//        ParseQuery<PostMarketplace> query = ParseQuery.getQuery(PostMarketplace.class);
//        query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK); // or CACHE_ONLY
//        query.getInBackground(objectId, new GetCallback<PostMarketplace>() {
//                    public void done(PostMarketplace item, ParseException e) {
//                        if (e == null) {
//                            Log.i(TAG, "Item Found");
//                            image = item.getImage();
//                            Glide.with(DetailPostMarketplace.this).load(image.getUrl()).into(ivImageDMp);
//                        }
//                        else{
//                            Log.i(TAG, "Item not Found");
//                        }
//                    }
//                });

        String imageUrl = getIntent().getStringExtra("image");
        Glide.with(this).load(imageUrl).into(ivImageDMp);

        ivBackDMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPostMarketplace.this, Marketplace.class);
                startActivity(intent);
            }
        });

        rlLobochatinDetailMarketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPostMarketplace.this, ChatActivity.class);
                startActivity(intent);
            }
        });


        tvSeePublicProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPostMarketplace.this, PublicProfileViewerActivity.class);
                intent.putExtra("profileName", username);
                startActivity(intent);
            }
        });
    }
}