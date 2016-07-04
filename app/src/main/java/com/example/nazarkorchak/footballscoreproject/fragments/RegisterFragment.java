package com.example.nazarkorchak.footballscoreproject.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nazarkorchak.footballscoreproject.R;
import com.example.nazarkorchak.footballscoreproject.Utils;
import com.example.nazarkorchak.footballscoreproject.interfaces.CreateUserInterface;

/**
 * Created by Mariana on 01.07.2016.
 */
public class RegisterFragment extends Fragment {

    private View view;
    private Button signUpButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;

    private CreateUserInterface createUserInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        createUserInterface = (CreateUserInterface) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        setupListener(view);
        initUI(view);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();

                if (!password.isEmpty() && !email.isEmpty() &&
                        confirmPasswordEditText.getText().toString().equals(password)) {
                    createUserInterface.createUser(email, password, view);
                } else {
                    Utils.showErrorSnackBar(getActivity(), view, "Fields aren't correct!");
                }
            }
        });

        return view;
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
        confirmPasswordEditText.clearFocus();
        signUpButton.requestFocus();
    }

    private void initUI(View view) {
        signUpButton = (Button) view.findViewById(R.id.sign_up_btn);
        emailEditText = (EditText) view.findViewById(R.id.user_name);
        passwordEditText = (EditText) view.findViewById(R.id.user_password);
        confirmPasswordEditText = (EditText) view.findViewById(R.id.user_password_confirm);
    }
}