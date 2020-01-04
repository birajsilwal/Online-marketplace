package com.example.mylobo;

import android.app.Application;

import com.example.mylobo.Lobochat.Message;
import com.example.mylobo.Lobotask.Project.ProjectItem;
import com.example.mylobo.Lobotask.Todo.TodoItem;
import com.example.mylobo.Marketplace.PostMarketplace;
import com.example.mylobo.PublicProfile.ItemPublicProfileEditor;
import com.example.mylobo.myLobos.Post;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        ParseObject.registerSubclass(PostMarketplace.class);
        ParseObject.registerSubclass(Message.class);
        ParseObject.registerSubclass(TodoItem.class);
        ParseObject.registerSubclass(ProjectItem.class);
        ParseObject.registerSubclass(ItemPublicProfileEditor.class);


        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("biraj-insta") // should correspond to APP_ID env variable
                .clientKey("birajsilwal")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://biraj-insta.herokuapp.com/parse").build());
    }
}
