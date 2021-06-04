package com.hackathon.hackathon_app.Model;


import java.util.ArrayList;

public class Mentros {
    private String[] tags = {
            "Enes Çakar",
            "Kaan Berk Acar",
            "Rüveyda Eser",
            "Rabia Yılmaz",
            "Beste Atmaca",
            "Okan Göztak",
            "İsimsiz Kahraman 1",
            "İsimsiz Kahraman 2"
    };
    public ArrayList<String> getTags(){
        ArrayList<String> tags = new ArrayList<>();
        for (int i = 0; i<this.tags.length; i++) {
            tags.add(this.tags[i]);
        }
        return tags;
    }
}
