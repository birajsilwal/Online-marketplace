package com.example.mylobo.Lobotask.Project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylobo.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class ProjectSnake extends AppCompatActivity {

    public static final String TAG = "ProjectSnake";

    Button btnAddProjectItem;
    EditText etItemProjectSnake;
    ImageView ivBackProjectSnake;

    private RecyclerView rvProjectItem;
    private ProjectItemsAdapter projectItemsAdapter;
    private List<ProjectItem> ProjectItems;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_snake);

        btnAddProjectItem = findViewById(R.id.btnAddProjectItem);
        etItemProjectSnake = findViewById(R.id.etItemProjectSnake);
        rvProjectItem = findViewById(R.id.rvProjectItem);
        ivBackProjectSnake = findViewById(R.id.ivBackProjectSnake);

        ivBackProjectSnake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectSnake.this, Project.class);
                startActivity(intent);
            }
        });

        ProjectItems = new ArrayList<>();
        projectItemsAdapter = new ProjectItemsAdapter(this, ProjectItems);
        rvProjectItem.setAdapter(projectItemsAdapter);
        rvProjectItem.setLayoutManager(new LinearLayoutManager(this));
        queryProjectItem();

        btnAddProjectItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String projectTodo = etItemProjectSnake.getText().toString();
                ParseUser user = ParseUser.getCurrentUser();
                savePost(projectTodo, user);
                Intent intent = new Intent(ProjectSnake.this ,ProjectSnake.class);
                startActivity(intent);
            }
        });
    }

    private void queryProjectItem() {
        final ParseQuery<ProjectItem> projectItemParseQuery = new ParseQuery<>(ProjectItem.class);
        projectItemParseQuery.addDescendingOrder(ProjectItem.KEY_CREATED_AT);
        projectItemParseQuery.findInBackground(new FindCallback<ProjectItem>() {
            @Override
            public void done(List<ProjectItem> projectItems, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Error with query");
                    e.printStackTrace();
                    return;
                }
                ProjectItems.addAll(projectItems);
                projectItemsAdapter.notifyDataSetChanged();
            }
        });

    }

    private void savePost(String projectTodo, ParseUser parseUser) {
        ProjectItem projectItem = new ProjectItem();
        projectItem.setProjectTodo(projectTodo);
        projectItem.setUser(parseUser);
        projectItem.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Log.d(TAG, "Error while saving");
                    e.printStackTrace();
                    return;
                }
                Log.d(TAG, "Success");
                etItemProjectSnake.setText("");
            }
        });
    }
}
