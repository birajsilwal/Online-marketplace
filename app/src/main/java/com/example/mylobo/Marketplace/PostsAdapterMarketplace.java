package com.example.mylobo.Marketplace;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mylobo.R;
import com.parse.ParseFile;

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final PostMarketplace postMarketplace = postsMarketplace.get(position);
        holder.bind(postMarketplace);
        final ParseFile image = postMarketplace.getImage();
        holder.rlMarketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contextMarketplace, DetailPostMarketplace.class);
                i.putExtra("title", postMarketplace.getTitle());
                i.putExtra("price", postMarketplace.getPrice());
                i.putExtra("username", postMarketplace.getUser().getUsername());
                i.putExtra("description", postMarketplace.getDescription());
//                i.putExtra("objectId", postMarketplace.getObjectId());
                i.putExtra("image", image.getUrl());
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

        private TextView tvItemNamePMarketplace;
        public ImageView ivImageMp;
        private TextView etPriceMp;
        private RelativeLayout rlMarketplace;

        // pull out a reference to each of the items in our item posts mp
        public ViewHolder(View itemView) {
            super(itemView);

            tvItemNamePMarketplace = itemView.findViewById(R.id.tvItemNamePMarketplace);
            ivImageMp = itemView.findViewById(R.id.ivImageMp);
            etPriceMp = itemView.findViewById(R.id.etPriceMp);
            rlMarketplace = itemView.findViewById(R.id.rlMarketplace);
        }

        // responsible for taking a post and binding it to the view that we have here
        public void bind(PostMarketplace postMarketplace){
            tvItemNamePMarketplace.setText(postMarketplace.getTitle());
            etPriceMp.setText(postMarketplace.getPrice());
            ParseFile image = postMarketplace.getImage();
            if (image != null) {
                Glide.with(contextMarketplace).load(image.getUrl()).into(ivImageMp);
            }
        }
    }
    // Clean all elements of the recycler
    public void clear() {
        postsMarketplace.clear();
        notifyDataSetChanged();
    }
    // Add a list of items -- change to type used
    public void addAll(List<PostMarketplace> list) {
        postsMarketplace.addAll(list);
        notifyDataSetChanged();
    }
}






















