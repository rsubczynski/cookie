package com.example.user.mycookieklicker.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mycookieklicker.R;

import java.util.Timer;
import java.util.TimerTask;

import static android.widget.Toast.LENGTH_LONG;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;
    private Button but8;
    private ImageButton ivCookie;
    private TextView tvScore;
    private TextView tvTime;
    Test test;

    public int seconds = 0;
    public int minutes = 0;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.game_activity_title));
        setSupportActionBar(toolbar);
        initViews();
        tvScore.setText("0");

        test = new Test(new Test.Callback() {
            @Override
            public void vvvv() {
                tvScore.setText(String.valueOf(score));
            }

            @Override
            public void callbackAction1(int score) {
                tvScore.setText(String.valueOf(score));
            }

            @Override
            public void xxxx() {
                tvScore.setText(String.valueOf(score));
            }
        });

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(() -> {
                    tvTime.setText(String.valueOf(minutes)+":"+String.valueOf(seconds));
                    seconds += 1;

                    if(seconds==10){
                        but1.setBackgroundColor(Color.RED);
                        but1.setEnabled(true);
                    }

                    if(seconds == 60)
                    {
                        tvTime.setText(String.valueOf(minutes)+":"+String.valueOf(seconds));

                        seconds=0;
                        minutes=minutes+1;


                    }
                });
            }

        }, 0, 1000);
    }

    private void initViews() {
        but1 = findViewById(R.id.btn_1);
        but2 = findViewById(R.id.btn_2);
        but3 = findViewById(R.id.btn_3);
        but4 = findViewById(R.id.btn_4);
        but5 = findViewById(R.id.btn_5);
        but6 = findViewById(R.id.btn_6);
        but7 = findViewById(R.id.btn_7);
        but8 = findViewById(R.id.btn_8);
        ivCookie = findViewById(R.id.iv_cookie);
        tvScore = findViewById(R.id.tv_score);
        tvTime = findViewById(R.id.tv_time);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        ivCookie.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_1:
                test.calculate1();
                break;
            case R.id.btn_2:
                showToast("2");
                break;
            case R.id.btn_3:
                showToast("3");
                break;
            case R.id.btn_4:
                showToast("4");
                break;
            case R.id.btn_5:
                showToast("5");
                break;
            case R.id.btn_6:
                showToast("6");
                break;
            case R.id.btn_7:
                showToast("7");
                break;
            case R.id.btn_8:
                showToast("8");
                break;
            case R.id.iv_cookie:
                clickCookie();
                break;
        }
    }

    private void clickCookie() {
        score++;
        tvScore.setText(String.valueOf(score));
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, LENGTH_LONG).show();
    }


}