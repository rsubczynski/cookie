package com.example.user.mycookieklicker.adapter;

import java.util.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.mycookieklicker.R;
import com.example.user.mycookieklicker.entity.Ranking;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {
    private List<Ranking> rankingList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNick;
        public TextView tvScore;
        public TextView tvTime;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            tvNick = v.findViewById(R.id.tv_nick);
            tvScore = v.findViewById(R.id.tv_score);
            tvTime = v.findViewById(R.id.tv_time);
        }
    }

    public void add(int position, Ranking ranking) {
        rankingList.add(position, ranking);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        rankingList.remove(position);
        notifyItemRemoved(position);
    }

    public RankingAdapter(List<Ranking> myDataset) {
        rankingList = myDataset;
    }

    @NonNull
    @Override
    public RankingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvNick.setText(rankingList.get(position).getNick());
        holder.tvScore.setText(rankingList.get(position).getScore());
        holder.tvTime.setText(rankingList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return rankingList.size();
    }

}