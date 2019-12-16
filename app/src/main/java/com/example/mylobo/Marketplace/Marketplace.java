package com.example.mylobo.Marketplace;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.mylobo.R;
import com.example.mylobo.fragmentsMarketplace.ComposeFragmentMarketplace;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Marketplace extends AppCompatActivity {

    private RecyclerView rvPostsMarkerplace;
    private PostsAdapterMarketplace adapterMarketplace;
    private List<PostMarketplace> mPostsMarketplace;

    public static final String TAG = "Marketplace";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
        rvPostsMarkerplace = findViewById(R.id.rvPostsMp);
        // 2. create the data source. This will be a list of different post objects. gets from PostMarketplace
        mPostsMarketplace = new ArrayList<>();
        // 3. now create the adapter
        adapterMarketplace = new PostsAdapterMarketplace(this, mPostsMarketplace);
        // 4. set the adapter on the recycler view. This adapter tells the recycler view how to show the content onto the screen
        rvPostsMarkerplace.setAdapter(adapterMarketplace);
        // 1. created this after adding recycler view in the layout
        // 5. set the layout manager on the recycler view
        // TODO:look at the linerlayout manager here
        rvPostsMarkerplace.setLayoutManager(new LinearLayoutManager(this));
        queryPostMarketplace();
    }

    private void queryPostMarketplace() {
        // querying objects
        ParseQuery<PostMarketplace> postMarketplaceQuery = new ParseQuery<PostMarketplace>(PostMarketplace.class);
        postMarketplaceQuery.include(PostMarketplace.KEY_USER);
        //setting limit of 20 posts
        postMarketplaceQuery.setLimit(20);
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
                adapterMarketplace.notifyDataSetChanged();

                for (int i = 0; i < postsMarketplace.size(); i++ ){
                    PostMarketplace postMarketplace = postsMarketplace.get(i);
                    Log.d(TAG, "PostMarketplace: " + postMarketplace.getTitle() + ", username: " + postMarketplace.getUser().getUsername());
                }
            }
        });
    }
}
