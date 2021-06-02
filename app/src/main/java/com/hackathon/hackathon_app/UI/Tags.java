package com.hackathon.hackathon_app.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hackathon.hackathon_app.Adapter.TagsAdapter;
import com.hackathon.hackathon_app.R;

import java.util.ArrayList;

public class Tags extends AppCompatActivity {

    private ArrayList<String> tags;
    private com.hackathon.hackathon_app.Model.Tags tagsModel;
    private RecyclerView tags_recycler;
    private TagsAdapter tagsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags);
        tagsModel = new com.hackathon.hackathon_app.Model.Tags();
        tags =tagsModel.getTags();

        tags_recycler = findViewById(R.id.tags_recycler);
        tagsAdapter = new TagsAdapter(tags, this);
        GridLayoutManager grid = new GridLayoutManager(this, 2);
        tags_recycler.setLayoutManager(grid);


    }
}