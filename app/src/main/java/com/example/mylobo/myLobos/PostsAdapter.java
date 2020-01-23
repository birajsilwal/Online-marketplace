package com.example.mylobo.myLobos;

import android.content.Context;
import android.util.Log;
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
import com.parse.ParseUser;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder>{

    private Context context;
    private List<Post> posts;
    int myposition;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    // binds the data in given position into the ViewHolder holder
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Post post = posts.get(position);
        holder.bind(post);
        final ParseFile image = post.getImage();

//        holder.rlPost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(context, DetailActivity.class);
//                i.putExtra("image", image);
//                i.putExtra("description", post.getDescription());
//                context.startActivity(i);
//            }
//        });


//        holder.ivMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String objectId = post.getObjectId();
//                post.deleteInBackground();
//            }
//        });



        // Username of each posts
        String isMe = post.getUser().getUsername();
        Log.i("birajpost", isMe);

        String currUser = ParseUser.getCurrentUser().getObjectId();
        ParseUser postId = post.getUser();
        String stringPostId = String.valueOf(postId);

        if (currUser.equals(stringPostId)){
            holder.ivDelete.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

//    class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
      class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvHandle;
        private ImageView ivImage;
        private TextView tvDescription;
//        public RelativeLayout rlPost;
        private ImageView ivDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            tvHandle = itemView.findViewById(R.id.tvHandle);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDescription = itemView.findViewById(R.id.tvDescriptionTitle);
//            rlPost = itemView.findViewById(R.id.rlPost);
//            ivDelete = itemView.findViewById(R.id.ivDelete);
        }

        public void bind(Post post){
        // TODO: bind the view elements to the post
            tvHandle.setText(post.getUser().getUsername());
            ParseFile image = post.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }
            tvDescription.setText(post.getDescription());
        }
    }

    /* Within the RecyclerView.Adapter class */
    // Clean all elements of the recycler
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }
    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }
}


