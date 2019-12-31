package com.example.mylobo.Marketplace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mylobo.R;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapterMarketplaceYourlistings extends RecyclerView.Adapter<PostsAdapterMarketplaceYourlistings.ViewHolder> {

    private Context contextMarketplaceYourlistings;
    private List<PostMarketplace> postsMarketplace;

    public PostsAdapterMarketplaceYourlistings(Context contextMarketplaceYourlistings, List<PostMarketplace> postsMarketplace) {
        this.contextMarketplaceYourlistings = contextMarketplaceYourlistings;
        this.postsMarketplace = postsMarketplace;
    }

    @NonNull
    @Override
    public PostsAdapterMarketplaceYourlistings.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextMarketplaceYourlistings).inflate(R.layout.item_post_marketplace_yourlisting, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapterMarketplaceYourlistings.ViewHolder holder, int position) {
        final PostMarketplace postMarketplace = postsMarketplace.get(position);
        holder.bind(postMarketplace);
    }

    @Override
    public int getItemCount() {
        return postsMarketplace.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitleMpYourlistings;
        private ImageView ivImageMpYourlistings;
        private TextView etPriceMpYourlistings;

        // pull out a reference to each of the items in our item posts mp
        public ViewHolder(View itemView) {
            super(itemView);

            tvTitleMpYourlistings = itemView.findViewById(R.id.tvTitleMpYourlistings);
            ivImageMpYourlistings = itemView.findViewById(R.id.ivImageMpYourlistings);
            etPriceMpYourlistings = itemView.findViewById(R.id.etPriceMpYourlistings);
        }

        // responsible for taking a post and binding it to the view that we have here
        public void bind(PostMarketplace postMarketplace){
            tvTitleMpYourlistings.setText(postMarketplace.getTitle());
            etPriceMpYourlistings.setText(postMarketplace.getPrice());
            ParseFile image = postMarketplace.getImage();
            if (image != null) {
                Glide.with(contextMarketplaceYourlistings).load(image.getUrl()).into(ivImageMpYourlistings);
            }
        }
    }
}
