package com.example.mylobo.Marketplace;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mylobo.R;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class DetailPostMarketplace extends AppCompatActivity {

    private Context context;


    ImageView ivImageMp;
    TextView tvTitleMp;
    String title;
//    int image;
    ParseFile image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_item_post_marketplace);

        PostMarketplace postMarketplace = new PostMarketplace();

        ivImageMp = findViewById(R.id.ivImageMp);
        tvTitleMp = findViewById(R.id.tvTitleMp);

        title = getIntent().getStringExtra("title");
        tvTitleMp.setText(title);

//        image = getIntent().getStringExtra(String.valueOf(image));
//        ivImageMp.setImageResource(image);
        Glide.with(this).load(image.getUrl()).into(ivImageMp);

    }
}
