package com.example.mylobo.Marketplace;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylobo.R;
import com.example.mylobo.fragmentsMarketplace.ComposeFragmentMarketplace;
import com.example.mylobo.myLobos.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class YourListingsActivity extends AppCompatActivity {

    private Button btnCreateYourListing;
    private ImageView ivBackYourlisting;
    private RecyclerView rvYourlistings;
    private PostsAdapterMarketplaceYourlistings adapterMarketplaceYourlistings;
    private List<PostMarketplace> mPostsMarketplace;


    public static final String TAG = "Yourlistings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_listings);

        btnCreateYourListing = findViewById(R.id.btnCreateYourListing);
        ivBackYourlisting = findViewById(R.id.ivBackYourlisting);

        ivBackYourlisting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YourListingsActivity.this, Marketplace.class);
                startActivity(intent);
            }
        });


        btnCreateYourListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YourListingsActivity.this, ComposeFragmentMarketplace.class);
                startActivity(intent);
            }
        });

//        if (postsMarketplace.size() == 0){
////                tvEmptystateItemMP.setVisibility(View.VISIBLE);
//            tvEmptystateItemMP.setText("Ready to sell?");
//            Log.i("emptystate", String.valueOf(postsMarketplace.size()));
//            return;
//        }


        rvYourlistings = findViewById(R.id.rvYourlistings);
        // 2. create the data source. This will be a list of different post objects. gets from PostMarketplace
        mPostsMarketplace = new ArrayList<>();
        // 3. now create the adapter
        adapterMarketplaceYourlistings = new PostsAdapterMarketplaceYourlistings(this, mPostsMarketplace);
        // 4. set the adapter on the recycler view. This adapter tells the recycler view how to show the content onto the screen
        rvYourlistings.setAdapter(adapterMarketplaceYourlistings);
        // 1. created this after adding recycler view in the layout
        // 5. set the layout manager on the recycler view
        // TODO:look at the linerlayout manager here
        rvYourlistings.setLayoutManager(new LinearLayoutManager(this));
        queryPostMarketplace();
    }

    private void queryPostMarketplace() {
        // querying objects
        ParseQuery<PostMarketplace> postMarketplaceQuery = new ParseQuery<PostMarketplace>(PostMarketplace.class);
        postMarketplaceQuery.include(PostMarketplace.KEY_USER);
        //setting limit of 20 posts
        postMarketplaceQuery.setLimit(20);
        postMarketplaceQuery.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        postMarketplaceQuery.addDescendingOrder(PostMarketplace.KEY_CREATED_AT);
        postMarketplaceQuery.findInBackground(new FindCallback<PostMarketplace>() {
            @Override
            public void done(List<PostMarketplace> postsMarketplace, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Error with query");
                    e.printStackTrace();
                    return;
                }
                mPostsMarketplace.addAll(postsMarketplace);
                adapterMarketplaceYourlistings.notifyDataSetChanged();

                for (int i = 0; i < postsMarketplace.size(); i++ ){
                    PostMarketplace postMarketplace = postsMarketplace.get(i);
                    Log.d(TAG, "PostMarketplace: " + postMarketplace.getTitle() + ", username: " + postMarketplace.getUser().getUsername());
                }
            }
        });
    }
}
