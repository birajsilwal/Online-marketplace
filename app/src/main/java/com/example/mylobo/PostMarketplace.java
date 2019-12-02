package com.example.mylobo;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("PostMarketplace")
public class PostMarketplace extends ParseObject {

    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED_AT = "createdAt";
    public static final String KEY_PRICE = "price";

    public String getTitle(){
        return getString(KEY_TITLE);
    }

    public void setTitle(String title){
        put(KEY_TITLE, title);
    }

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser parseUser){
        put(KEY_USER, parseUser);
    }

    public String getPrice() { return getString(KEY_PRICE);}

    public void setPrice(String price) { put(KEY_PRICE, price);}
}

// register this class with parse before we call Parse.initialize
// register into ParseApplication