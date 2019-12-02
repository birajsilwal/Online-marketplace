package com.example.mylobo.fragmentsMarketplace;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylobo.Post;
import com.example.mylobo.PostMarketplace;
import com.example.mylobo.PostsAdapterMarketplace;
import com.example.mylobo.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class PostsFragmentMarketplace extends Fragment {

    public static final String TAG = "PFMarketplace";

    private RecyclerView rvPostsMarkerplace;
    private PostsAdapterMarketplace adapterMarketplace;
    private List<PostMarketplace> mPostsMarketplace;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post_marketplace, container, false);
    }

    // 1. created this after adding recycler view in the layout

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvPostsMarkerplace = view.findViewById(R.id.rvPostsMp);

        // 2. create the data source. This will be a list of different post objects. gets from PostMarketplace
        mPostsMarketplace = new ArrayList<>();
        // 3. now create the adapter
        adapterMarketplace = new PostsAdapterMarketplace(getContext(), mPostsMarketplace);
        // 4. set the adapter on the recycler view. This adapter tells the recycler view how to show the content onto the screen
        rvPostsMarkerplace.setAdapter(adapterMarketplace);
        // 5. set the layout manager on the recycler view
        // TODO:look at the linerlayout manager here
        rvPostsMarkerplace.setLayoutManager(new LinearLayoutManager(getContext()));
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
