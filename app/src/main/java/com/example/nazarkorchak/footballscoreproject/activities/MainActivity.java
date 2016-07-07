package com.example.nazarkorchak.footballscoreproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.nazarkorchak.footballscoreproject.R;
import com.example.nazarkorchak.footballscoreproject.activities.login.LoginActivity;
import com.example.nazarkorchak.footballscoreproject.fragments.AccountFragment;
import com.example.nazarkorchak.footballscoreproject.fragments.BookmakersFragment;
import com.example.nazarkorchak.footballscoreproject.fragments.ResultsFragment;
import com.example.nazarkorchak.footballscoreproject.fragments.drawer.MyMenuFragment;
import com.example.nazarkorchak.footballscoreproject.interfaces.DrawerItemClickInterface;
import com.example.nazarkorchak.footballscoreproject.utils.Constants;
import com.example.nazarkorchak.footballscoreproject.utils.Utils;
import com.mxn.soul.flowingdrawer_core.FlowingView;
import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;

/**
 * Created by nazaryikorchak on 06.07.16.
 */
public class MainActivity extends AppCompatActivity implements DrawerItemClickInterface {

    private LeftDrawerLayout mLeftDrawerLayout;

    @Override
    protected void onStart() {
        super.onStart();
        if (!Utils.getBooleanLoginPreference(this, Constants.IS_USER_LOGIN)) {
            startLoginScreen();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        setupNavigationDrawer();
        startFragment(new ResultsFragment());
    }

    private void setupNavigationDrawer() {
        mLeftDrawerLayout = (LeftDrawerLayout) findViewById(R.id.id_drawer_layout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MyMenuFragment mMenuFragment = (MyMenuFragment) fragmentManager.findFragmentById(R.id.id_container_menu);
        FlowingView mFlowingView = (FlowingView) findViewById(R.id.floating_view);
        if (mMenuFragment == null) {
            fragmentManager.beginTransaction().add(R.id.id_container_menu, mMenuFragment = new MyMenuFragment()).commit();
        }
        mLeftDrawerLayout.setFluidView(mFlowingView);
        mLeftDrawerLayout.setMenuFragment(mMenuFragment);
    }

    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeftDrawerLayout.toggle();
            }
        });
    }

    @Override
    public void onResultsClick() {
        mLeftDrawerLayout.closeDrawer();
        startFragment(new ResultsFragment());
        Log.e("menu", "onResultsClick");
    }

    @Override
    public void onAccountClick() {
        mLeftDrawerLayout.closeDrawer();
        startFragment(new AccountFragment());
        Log.e("menu", "onAccountClick");
    }

    @Override
    public void onBookmakersClick() {
        mLeftDrawerLayout.closeDrawer();
        startFragment(new BookmakersFragment());
        Log.e("menu", "onBookmakersClick");
    }

    @Override
    public void onLogoutClick() {
        mLeftDrawerLayout.closeDrawer();
        Utils.saveBooleanLoginPreference(this, Constants.IS_USER_LOGIN, false);
        startLoginScreen();
        Log.e("menu", "onLogoutClick");
    }

    private void startFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_content, fragment, null)
                .disallowAddToBackStack()
                .commit();
    }

    private void startLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (mLeftDrawerLayout.isShownMenu()) {
            mLeftDrawerLayout.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}