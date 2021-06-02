package com.hackathon.hackathon_app.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackathon.hackathon_app.R;

import org.jetbrains.annotations.NotNull;

public class MentorInfo extends AppCompatActivity {
    private String chatId;
    private TextView mentorNameTextView;
    private TextView mentorInfotextView;
    private FirebaseFirestore db;
    private String mentorName;
    private String mentorInfo;
    private String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_info);
        Intent intent = getIntent();
        if (intent.getStringExtra("ChatId") != null || !intent.getStringExtra("ChatId").matches("")) {
            chatId = intent.getStringExtra("ChatId");
        }

        //initalize
        mentorNameTextView = findViewById(R.id.mentor_name_info);
        mentorInfotextView = findViewById(R.id.mentor_text_info);
        db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("ChatRooms")
                .document(chatId)
                .collection("Mentor")
                .document("Connection");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                mentorName = (String) documentSnapshot.get("name");
                mentorInfo = (String) documentSnapshot.get("info");
                imageUrl = (String) documentSnapshot.get("imageUrl");
                mentorNameTextView.setText(mentorName);
                mentorInfotextView.setText(mentorInfo);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(MentorInfo.this, e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}