package com.hackathon.hackathon_app.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
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
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable check = holder.item.getBackground();
                int color = Color.TRANSPARENT;

                if (check instanceof ColorDrawable) {
                    color = ((ColorDrawable) check).getColor();
                    holder.item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.itemback));
                }else {
                    holder.item.setBackgroundColor(ContextCompat.getColor(mContext, R.color.teal_200));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView tagImages;
        private LinearLayout item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tagText);
            tagImages = itemView.findViewById(R.id.tagImages);
            item = itemView.findViewById(R.id.item);
        }
    }
}
