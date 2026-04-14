package com.example.selflearning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoadmapAdapter extends RecyclerView.Adapter<RoadmapAdapter.ViewHolder> {

    List<String[]> list;

    public RoadmapAdapter(List<String[]> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_roadmap, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(list.get(position)[0]);
        holder.duration.setText(list.get(position)[1]);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, duration;
        ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.tvTitle);
            duration = v.findViewById(R.id.tvDuration);
        }
    }
}
