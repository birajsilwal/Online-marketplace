package com.example.mylobo.myLobos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mylobo.R;
import com.parse.ParseFile;

public class DetailActivity extends AppCompatActivity {

    ImageView ivImageD;
    TextView tvDescription;
    String description;
    Post post = new Post();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivImageD = findViewById(R.id.ivImageD);
        tvDescription = findViewById(R.id.tvDescriptionTitle);

        description = getIntent().getStringExtra("description");
//        image =  getIntent().getIntExtra("image", 0);
        ParseFile image = post.getImage();

//        ivImage.setImageResource(image);
        tvDescription.setText(description);

        Glide.with(this).load(image.getUrl()).into(ivImageD);
    }
}
