package com.example.mylobo.Lobotask.Project;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("ProjectItem")
public class ProjectItem extends ParseObject {


    public static final String KEY_CREATED_AT = "createdAt";
    public static final String KEY_USER = "user";
    public static final String KEY_PROJECT_TODO = "projectTodo";

    public String getProjectTodo(){
        return getString(KEY_PROJECT_TODO);
    }

    public void setProjectTodo(String title){
        put(KEY_PROJECT_TODO, title);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser parseUser){
        put(KEY_USER, parseUser);
    }

}
