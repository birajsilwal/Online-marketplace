package com.example.mylobo.PublicProfile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class PublicProfileViewerActivity extends AppCompatActivity {

    public static final String TAG = "PUblicProfileViewer";

    private TextView tvNameViewer;
    private TextView tvUsenameViewer;
    private TextView tvMajorViewer;
    private TextView tvBioViewer;
    private ImageView ivBackMenuPPViewer;

    ItemPublicProfileEditor itemPublicProfileEditor;

    String name, username, major, bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_profile_viewer);

        tvNameViewer = findViewById(R.id.tvNameViewer);
        tvUsenameViewer = findViewById(R.id.tvUsenameViewer);
        tvMajorViewer = findViewById(R.id.tvMajorViewer);
        tvBioViewer = findViewById(R.id.tvBioViewer);
        ivBackMenuPPViewer = findViewById(R.id.ivBackMenuPPViewer);

        ivBackMenuPPViewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PublicProfileViewerActivity.this, HomeScreen.class);
                startActivity(i);
            }
        });

        String oi = ParseUser.getCurrentUser().getObjectId();

        itemPublicProfileEditor.getBioEditor();

        ParseQuery<ItemPublicProfileEditor> itemPublicProfileEditorParseQuery = ParseQuery.getQuery(ItemPublicProfileEditor.class);
        itemPublicProfileEditorParseQuery.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK);
        itemPublicProfileEditorParseQuery.getInBackground(oi, new GetCallback<ItemPublicProfileEditor>() {
            @Override
            public void done(ItemPublicProfileEditor object, ParseException e) {
                if (e == null) {
                    Log.i(TAG, "Item Found");
                    bio = object.getBioEditor();
                    tvBioViewer.setText(bio);
                }
                else{
                    Log.i(TAG, "Item not Found");
                }
            }
        });




        name = getIntent().getStringExtra("profileName");

        tvNameViewer.setText(name);
        tvUsenameViewer.setText(name);

    }
}
