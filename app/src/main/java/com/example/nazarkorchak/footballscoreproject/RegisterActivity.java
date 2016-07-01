package com.example.nazarkorchak.footballscoreproject;

import android.support.v4.app.Fragment;

/**
 * Created by Mariana on 01.07.2016.
 */
public class RegisterActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new RegisterFragment();
    }
}
