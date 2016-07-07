package com.example.nazarkorchak.footballscoreproject.fragments.drawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nazarkorchak.footballscoreproject.R;
import com.example.nazarkorchak.footballscoreproject.interfaces.DrawerItemClickInterface;
import com.mxn.soul.flowingdrawer_core.MenuFragment;

/**
 * Created by nazaryikorchak on 06.07.16.
 */
public class MyMenuFragment extends MenuFragment {

    private ImageView ivMenuUserProfilePhoto;
    private DrawerItemClickInterface drawerItemClickInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        drawerItemClickInterface = (DrawerItemClickInterface) activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        NavigationView vNavigation = (NavigationView) view.findViewById(R.id.vNavigation);
        vNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.menu_results:
                        drawerItemClickInterface.onResultsClick();
                        return true;
                    case R.id.menu_account:
                        drawerItemClickInterface.onAccountClick();
                        return true;
                    case R.id.menu_bookmakers:
                        drawerItemClickInterface.onBookmakersClick();
                        return true;
                    case R.id.menu_logout:
                        drawerItemClickInterface.onLogoutClick();
                        return true;
                    default:
                        return false;
                }
            }
        });
        // ivMenuUserProfilePhoto = (ImageView) view.findViewById(R.id.ivMenuUserProfilePhoto);
        // setupHeader();
        return setupReveal(view);
    }

    private void setupHeader() {
//        int avatarSize = getResources().getDimensionPixelSize(R.dimen.global_menu_avatar_size);
//        String profilePhoto = getResources().getString(R.string.user_profile_photo);
//        Picasso.with(getActivity())
//                .load(profilePhoto)
//                .placeholder(R.drawable.img_circle_placeholder)
//                .resize(avatarSize, avatarSize)
//                .centerCrop()
//                .transform(new CircleTransformation())
//                .into(ivMenuUserProfilePhoto);
    }

    public void onOpenMenu() {
//        Toast.makeText(getActivity(), "onOpenMenu", Toast.LENGTH_SHORT).show();
    }

    public void onCloseMenu() {
//        Toast.makeText(getActivity(), "onCloseMenu", Toast.LENGTH_SHORT).show();
    }
}
