package com.example.nazarkorchak.footballscoreproject.activities.login;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.nazarkorchak.footballscoreproject.utils.Constants;
import com.example.nazarkorchak.footballscoreproject.R;
import com.example.nazarkorchak.footballscoreproject.utils.Utils;
import com.example.nazarkorchak.footballscoreproject.activities.MainActivity;
import com.example.nazarkorchak.footballscoreproject.fragments.login.RegisterFragment;
import com.example.nazarkorchak.footballscoreproject.interfaces.CreateUserInterface;
import com.example.nazarkorchak.footballscoreproject.interfaces.LoginResponseInterface;
import com.example.nazarkorchak.footballscoreproject.manangers.LoginManager;

/**
 * Created by Mariana on 01.07.2016.
 */
public class RegisterActivity extends SingleFragmentActivity implements CreateUserInterface, LoginResponseInterface {

    private LoginManager loginManager = new LoginManager(this);

    @Override
    protected Fragment createFragment() {
        return new RegisterFragment();
    }

    @Override
    public void createUser(String name, String password) {
        loginManager.createUser(name, password);
    }

    @Override
    public void isSuccess() {
        Utils.saveBooleanLoginPreference(this, Constants.IS_USER_LOGIN, true);
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void isError(String message) {
        Utils.showErrorSnackBar(this, findViewById(R.id.fragmentContainer), message);
    }
}
