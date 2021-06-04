package com.hackathon.hackathon_app.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.hackathon.hackathon_app.Auth;
import com.hackathon.hackathon_app.Fragment.AboutUsFragment;
import com.hackathon.hackathon_app.Fragment.ListMentorFragment;
import com.hackathon.hackathon_app.Fragment.SssFragment;
import com.hackathon.hackathon_app.R;

public class ListMentors extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mentors);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        Fragment listMentorFragment = new ListMentorFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.listMentorContainer, listMentorFragment).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.editTag:
                 Intent intent = new Intent(ListMentors.this, Tags.class);
                startActivity(intent);
                break;
            case R.id.logout:
                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.signOut();
                Toast.makeText(this, "Çıkış Yapıldı...", Toast.LENGTH_SHORT).show();
                Intent logOut = new Intent(ListMentors.this, Auth.class);
                startActivity(logOut);
                finish();
                break;
        }
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.sss_button:
                    selectedFragment = new SssFragment(ListMentors.this);
                    break;
                case R.id.home:
                    selectedFragment = new ListMentorFragment(ListMentors.this);
                    break;
                case R.id.aboutusbutton:
                    selectedFragment = new AboutUsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.listMentorContainer, selectedFragment).commit();
            return true;
        }
    };
}