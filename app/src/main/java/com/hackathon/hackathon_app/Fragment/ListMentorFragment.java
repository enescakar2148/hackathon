package com.hackathon.hackathon_app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackathon.hackathon_app.Adapter.ListMentorsAdapter;
import com.hackathon.hackathon_app.R;
import com.hackathon.hackathon_app.UI.MentorInfo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ListMentorFragment extends Fragment {
    private Context mContext;
    private RecyclerView recyclerView;
    private ListMentorsAdapter listMentorsAdapter;

    public ListMentorFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_mentor_fragment,container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //INITALIZE
        recyclerView = view.findViewById(R.id.recycler_mentors);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        listMentorsAdapter = new ListMentorsAdapter(mContext);
        recyclerView.setAdapter(listMentorsAdapter);

    }
}
