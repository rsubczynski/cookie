package com.example.user.mycookieklicker.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.user.mycookieklicker.R;
import com.example.user.mycookieklicker.adapter.RankingAdapter;
import com.example.user.mycookieklicker.entity.Ranking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.ranking_activity_title));
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.rv_ranking);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RankingAdapter(generateRankingList());
        recyclerView.setAdapter(mAdapter);
    }

    private List<Ranking> generateRankingList() {
        List<Ranking> rankingList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rankingList.add(new Ranking("User" + i, String.valueOf(i), String.valueOf(i *100)));
        }
        return rankingList;
    }

}
