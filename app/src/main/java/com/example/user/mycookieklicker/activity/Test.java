package com.example.user.mycookieklicker.activity;

public class Test {

    Callback callback;

    public Test(Callback callback) {
        this.callback = callback;
    }

    void calculate1(){
        int score = 500;
        callback.callbackAction1(500);
    }

    public interface Callback {
        public void vvvv();
        public void callbackAction1(int score);
        public void xxxx();

    }
}
