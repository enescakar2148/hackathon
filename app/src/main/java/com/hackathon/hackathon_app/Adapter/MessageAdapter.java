package com.hackathon.hackathon_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.hackathon_app.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MessageAdapter  extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<String> checkTimes;
    private ArrayList<String> senders;
    private ArrayList<String> messages;

    public MessageAdapter(Context mContext, ArrayList<String> checkTimes, ArrayList<String> senders, ArrayList<String> messages) {
        this.mContext = mContext;
        this.checkTimes = checkTimes;
        this.senders = senders;
        this.messages = messages;
    }

    @NonNull
    @NotNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_message, parent, false);
        return new MessageAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MessageAdapter.ViewHolder holder, int position) {
        holder.messageText.setText(messages.get(position));
        holder.mailText.setText(senders.get(position));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView messageText, mailText;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mailText = itemView.findViewById(R.id.mailText);
            messageText = itemView.findViewById(R.id.messageText);
        }
    }
}
