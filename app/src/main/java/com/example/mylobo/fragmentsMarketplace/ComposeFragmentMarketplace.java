package com.example.mylobo.fragmentsMarketplace;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.mylobo.Marketplace.Marketplace;
import com.example.mylobo.Marketplace.PostMarketplace;
import com.example.mylobo.MenuActivity.MenuActivityMarketplace;
import com.example.mylobo.R;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;

public class ComposeFragmentMarketplace extends AppCompatActivity {

    public static final String TAG = "CFMarketplace";

    private EditText etTitle;
    private EditText etPrice;
    private ImageView ivCameraMp;
    private ImageView ivPostImageMp;
    private Button btnSubmitMp;
    ImageView ivBackCompose;
    private EditText etDescriptionMp;


    public final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034;
    public String photoFileName = "photo.jpg";
    File photoFile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_compose_marketplace);

        etTitle = findViewById(R.id.etTitleMp);
        etPrice = findViewById(R.id.etPriceMp);
        ivCameraMp = findViewById(R.id.ivCameraMp);
        ivPostImageMp = findViewById(R.id.ivPostImageMp);
        btnSubmitMp = findViewById(R.id.btnSubmitMp);
        ivBackCompose = findViewById(R.id.ivBackCompose);
        etDescriptionMp = findViewById(R.id.etDescriptionMp);

        ivCameraMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchCamera();
            }
        });

        btnSubmitMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title =  etTitle.getText().toString();
                String price = etPrice.getText().toString();
                String description = etDescriptionMp.getText().toString();
                ParseUser user = ParseUser.getCurrentUser();
                if (photoFile == null || ivPostImageMp.getDrawable() == null) {
                    // if there is no photo taken, post will no be submit
                    Log.e(TAG, "No photo to submit");
                    Toast.makeText(ComposeFragmentMarketplace.this, "There is no photo", Toast.LENGTH_SHORT).show();
                    return;
                }
                savePost(title, price, description, user, photoFile);
            }
        });

        ivBackCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ComposeFragmentMarketplace.this, MenuActivityMarketplace.class);
                startActivity(i);
//                finish();
            }
        });
    }

    private void launchCamera() {
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Create a File reference to access to future access
        photoFile = getPhotoFileUri(photoFileName);

        // wrap File object into a content provider
        // required for API >= 24
        Uri fileProvider = FileProvider.getUriForFile(ComposeFragmentMarketplace.this, "com.codepath.fileprovider", photoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);

        // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
        // So as long as the result is not null, it's safe to use the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Start the image capture intent to take photo
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
    }

    //    When the camera app finishes, the onActivityResult() method will be called:
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // by this point we have the camera photo on disk
                Bitmap takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
                // RESIZE BITMAP, see section below
                // Load the taken image into a preview
                ivPostImageMp.setImageBitmap(takenImage);
            } else { // Result was a failure
                Toast.makeText(this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    // Returns the File for a photo stored on disk given the fileName
    public File getPhotoFileUri(String fileName) {
        // Get safe storage directory for photos
        // Use `getExternalFilesDir` on Context to access package-specific directories.
        // This way, we don't need to request external read/write runtime permissions.
        File mediaStorageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), TAG);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
            Log.d(TAG, "failed to create directory");
        }

        // Return the file target for the photo based on filename
        File file = new File(mediaStorageDir.getPath() + File.separator + fileName);

        return file;
    }


    private void savePost(String title, String price, String description, ParseUser parseUser, File photoFile) {
        PostMarketplace postMarketplace = new PostMarketplace();
        postMarketplace.setTitle(title);
        postMarketplace.setPrice(price);
        postMarketplace.setDescription(description);
        postMarketplace.setUser(parseUser);
        postMarketplace.setImage(new ParseFile(photoFile));
        postMarketplace.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Log.d(TAG, "Error while saving");
                    e.printStackTrace();
                    return;
                }
                Log.d(TAG, "Success");
                etTitle.setText("");
                ivPostImageMp.setImageResource(0);
                etPrice.setText("");
                Intent i = new Intent(ComposeFragmentMarketplace.this, Marketplace.class);
                startActivity(i);
            }
        });
    }
}

