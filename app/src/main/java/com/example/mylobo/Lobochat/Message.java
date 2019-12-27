package com.example.mylobo.Lobochat;

import com.parse.ParseClassName;
import com.parse.ParseObject;

// Model class which will provide message data for the RecyclerView and will be used to retrieve and save message to Parse
@ParseClassName("Message")
public class Message extends ParseObject {
    public static final String USER_ID_KEY = "userId";
    public static final String BODY_KEY = "body";

    public String getUserId() {
        return getString(USER_ID_KEY);
    }

    public String getBody() {
        return getString(BODY_KEY);
    }

    public void setUserId(String userId) {
        put(USER_ID_KEY, userId);
    }

    public void setBody(String body) {
        put(BODY_KEY, body);
    }
}

//use this to get userid
//ParseUser.getCurrentUser().getObjectId()