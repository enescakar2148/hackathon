package com.hackathon.hackathon_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.hackathon_app.R;
import com.hackathon.hackathon_app.UI.ChatRoom;
import com.hackathon.hackathon_app.UI.MentorInfo;

import java.util.ArrayList;

public class ListMentorsAdapter extends RecyclerView.Adapter<ListMentorsAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<String> tags;

    public ListMentorsAdapter(Context mContext, ArrayList<String> tags) {
        this.mContext = mContext;
        this.tags = tags;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_mentor, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMentorsAdapter.ViewHolder holder, int position) {
        holder.name.setText(tags.get(position));
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext, ChatRoom.class);
                intent.putExtra("ChatId","ChatRoom_"+ (position+1));
                mContext.startActivity(intent);
            }
        });
        holder.mentorPp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext, MentorInfo.class);
                intent.putExtra("ChatId","ChatRoom_"+ (position+1));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
    private CardView card;
    private ImageView mentorPp;
    private TextView name, tag;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            mentorPp = itemView.findViewById(R.id.mentorPp);
            name = itemView.findViewById(R.id.name);
        }
    }
}
