package com.hackathon.hackathon_app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.hackathon.hackathon_app.R;
import com.hackathon.hackathon_app.UI.ChatRoom;
import com.hackathon.hackathon_app.UI.Tags;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class SignInFragment extends Fragment {

    FirebaseAuth mAuth;
    EditText name_edittext,email_edittext,password_edittext,repassword_edittext;
    Button signinbutton;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.sign_in_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();

        name_edittext = view.findViewById(R.id.name_edittext_signin);
        email_edittext = view.findViewById(R.id.email_edittext_signin);
        password_edittext = view.findViewById(R.id.password_edittext_signin);
        repassword_edittext = view.findViewById(R.id.repassword_edittext_signin);
        signinbutton = view.findViewById(R.id.signin_button_signinfrag);

        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_edittext.getText().toString();
                String email = email_edittext.getText().toString();
                String password = password_edittext.getText().toString();
                String repassword = repassword_edittext.getText().toString();

                if (password.matches(repassword)&&!name.matches("")&&!email.matches("")&&!password.matches("")){
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    //intent eklenecek
                                    Intent intent = new Intent(getContext(), Tags.class);
                                    startActivity(intent);
                                    getActivity().finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(getContext(), e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(getContext(), "Alanları ve parolalarınızı kontrol ediniz.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        TextView loginbutton = view.findViewById(R.id.login_button_signinfrag);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment loginFragment= new LoginFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, loginFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });


        super.onViewCreated(view, savedInstanceState);
    }
}
