package com.hackathon.hackathon_app.Model;

import java.util.ArrayList;

public class Tags {
    private String[] tags = {
            "matematik",
            "fizik",
            "kimya",
            "biyoloji",
            "tarih",
            "edebiyat",
            "yazılım",
            "tasarım",
            "anatomi",
            "bilgisayar",
            "edebiyat",
            "müzik",
            "girişimcilik",
            "tiyatro",
            "çizim",
            "ticaret",
            "elektronik",
            "felsefe",
            "oyun"
    };

    public ArrayList<String> getTags(){
        ArrayList<String> tags = new ArrayList<>();
        for (int i = 0; i<this.tags.length; i++) {
            tags.add(this.tags[i]);
            System.out.println(this.tags[i]);
        }
        return tags;
    }
}
