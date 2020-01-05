package com.example.mylobo.PublicProfile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PublicProfileEditorActivity extends AppCompatActivity {

    public static final String TAG = "PubilcProfileEditor";

    private RecyclerView rvItemPublicProfileEditor;
    private ItemsAdapterPublicProfileEditor itemsAdapterPublicProfileEditor;
    private List<ItemPublicProfileEditor> itemPublicProfileEditorList;

    private EditText etNameEditor;
    private EditText etUsernameEditor;
    private EditText etEmailEditor;
    private EditText etMajorEditor;
    private EditText etBioEditor;
    private ImageView ivTickPPEditor;
    private ImageView ivProfileImage;
    private TextView tvChangePP;

    public final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034;
    public String photoFileName = "photo.jpg";
    File photoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_profile_editor);

        etNameEditor = findViewById(R.id.etNameEditor);
        etUsernameEditor = findViewById(R.id.etUsernameEditor);
        etEmailEditor = findViewById(R.id.etEmailEditor);
        etMajorEditor = findViewById(R.id.etMajorEditor);
        etBioEditor = findViewById(R.id.etBioEditor);
        ivTickPPEditor = findViewById(R.id.ivTickPPEditor);
        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvChangePP = findViewById(R.id.tvChangePP);
        rvItemPublicProfileEditor = findViewById(R.id.rvItemPublicProfileEditor);




//        tvChangePP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                launchCamera();
//            }
//        });

        ivTickPPEditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEditor =  etNameEditor.getText().toString();
                String userNameEditor =  etUsernameEditor.getText().toString();
                String emailEditor =  etEmailEditor.getText().toString();
                String majorEditor =  etMajorEditor.getText().toString();
                String bioEditor =  etBioEditor.getText().toString();
                ParseUser user = ParseUser.getCurrentUser();
                if (photoFile == null || ivProfileImage.getDrawable() == null) {
                    // if there is no photo taken, post will no be submit
                    Log.e(TAG, "No photo to submit");
                    Toast.makeText(PublicProfileEditorActivity.this, "There is no photo", Toast.LENGTH_SHORT).show();
                    return;
                }
                savePost(nameEditor, userNameEditor, emailEditor, majorEditor, bioEditor, user, photoFile);
            }
        });

        itemPublicProfileEditorList = new ArrayList<>();
        itemsAdapterPublicProfileEditor = new ItemsAdapterPublicProfileEditor(this, itemPublicProfileEditorList);
        rvItemPublicProfileEditor.setAdapter(itemsAdapterPublicProfileEditor);
        rvItemPublicProfileEditor.setLayoutManager(new LinearLayoutManager(this));
        rvItemPublicProfileEditor.setNestedScrollingEnabled(false);

        queryItemPublicProfileEditer();

    }

    private void queryItemPublicProfileEditer() {
        //querying objects
        ParseQuery<ItemPublicProfileEditor> itemPublicProfileEditorParseQuery = new ParseQuery<>(ItemPublicProfileEditor.class);
        itemPublicProfileEditorParseQuery.include(ItemPublicProfileEditor.KEY_USER);
        //setting limit to 20 items, maybe its unnecessary
        itemPublicProfileEditorParseQuery.setLimit(20);
        itemPublicProfileEditorParseQuery.findInBackground(new FindCallback<ItemPublicProfileEditor>() {
            @Override
            public void done(List<ItemPublicProfileEditor> itemPublicProfileEditors, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Error with query");
                    e.printStackTrace();
                    return;
                }
                itemPublicProfileEditorList.addAll(itemPublicProfileEditors);
                itemsAdapterPublicProfileEditor.notifyDataSetChanged();
            }
        });

    }

    public void launchCamera() {
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Create a File reference to access to future access
        photoFile = getPhotoFileUri(photoFileName);

        // wrap File object into a content provider
        // required for API >= 24
        Uri fileProvider = FileProvider.getUriForFile(PublicProfileEditorActivity.this, "com.codepath.fileprovider", photoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);

        // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
        // So as long as the result is not null, it's safe to use the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Start the image capture intent to take photo
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
    }

    // see comments in composefragmentmarketplace
    private File getPhotoFileUri(String photoFileName) {
        File mediaStorageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), TAG);
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
            Log.d(TAG, "failed to create directory");
        }
        File file = new File(mediaStorageDir.getPath() + File.separator + photoFileName);

        return file;    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // by this point we have the camera photo on disk
                Bitmap takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
                // RESIZE BITMAP, see section below
                // Load the taken image into a preview
                ivProfileImage.setImageBitmap(takenImage);
            } else { // Result was a failure
                Toast.makeText(this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void savePost(String nameEditor, String userNameEditor, String emailEditor, String majorEditor, String bioEditor, ParseUser parseUser, File photoFile) {
        ItemPublicProfileEditor itemPublicProfileEditor = new ItemPublicProfileEditor();
        itemPublicProfileEditor.setNameEditor(nameEditor);
        itemPublicProfileEditor.setUsernameEditor(userNameEditor);
        itemPublicProfileEditor.setEmailEditor(emailEditor);
        itemPublicProfileEditor.setMajorEditor(majorEditor);
        itemPublicProfileEditor.setBioEditor(bioEditor);
        itemPublicProfileEditor.setUser(parseUser);
        itemPublicProfileEditor.setImageEditor(new ParseFile(photoFile));
        itemPublicProfileEditor.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Log.d(TAG, "Error while saving");
                    e.printStackTrace();
                    return;
                }
                Log.d(TAG, "Success");
//                Intent i = new Intent(PublicProfileEditorActivity.this, HomeScreen.class);
//                startActivity(i);
            }
        });
    }

    public void previous(View view){
        Intent i = new Intent(PublicProfileEditorActivity.this, HomeScreen.class);
        startActivity(i);
    }
}
