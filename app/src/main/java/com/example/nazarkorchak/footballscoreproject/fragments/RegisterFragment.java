package com.example.nazarkorchak.footballscoreproject.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nazarkorchak.footballscoreproject.interfaces.CreateUserInterface;
import com.example.nazarkorchak.footballscoreproject.R;

/**
 * Created by Mariana on 01.07.2016.
 */
public class RegisterFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initUI(view);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();

                // LoginManager loginManager = new LoginManager(getActivity());

                if (!password.isEmpty() && !email.isEmpty() && confirmPasswordEditText.getText().toString().equals(password)) {
                    createUserInterface.createUser(email, password);
                    // loginManager.createUser(email, password);
                }
            }
        });

        return view;
    }

    private void initUI(View view) {
        signUpButton = (Button) view.findViewById(R.id.sign_up_btn);
        emailEditText = (EditText) view.findViewById(R.id.user_name);
        passwordEditText = (EditText) view.findViewById(R.id.user_password);
        confirmPasswordEditText = (EditText) view.findViewById(R.id.user_password_confirm);
    }
}
