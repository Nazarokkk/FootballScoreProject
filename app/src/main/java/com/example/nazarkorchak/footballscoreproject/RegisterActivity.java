package com.example.nazarkorchak.footballscoreproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Mariana on 01.07.2016.
 */
public class RegisterActivity extends SingleFragmentActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword("mkhodachnyk@gmail.com", "445513086")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        Log.d("creating new user", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            Log.d("creating new user", task.getException().getMessage().toString());
                        }

                    }
                });

    }

    @Override
    protected Fragment createFragment() {
        return new RegisterFragment();
    }
}
