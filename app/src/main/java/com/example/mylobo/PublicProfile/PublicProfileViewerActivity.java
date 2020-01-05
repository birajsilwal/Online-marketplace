package com.example.mylobo.PublicProfile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;

public class PublicProfileViewerActivity extends AppCompatActivity {

    public static final String TAG = "PUblicProfileViewer";

//    private RecyclerView rvItemPublicProfile;
//    private ItemsAdapterPublicProfileEditor itemsAdapterPublicProfileEditor;
//    private List<ItemPublicProfileEditor> itemPublicProfileEditorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_profile_viewer);

//        rvItemPublicProfile = findViewById(R.id.rvItemPublicProfileViewer);
//        itemPublicProfileEditorList = new ArrayList<>();
//        itemsAdapterPublicProfileEditor = new ItemsAdapterPublicProfileEditor(this, itemPublicProfileEditorList);
//        rvItemPublicProfile.setAdapter(itemsAdapterPublicProfileEditor);
//        rvItemPublicProfile.setLayoutManager(new LinearLayoutManager(this));
//        rvItemPublicProfile.setNestedScrollingEnabled(false);

//        queryItemPublicProfileEditer();
    }

//    private void queryItemPublicProfileEditer() {
//        //querying objects
//        ParseQuery<ItemPublicProfileEditor> itemPublicProfileEditorParseQuery = new ParseQuery<>(ItemPublicProfileEditor.class);
//        itemPublicProfileEditorParseQuery.include(ItemPublicProfileEditor.KEY_USER);
//        //setting limit to 20 items, maybe its unnecessary
//        itemPublicProfileEditorParseQuery.setLimit(20);
//        itemPublicProfileEditorParseQuery.findInBackground(new FindCallback<ItemPublicProfileEditor>() {
//            @Override
//            public void done(List<ItemPublicProfileEditor> itemPublicProfileEditors, ParseException e) {
//                if (e != null) {
//                    Log.e(TAG, "Error with query");
//                    e.printStackTrace();
//                    return;
//                }
//                itemPublicProfileEditorList.addAll(itemPublicProfileEditors);
//                itemsAdapterPublicProfileEditor.notifyDataSetChanged();
//            }
//        });
//
//    }

    public void previous(View view){
        Intent i = new Intent(PublicProfileViewerActivity.this, HomeScreen.class);
        startActivity(i);
    }
}
