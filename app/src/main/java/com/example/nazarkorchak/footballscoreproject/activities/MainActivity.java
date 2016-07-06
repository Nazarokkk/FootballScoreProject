package com.example.nazarkorchak.footballscoreproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nazarkorchak.footballscoreproject.utils.Constants;
import com.example.nazarkorchak.footballscoreproject.R;
import com.example.nazarkorchak.footballscoreproject.utils.Utils;
import com.example.nazarkorchak.footballscoreproject.activities.login.LoginActivity;
import com.example.nazarkorchak.footballscoreproject.fragments.drawer.MyMenuFragment;
import com.example.nazarkorchak.footballscoreproject.fragments.ResultsFragment;
import com.mxn.soul.flowingdrawer_core.FlowingView;
import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;

/**
 * Created by nazaryikorchak on 06.07.16.
 */
public class MainActivity extends AppCompatActivity {

    private LeftDrawerLayout mLeftDrawerLayout;

    @Override
    protected void onStart() {
        super.onStart();
        if (!Utils.getBooleanLoginPreference(this, Constants.IS_USER_LOGIN)) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        setupNavigationDrawer();
        setupStartFragment();
    }

    private void setupNavigationDrawer() {
        mLeftDrawerLayout = (LeftDrawerLayout) findViewById(R.id.id_drawer_layout);

        FragmentManager fm = getSupportFragmentManager();
        MyMenuFragment mMenuFragment = (MyMenuFragment) fm.findFragmentById(R.id.id_container_menu);
        FlowingView mFlowingView = (FlowingView) findViewById(R.id.floating_view);
        if (mMenuFragment == null) {
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment = new MyMenuFragment()).commit();
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

    private void setupStartFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_content, new ResultsFragment(), null)
                .disallowAddToBackStack()
                .commit();
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