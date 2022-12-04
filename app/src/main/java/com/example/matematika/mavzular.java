package com.example.matematika;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class mavzular extends AppCompatActivity {
    TextView natija,aaa;
    ProgressBar progressBar;
    private DatabaseReference mDatabaseaa,databaseReference;
    int maxa=1,a,z=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mavzular);
        progressBar=findViewById(R.id.progress_bar);
        natija=findViewById(R.id.textView8);
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEditor = mPreferences.edit();
        String name= mPreferences.getString(getString(R.string.name),"");

        mDatabaseaa = FirebaseDatabase.getInstance().getReference();
        databaseReference=FirebaseDatabase.getInstance().getReference("User");
        mDatabaseaa.child("Question").child("maxa").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                maxa= Integer.parseInt((String.valueOf(task.getResult().getValue())))+0;
            }
        });
        databaseReference.child(name).child("score").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                a = Integer.parseInt((String.valueOf(task.getResult().getValue())));



            }
        });



        progressBar.setProgress(a);



    }
    public void test1clic(View view){

        Intent i=new Intent(mavzular.this,Game.class);
        startActivity(i);


    }
}