package com.example.nazarkorchak.footballscoreproject.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.nazarkorchak.footballscoreproject.Constants;
import com.example.nazarkorchak.footballscoreproject.R;
import com.example.nazarkorchak.footballscoreproject.Utils;
import com.example.nazarkorchak.footballscoreproject.fragments.LoginFragment;
import com.example.nazarkorchak.footballscoreproject.interfaces.LoginResponseInterface;
import com.example.nazarkorchak.footballscoreproject.interfaces.LoginUserInterface;
import com.example.nazarkorchak.footballscoreproject.manangers.LoginManager;


public class LoginActivity extends SingleFragmentActivity implements LoginUserInterface, LoginResponseInterface {

    private LoginManager loginManager = new LoginManager(this);

    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }

    @Override
    public void loginUser(String name, String password) {
        loginManager.loginUser(name, password);
    }

    @Override
    public void isSuccess() {
        Utils.saveBooleanLoginPreference(this, Constants.IS_USER_LOGIN, true);
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();

    }

    @Override
    public void isError(String message) {
        Utils.showErrorSnackBar(this, findViewById(R.id.fragmentContainer), message);
    }
}