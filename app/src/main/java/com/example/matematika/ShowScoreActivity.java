package com.example.matematika;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowScoreActivity extends AppCompatActivity {
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";
    private SharedPreferences savedd;
    private SharedPreferences.Editor mEditor1;
    private String sacc;

    TextView TxtScore;

    TextView TxtStatus;

    MediaPlayer audio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
        mDataBase= FirebaseDatabase.getInstance().getReference(USER_KEY);



        TxtScore = findViewById(R.id.txtscore);
        TxtStatus = findViewById(R.id.txtStatus);
        Intent intent = getIntent();
        String scores = String.valueOf(intent.getIntExtra("score", 0));
        savedd= PreferenceManager.getDefaultSharedPreferences(this);
        mEditor1=savedd.edit();


        TxtScore.setText(scores);
        TxtStatus.setText(setStatus(scores));
        audio.start();
    }

    private String setStatus(String scores){
        int score = Integer.parseInt(scores);
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEditor = mPreferences.edit();
        String name= mPreferences.getString(getString(R.string.name),"");
        mDataBase.child(name).child("score").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String sss=snapshot.getValue().toString();
                sacc= String.valueOf((long) (score+Double.parseDouble(sss)));



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });








        if(score >= 8){
            audio = MediaPlayer.create(this, R.raw.high_score);
            return getString(R.string.nat_alo);
        }

        if (score >= 5){
            audio = MediaPlayer.create(this,  R.raw.medium_score);
            return getString(R.string.nat_ort);
        }

        audio = MediaPlayer.create(this,  R.raw.low_score);
        return getString(R.string.nat_past);

    }


    public void goToHome(View view){
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEditor = mPreferences.edit();
        String name= mPreferences.getString(getString(R.string.name),"");

        mDataBase.child(name).child("score").setValue(sacc);
//        Intent i=new Intent(ShowScoreActivity.this,Config.class);
//        startActivity(i);
        Intent intent = getIntent();
        String scores = String.valueOf(intent.getIntExtra("score", 0));

        Intent home = new Intent(this, asosiy.class);
        home.putExtra("score",scores);
        startActivity(home);
        finish();
    }

}
