package com.example.selflearning.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selflearning.Model.RoadmapModel;
import com.example.selflearning.Model.UpdateModel;
import com.example.selflearning.R;

import java.util.ArrayList;
import java.util.List;

public class RoadmapAdapter extends RecyclerView.Adapter<RoadmapAdapter.ViewHolder> {

    List<RoadmapModel> list;

    public RoadmapAdapter(List<RoadmapModel> list) {
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

        RoadmapModel model = list.get(position);

        holder.title.setText(model.getTitle());
        holder.duration.setText(model.getDuration());
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

    public static class UpdateAdapter extends RecyclerView.Adapter<UpdateAdapter.ViewHolder> {

        ArrayList<UpdateModel> list;

        public UpdateAdapter(ArrayList<UpdateModel> list) {
            this.list = list;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView title, desc;

            public ViewHolder(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.title);
                desc = itemView.findViewById(R.id.desc);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_update, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            UpdateModel model = list.get(position);
            holder.title.setText(model.title);
            holder.desc.setText(model.description);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}
