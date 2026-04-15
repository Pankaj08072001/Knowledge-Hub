package com.example.selflearning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {

    List<String> list;

    public
    DeveloperAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_developer, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv.setText(list.get(position));

        // 🔥 Set background image based on position
        if (position == 0) {
            holder.itemView.setBackgroundResource(R.drawable.android);
        } else if (position == 1) {
            holder.itemView.setBackgroundResource(R.drawable.java);
        } else if (position == 2) {
            holder.itemView.setBackgroundResource(R.drawable.php);
        } else if (position == 3) {
            holder.itemView.setBackgroundResource(R.drawable.android);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ViewHolder(View v) {
            super(v);
            tv = v.findViewById(R.id.tvDevName);
        }
    }
}