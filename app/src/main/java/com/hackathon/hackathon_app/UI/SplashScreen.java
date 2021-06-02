package com.hackathon.hackathon_app.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hackathon.hackathon_app.Auth;
import com.hackathon.hackathon_app.R;

public class SplashScreen extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();

        Splash splash = new Splash();
        splash.start();
    }

    class Splash extends Thread {
        public void run() {
            try {
                sleep(3000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }


            FirebaseUser currentUser = mAuth.getCurrentUser();
            if(currentUser != null){
                Intent intent = new Intent(getApplicationContext(), Feed.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }else{
                Intent intent = new Intent(SplashScreen.this, Auth.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }


        }

        public void start() {
            run();
        }
    }
}