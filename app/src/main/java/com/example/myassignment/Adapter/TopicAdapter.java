package com.example.myassignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myassignment.Model.phrases;
import com.example.myassignment.Model.topics;
import com.example.myassignment.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {

    Context mCtx;
    List<topics> list;
    List<phrases> phrasesList;

    public TopicAdapter(Context mCtx, List<topics> list) {
        this.mCtx = mCtx;
        this.list = list;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.topics_view, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, final int position) {

        holder.setIsRecyclable(false);
        holder.textView_topic_name.setText(list.get(position).name);

        phrasesList = new ArrayList<>();
        phrasesList.addAll(list.get(position).phrases);

        for (int i=0;i<phrasesList.size();i++){

            View v = LayoutInflater.from(mCtx).inflate(R.layout.phrase_view, null);
            TextView textView_phrase_name;
            ImageView img;

            textView_phrase_name = v.findViewById(R.id.txt_phrase_name);
            img = v.findViewById(R.id.img);

            textView_phrase_name.setText(phrasesList.get(i).getName());

            Glide.with(mCtx)
                    .load(phrasesList.get(i).getImageUrl())
                    .into(img);

            holder.linearLayout.addView(v);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TopicViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView textView_topic_name;

        public TopicViewHolder(View itemView) {
            super(itemView);

            linearLayout  = itemView.findViewById(R.id.cont);
            textView_topic_name = itemView.findViewById(R.id.txt_topic_name);
        }
    }
}


