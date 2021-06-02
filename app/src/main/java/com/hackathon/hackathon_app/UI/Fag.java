package com.hackathon.hackathon_app.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hackathon.hackathon_app.R;

public class Fag extends AppCompatActivity {
EditText soruedittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fag);

        soruedittext = findViewById(R.id.soru_edittext);
    }

    public void sorugonder(View view){
        String soru = soruedittext.getText().toString();
        Toast.makeText(this, soru+ " bize ulaştı.", Toast.LENGTH_SHORT).show();

    }
}