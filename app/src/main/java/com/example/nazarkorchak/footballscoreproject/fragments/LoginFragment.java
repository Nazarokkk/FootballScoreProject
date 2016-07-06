package com.example.nazarkorchak.footballscoreproject.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nazarkorchak.footballscoreproject.R;
import com.example.nazarkorchak.footballscoreproject.Utils;
import com.example.nazarkorchak.footballscoreproject.activities.RegisterActivity;
import com.example.nazarkorchak.footballscoreproject.interfaces.LoginUserInterface;

/**
 * Created by Mariana on 30.06.2016.
 */
public class LoginFragment extends Fragment {

    private View view;
    private Button loginButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView signUpTextView;

    private LoginUserInterface loginUserInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        loginUserInterface = (LoginUserInterface) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        initUI(view);
        setupListener(view);

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();

                if (!password.isEmpty() && !email.isEmpty()) {
                    loginUserInterface.loginUser(email, password);
                } else {
                    Utils.showErrorSnackBar(getActivity(), view, "Fields aren't correct!");
                }
            }
        });

        return view;
    }

    private void initUI(View view) {
        signUpTextView = (TextView) view.findViewById(R.id.sign_up_text_view);
        loginButton = (Button) view.findViewById(R.id.login_btn);
        emailEditText = (EditText) view.findViewById(R.id.user_name);
        passwordEditText = (EditText) view.findViewById(R.id.user_password);
    }

    public void setupListener(View view) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    clearKeyboardAndFocus();
                    return false;
                }
            });
        }

        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupListener(innerView);
            }
        }
    }

    private void clearKeyboardAndFocus() {
        Utils.hideKeyboard(getActivity());
        emailEditText.clearFocus();
        passwordEditText.clearFocus();
        loginButton.requestFocus();
    }
}
