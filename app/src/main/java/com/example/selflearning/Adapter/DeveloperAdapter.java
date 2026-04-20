package com.example.selflearning.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selflearning.Model.DeveloperModel;
import com.example.selflearning.R;

import java.util.List;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {

    List<DeveloperModel> list;

    // ✅ Click Listener
    public interface OnItemClickListener {
        void onItemClick(DeveloperModel model);
    }

    private OnItemClickListener listener;

    // ✅ Updated constructor
    public DeveloperAdapter(List<DeveloperModel> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
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

        DeveloperModel model = list.get(position);

        holder.tv.setText(model.getName());
        holder.itemView.setBackgroundResource(model.getBgImage());

        // ✅ Item Click
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(model);
            }
        });
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