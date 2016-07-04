package com.example.nazarkorchak.footballscoreproject.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.nazarkorchak.footballscoreproject.fragments.RegisterFragment;
import com.example.nazarkorchak.footballscoreproject.interfaces.CreateUserInterface;
import com.example.nazarkorchak.footballscoreproject.manangers.LoginManager;

/**
 * Created by Mariana on 01.07.2016.
 */
public class RegisterActivity extends SingleFragmentActivity implements CreateUserInterface {

    private LoginManager loginManager = new LoginManager(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        return new RegisterFragment();
    }

    @Override
    public void createUser(String name, String password, final View view) {
        loginManager.createUser(name, password, view);
    }
}
