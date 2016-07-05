package com.example.nazarkorchak.footballscoreproject.manangers;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.nazarkorchak.footballscoreproject.interfaces.LoginResponseInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Lenovo on 04.07.2016.
 */
public class LoginManager {

    private FirebaseAuth mAuth;
    private Context context;
    private LoginResponseInterface loginResponseInterface;

    public LoginManager(Context context) {
        mAuth = FirebaseAuth.getInstance();
        this.context = context;
        loginResponseInterface = (LoginResponseInterface) context;
    }

    public void createUser(String login, String password) {
        mAuth.createUserWithEmailAndPassword(login, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        checkCorrectFirebaseResponse(task);
                    }
                });
    }

    public void loginUser(String login, String password) {
        mAuth.signInWithEmailAndPassword(login, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        checkCorrectFirebaseResponse(task);
                    }
                });
    }

    private void checkCorrectFirebaseResponse(Task<AuthResult> response) {
        if (response.isSuccessful()) {
            loginResponseInterface.isSuccess();
        } else {
            loginResponseInterface.isError(response.getException().getMessage().toString());
        }
    }
}
