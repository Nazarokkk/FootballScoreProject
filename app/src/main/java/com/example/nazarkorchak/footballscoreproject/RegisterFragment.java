package com.example.nazarkorchak.footballscoreproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Mariana on 01.07.2016.
 */
public class RegisterFragment extends Fragment {

//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//    protected Firebase ref = new Firebase("https://football-highlights-b0c0c.firebaseio.com");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);

//        Firebase.setAndroidContext(getActivity());
//        mAuth = FirebaseAuth.getInstance();
//
//        mAuth.createUserWithEmailAndPassword("mkhodachnyk@gmail.com", "4009")
//                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(Task<AuthResult> task) {
//                        Log.d("creating new user", "createUserWithEmail:onComplete:" + task.isSuccessful());
//
//                        if (!task.isSuccessful()) {
//                            Log.d("creating new user", "some error(");
//                        }
//
//                    }
//                });

        return v;

    }

}
