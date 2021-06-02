package com.hackathon.hackathon_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.hackathon.hackathon_app.Fragment.LoginFragment;
import com.hackathon.hackathon_app.Fragment.SignInFragment;

public class Auth extends AppCompatActivity {

LoginFragment loginFragment = new LoginFragment();
SignInFragment signInFragment = new SignInFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment(loginFragment);
        System.out.println("Yüklendi");
    }


    public void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.container, fragment).commit();
    }

















}
