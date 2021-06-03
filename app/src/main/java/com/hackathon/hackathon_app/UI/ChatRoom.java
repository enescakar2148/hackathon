package com.hackathon.hackathon_app.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hackathon.hackathon_app.R;

import java.util.HashMap;

public class ChatRoom extends AppCompatActivity {

    private EditText messageEditText;
    private RecyclerView chatRecycler;
    private FloatingActionButton sendMessage;
    private TextView chatIdText;
    private String chatId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        Intent intent = getIntent();
        if (intent.getStringExtra("ChatId") != null || !intent.getStringExtra("ChatId").matches("")) {
            chatId = intent.getStringExtra("ChatId");
        }
        //initalize
        messageEditText = findViewById(R.id.messageEditText);
        chatRecycler = findViewById(R.id.chatRecycler);
        sendMessage = findViewById(R.id.sendMessage);
        chatIdText = findViewById(R.id.chatId);
        chatIdText.setText(chatId);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}