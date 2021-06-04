package com.hackathon.hackathon_app.Model;

import com.hackathon.hackathon_app.R;

import java.util.ArrayList;

public class Tags {
    private String[] tags = {
            "matematik",
            "fizik",
            "kimya",
            "biyoloji",
            "edebiyat",
            "tarih",
            "sinema",
            "girişimcilik",
            "uzay",
            "sosyal medya"
    };
    private int[] images = {
            R.drawable.mathtag,
            R.drawable.phytag,
            R.drawable.chemtag,
            R.drawable.biologytag,
            R.drawable.lecturetag,
            R.drawable.historytag,
            R.drawable.sinema,
            R.drawable.girisimcilik,
            R.drawable.space,
            R.drawable.socialtag
    };

    public ArrayList<String> getTags(){
        ArrayList<String> tags = new ArrayList<>();
        for (int i = 0; i<this.tags.length; i++) {
            tags.add(this.tags[i]);
        }
        return tags;
    }
    public ArrayList<Integer> getImageTags(){
        ArrayList<Integer> images = new ArrayList<>();
        for (int i = 0; i<this.images.length; i++) {
            images.add(this.images[i]);
        }
        return images;
    }
}
