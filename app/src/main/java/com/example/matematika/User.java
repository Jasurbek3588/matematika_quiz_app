package com.example.matematika;

public class User {
    public User() {
    }

    public String id,sec_name,email,score,level,progressBar;

    public User(String id, String sec_name, String email, String score, String level, int progressBar) {
    }

    public User(String id, String sec_name, String email, String score,String level,String progressBar) {
        this.id = id;
        this.sec_name = sec_name;
        this.email = email;
        this.score =score;
        this.level=level;
        this.progressBar=progressBar;

    }

    public String getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(String progressBar) {
        this.progressBar = progressBar;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSec_name() {
        return sec_name;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


}
