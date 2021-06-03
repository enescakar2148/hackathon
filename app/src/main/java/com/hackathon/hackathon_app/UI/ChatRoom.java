package com.hackathon.hackathon_app.UI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.hackathon.hackathon_app.Adapter.MessageAdapter;
import com.hackathon.hackathon_app.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChatRoom extends AppCompatActivity {

    private EditText messageEditText;
    private MessageAdapter messageAdapter;
    private RecyclerView chatRecycler;
    private FloatingActionButton sendMessage;
    private TextView chatIdText;
    private String chatId;
    private FirebaseAuth mAuth;
    private String email;
    private FirebaseFirestore db;
    private ArrayList<String> checkTimes;
    private ArrayList<String> senders;
    private ArrayList<String> messages;
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
        messageAdapter = new MessageAdapter(this, checkTimes, senders, messages);
        chatRecycler.setLayoutManager(new LinearLayoutManager(this));
        chatRecycler.setAdapter(messageAdapter);

        sendMessage = findViewById(R.id.sendMessage);
        chatIdText = findViewById(R.id.chatId);
        chatIdText.setText(chatId);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        email = currentUser.getEmail();
        db = FirebaseFirestore.getInstance();
        checkTimes = new ArrayList<>();
        senders = new ArrayList<>();
        messages = new ArrayList<>();

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString();
                Date date = new Date();
                if (!message.matches("")){
                    messageEditText.setText("");
                    Map<String, Object> messagedata = new HashMap<>();
                    messagedata.put("Date",date.toString());
                    messagedata.put("Message",message);
                    messagedata.put("Sender",email);
                    //database ile iletişim
                    db.collection("ChatRooms")
                            .document(chatId)
                            .collection("Messages")
                            .document(date.toString())
                            .set(messagedata)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(ChatRoom.this, "Mesaj başarıyla gönderildi.", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(ChatRoom.this, "Bir hata meydana geldi.", Toast.LENGTH_SHORT).show();
                                }
                            });
                }else{
                    Toast.makeText(ChatRoom.this, "Lütfen mesaj giriniz.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        realtimeListener();
    }

    public void realtimeListener(){
        db.collection("ChatRooms")
                .document(chatId)
                .collection("Messages")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable @org.jetbrains.annotations.Nullable QuerySnapshot value,
                                        @Nullable @org.jetbrains.annotations.Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Toast.makeText(ChatRoom.this, "Dinlemede bir hata meydana geldi.", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        for (QueryDocumentSnapshot doc : value){
                            if (doc.get("Message") != null){
                                String tempMessage = (String) doc.get("Message");
                                String tempTime = (String) doc.getId().substring(11,19);
                                String tempSender = (String) doc.get("Sender");

                                if (!checkTimes.contains(tempTime)){
                                    messages.add(tempMessage);
                                    checkTimes.add(tempTime);
                                    senders.add(tempSender);

                                    messageAdapter.notifyDataSetChanged();

                                    System.out.println(messages);

                                    System.out.println("Message: "+tempMessage);
                                    System.out.println("Sender: "+tempSender);
                                    System.out.println("Time: "+tempTime);
                                    /*int a = 0;
                                    while (a<messages.size()){
                                        System.out.println("Message: "+messages.get(a));
                                        System.out.println("Sender: "+senders.get(a));
                                        System.out.println("Time: "+checkTimes.get(a));
                                    }*/
                                }
                            }
                        }

                    }
                });
    }






















}