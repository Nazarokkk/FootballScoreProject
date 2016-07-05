package com.example.nazarkorchak.footballscoreproject.manangers;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

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

    public LoginManager(Context context) {
        mAuth = FirebaseAuth.getInstance();
        this.context = context;
    }

    public void createUser(String login, String password){
        mAuth.createUserWithEmailAndPassword(login, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        Log.d("creating new user", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            Log.d("creating new user", task.getException().getMessage().toString());
                        }

                    }
                });

    }
}
