package com.example.nazarkorchak.footballscoreproject.activities;

import android.support.v4.app.Fragment;

import com.example.nazarkorchak.footballscoreproject.fragments.LoginFragment;


public class LoginActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }
}
