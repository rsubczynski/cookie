package com.example.user.mycookieklicker.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Switch;

import com.example.user.mycookieklicker.R;
import com.example.user.mycookieklicker.util.SharedPrefsUtils;

import static com.example.user.mycookieklicker.util.SharedPrefsUtils.PREFS_OPTIONS_RUN_IN_BACKGROUND;

public class OptionsActivity extends AppCompatActivity {

    private SharedPrefsUtils sharedPrefsUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.options_activity_title));
        setSupportActionBar(toolbar);
        sharedPrefsUtils = SharedPrefsUtils.getInstance(this);
        Switch switchOption = findViewById(R.id.switch_select);

        switchOption.setChecked(sharedPrefsUtils.getOption(PREFS_OPTIONS_RUN_IN_BACKGROUND));

        switchOption.setOnCheckedChangeListener((compoundButton, isEnable) ->
                sharedPrefsUtils.saveOption(PREFS_OPTIONS_RUN_IN_BACKGROUND, isEnable));
    }
}
