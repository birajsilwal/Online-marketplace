package com.example.mylobo.PublicProfile;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("ItemPublicProfileEditor")
public class ItemPublicProfileEditor extends ParseObject {

    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_NAME = "name";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_MAJOR = "major";
    public static final String KEY_BIO = "bio";

    public ParseFile getImageEditor(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImageEditor(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser parseUser){
        put(KEY_USER, parseUser);
    }

    public String getNameEditor(){
        return getString(KEY_NAME);
    }

    public void setNameEditor(String name){
        put(KEY_NAME, name);
    }

    public String getUsernameEditor(){
        return getString(KEY_USERNAME);
    }

    public void setUsernameEditor(String username){
        put(KEY_USERNAME, username);
    }

    public String getEmailEditor(){
        return getString(KEY_EMAIL);
    }

    public void setEmailEditor(String email){
        put(KEY_EMAIL, email);
    }

    public String getMajorEditor(){
        return getString(KEY_MAJOR);
    }

    public void setMajorEditor(String major){
        put(KEY_MAJOR, major);
    }

    public String getBioEditor(){
        return getString(KEY_BIO);
    }

    public void setBioEditor(String bio){
        put(KEY_BIO, bio);
    }

}
