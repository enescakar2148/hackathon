package com.hackathon.hackathon_app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hackathon.hackathon_app.R;
import com.hackathon.hackathon_app.UI.Feed;

import org.jetbrains.annotations.NotNull;

public class LoginFragment extends Fragment {
    EditText email_edittext;
    EditText password_edittext;
    FirebaseAuth mAuth;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.login_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();


        email_edittext = view.findViewById(R.id.login_email_edittext);
        password_edittext = view.findViewById(R.id.login_password_edittext);

        Button login_button = view.findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_edittext.getText().toString();
                String password = password_edittext.getText().toString();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Intent intent = new Intent(getContext(), Feed.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(getContext(), e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        Button signinbutton = view.findViewById(R.id.singin_button_loginfrag);
        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInFragment signInFragment= new SignInFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, signInFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });


        super.onViewCreated(view, savedInstanceState);
    }
}
