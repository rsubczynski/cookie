package com.example.user.mycookieklicker.entity;

public class Ranking {

    private String nick;
    private String score;
    private String time;

    public Ranking(String nick, String score, String time) {
        this.nick = nick;
        this.score = score;
        this.time = time;
    }

    public String getNick() {
        return nick;
    }

    public String getScore() {
        return score;
    }

    public String getTime() {
        return time;
    }
}
