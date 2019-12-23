package com.example.mylobo.Marketplace;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.Model;
import com.example.mylobo.R;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class PostsAdapterMarketplace extends RecyclerView.Adapter<PostsAdapterMarketplace.ViewHolder>{

    // constructors of the adapter taking two variables, context and data source which is the list of the posts

    private Context contextMarketplace;
    private List<PostMarketplace> postsMarketplace;

    public PostsAdapterMarketplace(Context contextMarketplace, List<PostMarketplace> postsMarketplace) {
        this.contextMarketplace = contextMarketplace;
        this.postsMarketplace = postsMarketplace;
        // after this we can extend the PostsAdapterMarketplace
    }

    // these three methods appeared after extending the class
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextMarketplace).inflate(R.layout.item_post_marketplace, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PostMarketplace postMarketplace = postsMarketplace.get(position);
        holder.tvTitle.setText(postMarketplace.getTitle());
        holder.bind(postMarketplace);

        final ParseFile image = postMarketplace.getImage();

        holder.rlMarketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contextMarketplace, DetailPostMarketplace.class);
                i.putExtra("image", image);
                i.putExtra("title", postMarketplace.getTitle());
                contextMarketplace.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postsMarketplace.size();
    }

    // Inner class. It is defined first because we want the PostAdapterMp to extend recycler view adapter parametrized
    // by this view holder so some of the return methods and parameter inputs will reference view holder rather than the generic view holder
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        public ImageView ivImageMp;
        private TextView etPriceMp;
        private RelativeLayout rlMarketplace;

        // pull out a reference to each of the items in our item posts mp
        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitleMp);
            ivImageMp = itemView.findViewById(R.id.ivImageMp);
            etPriceMp = itemView.findViewById(R.id.etPriceMp);
            rlMarketplace = itemView.findViewById(R.id.rlMarketplace);
        }

        // responsible for taking a post and binding it to the view that we have here
        public void bind(PostMarketplace postMarketplace){
            tvTitle.setText(postMarketplace.getTitle());
            etPriceMp.setText(postMarketplace.getPrice());
            ParseFile image = postMarketplace.getImage();
            if (image != null) {
                Glide.with(contextMarketplace).load(image.getUrl()).into(ivImageMp);
            }
        }

    }
}






















