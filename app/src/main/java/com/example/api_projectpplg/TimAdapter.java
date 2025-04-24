package com.example.api_projectpplg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TimAdapter extends RecyclerView.Adapter<TimAdapter.ViewHolder> {

    private List<Tim> timLists;

    public TimAdapter(List<Tim> timLists) {
        this.timLists = timLists;
    }

    @NonNull
    @Override
    public TimAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_tim, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimAdapter.ViewHolder holder, int position) {
        Tim team = timLists.get(position);


        holder.tvStadium.setText(timLists.get(position).getStrTeam());
        holder.tvTim.setText(timLists.get(position).getStrStadium());

        Glide.with(holder.itemView.getContext())
                .load(team.getStrBadge())
                .into(holder.ivBadge);
    }

    @Override
    public int getItemCount() {
        return timLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTim;
        TextView tvStadium;
        ImageView ivBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTim = itemView.findViewById(R.id.tvTim);
            tvStadium = itemView.findViewById(R.id.tvStadium);
            ivBadge = itemView.findViewById(R.id.ivBadge);
        }
    }
}
