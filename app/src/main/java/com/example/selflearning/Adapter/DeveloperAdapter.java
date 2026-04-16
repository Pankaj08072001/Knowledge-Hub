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

    public DeveloperAdapter(List<DeveloperModel> list) {
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

        DeveloperModel model = list.get(position);

        holder.tv.setText(model.getName());
        holder.itemView.setBackgroundResource(model.getBgImage());
    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        holder.itemView.setBackgroundResource(backgrounds[position]);
//
////        holder.tv.setText(list.get(position));
//
////        switch (position) {
////            case 0:
////                holder.itemView.setBackgroundResource(R.drawable.android);
////                break;
////
////            case 1:
////                holder.itemView.setBackgroundResource(R.drawable.java);
////                break;
////
////            case 2:
////                holder.itemView.setBackgroundResource(R.drawable.php);
////                break;
////
////            case 3:
////                holder.itemView.setBackgroundResource(R.drawable.android);
////                break;
////
////            default:
////                holder.itemView.setBackgroundResource(R.drawable.default_bg);
////                break;
////        }
//    }

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