package com.example.matematika;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class asosiy<ButtonNavigationView> extends AppCompatActivity {
    RecyclerView mrecyclerView;
    private String USER_KEY = "User";
    private DatabaseReference mDataBase;
    private SharedPreferences saved;
    public static ArrayList<Quetion> list;
    DatabaseReference databaseReference,mDatabaseaa;
    private boolean nik;
    public int maxa;
    private Timer _timer=new Timer();
    private TimerTask time;
    private Double son;
    private int b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asosiy);

         b = (int)(Math.random()*(4-1+1)+1);


        if (b == 1) {
            Fragment1 f1=new Fragment1();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame,f1);
            ft.commit();

        }
        if (b==2){
            Fragment2 f2=new Fragment2();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame,f2);
            ft.commit();
        }
        if (b==3){
            Fragment3 f3=new Fragment3();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame,f3);
            ft.commit();

        }
        if (b==4){
            Fragment4 f4=new Fragment4();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame,f4);
            ft.commit();

        }





        mDatabaseaa = FirebaseDatabase.getInstance().getReference();





        mDataBase= FirebaseDatabase.getInstance().getReference(USER_KEY);







        BottomNavigationView bottomNavigationView = findViewById(R.id.bottonNavigationView);


        bottomNavigationView.setSelectedItemId(R.id.play);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.rank:
                        Intent i=new Intent(asosiy.this,leaderboard.class);
                        startActivity(i);
                        b = (int)(Math.random()*(4-1+1)+1);


                        if (b == 1) {
                            Fragment1 f1=new Fragment1();
                            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.frame,f1);
                            ft.commit();

                        }
                        if (b==2){
                            Fragment2 f2=new Fragment2();
                            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.frame,f2);
                            ft.commit();
                        }
                        if (b==3){
                            Fragment3 f3=new Fragment3();
                            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.frame,f3);
                            ft.commit();

                        }
                        if (b==4){
                            Fragment4 f4=new Fragment4();
                            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.frame,f4);
                            ft.commit();

                        }

                        return true;




                    case R.id.settings:
                        Intent ii=new Intent(asosiy.this,Settings.class);
                        startActivity(ii);

                        b = (int)(Math.random()*(4-1+1)+1);


                        if (b == 1) {
                            Fragment1 f1=new Fragment1();
                            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.frame,f1);
                            ft.commit();

                        }
                        if (b==2){
                            Fragment2 f2=new Fragment2();
                            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.frame,f2);
                            ft.commit();
                        }
                        if (b==3){
                            Fragment3 f3=new Fragment3();
                            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.frame,f3);
                            ft.commit();

                        }
                        if (b==4){
                            Fragment4 f4=new Fragment4();
                            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.frame,f4);
                            ft.commit();

                        }

                        return true;
                }
                return false;
            }
        });

    saved=getSharedPreferences("save1", Activity.MODE_PRIVATE);
    }





public void kirr(View view){

        mDataBase.child("Jasurbek").child("score").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ss=snapshot.getValue().toString();

                saved.edit().putString("score",String.valueOf((long) (100+Double.parseDouble(ss)))).commit();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    HashMap hashMap= new HashMap();
    hashMap.put("score",saved.getString("score",""));
    mDataBase.child("Jasurbek").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
        @Override
        public void onSuccess(Object o) {

        }
    });


}
public void flclick(View view)
{
    b = (int)(Math.random()*(4-1+1)+1);


    if (b == 1) {
        Fragment1 f1=new Fragment1();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,f1);
        ft.commit();

    }
    if (b==2){
        Fragment2 f2=new Fragment2();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,f2);
        ft.commit();
    }
    if (b==3){
        Fragment3 f3=new Fragment3();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,f3);
        ft.commit();

    }
    if (b==4){
        Fragment4 f4=new Fragment4();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,f4);
        ft.commit();

    }


    Intent intent=new Intent(asosiy.this,mavzular.class);


    startActivity(intent);



}
public void quizbase (){
    list= new ArrayList<>();
    databaseReference=FirebaseDatabase.getInstance().getReference("Question");
    databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for (DataSnapshot dataSnapshot:snapshot.getChildren())
            {
                Quetion quetion=dataSnapshot.getValue(Quetion.class);
                list.add(quetion);

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

}




}