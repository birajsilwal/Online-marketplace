package com.example.mylobo.Lobotask.Todo;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Todo")
public class TodoItem extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

}
