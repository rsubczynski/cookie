package com.example.user.mycookieklicker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.mycookieklicker.R;
import com.example.user.mycookieklicker.util.SharedPrefsUtils;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNewGame;
    private Button btnRanking;
    private Button btnOptions;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.menu_activity_title));
        setSupportActionBar(toolbar);
        initButtons();
    }

    private void initButtons() {
        btnNewGame = findViewById(R.id.btn_new_game);
        btnRanking = findViewById(R.id.btn_ranking);
        btnOptions = findViewById(R.id.btn_option);
        btnExit = findViewById(R.id.btn_exit);

        btnNewGame.setOnClickListener(this);
        btnRanking.setOnClickListener(this);
        btnOptions.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_new_game:
                startGameActivity();
                break;
            case R.id.btn_ranking:
                startRankingActivity();
                break;
            case R.id.btn_option:
                startOptionActivity();
                break;
            case R.id.btn_exit:
                onBackPressed();
                break;
        }
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, LENGTH_LONG).show();
    }

    public void startOptionActivity(){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    public void startRankingActivity(){
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
    }

    public void startGameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
