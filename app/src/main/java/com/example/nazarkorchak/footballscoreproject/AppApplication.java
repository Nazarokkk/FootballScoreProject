package com.example.nazarkorchak.footballscoreproject;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Lenovo on 04.07.2016.
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}