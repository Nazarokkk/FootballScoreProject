package com.example.nazarkorchak.footballscoreproject.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.nazarkorchak.footballscoreproject.R;
import com.example.nazarkorchak.footballscoreproject.utils.Constants;

/**
 * Created by nazaryikorchak on 04.07.16.
 */
public class Utils {

    public static void showErrorSnackBar(Context context, View view, String text) {
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
        snackbar.show();
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static void saveStringLoginPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.LOGIN_PREF, Context.MODE_PRIVATE).edit();
        editor.putString(key, value).apply();
    }

    public static void saveBooleanLoginPreference(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.LOGIN_PREF, Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value).apply();
    }

    public static boolean getBooleanLoginPreference(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.LOGIN_PREF, Context.MODE_PRIVATE);
        return prefs.getBoolean(key, false);
    }

    public static String getStringLoginPreference(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.LOGIN_PREF, Context.MODE_PRIVATE);
        return prefs.getString(key, "");
    }
}
