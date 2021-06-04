package com.hackathon.hackathon_app.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.hackathon_app.R;

import java.util.ArrayList;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.ViewHolder> {
    private ArrayList<String> tags;
    private ArrayList<Integer> images;
    private Context mContext;

    public TagsAdapter(ArrayList<String> tags, ArrayList<Integer> images, Context mContext) {
        this.tags = tags;
        this.images = images;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TagsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_tag, parent, false);
        return new TagsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TagsAdapter.ViewHolder holder, int position) {
        holder.textView.setText(tags.get(position));
        Drawable image = mContext.getResources().getDrawable(images.get(position));
        holder.tagImages.setImageDrawable(image);
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView tagImages;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tagText);
            tagImages = itemView.findViewById(R.id.tagImages);
        }
    }
}
