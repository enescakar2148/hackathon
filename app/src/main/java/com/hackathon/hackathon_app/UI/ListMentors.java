package com.hackathon.hackathon_app.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hackathon.hackathon_app.Adapter.ListMentorsAdapter;
import com.hackathon.hackathon_app.R;

public class ListMentors extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListMentorsAdapter listMentorsAdapter;
    private View edit_tags_button, sss_button, about_us_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mentors);
        //INITALIZE
        recyclerView = findViewById(R.id.recycler_mentors);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listMentorsAdapter = new ListMentorsAdapter(this);
        recyclerView.setAdapter(listMentorsAdapter);

        edit_tags_button = findViewById(R.id.edit_tags_button);
        sss_button = findViewById(R.id.sss_button);
        about_us_button = findViewById(R.id.aboutusbutton);

        //OnClicks Tests/Events

        //sss
        sss_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListMentors.this, "Sıkça Sorulan Sorular", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Fag.class);
                startActivity(intent);
            }
        });

        //edit_tags
        edit_tags_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListMentors.this, "Tagları Düzenle", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Tags.class);
                startActivity(intent);
            }
        });

        //about us
        about_us_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListMentors.this, "Biz kimiz?", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(intent);
            }
        });
    }
}