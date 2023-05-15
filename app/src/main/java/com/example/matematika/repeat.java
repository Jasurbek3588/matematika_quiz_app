package com.example.matematika;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class repeat extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton optionA;
    RadioButton optionB;
    RadioButton optionC;
    RadioButton optionD;

    private DatabaseReference mDatabase,databaseReference;
    TextView savol;
    String teshkirish;
    String javob;
    int score=0;

    public int index=1;
    int max_page=10;
    int a;
    int bb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent222=getIntent();
         bb= Integer.parseInt(intent222.getStringExtra("rep"));
        mDatabase = FirebaseDatabase.getInstance().getReference("Question");
        databaseReference=FirebaseDatabase.getInstance().getReference("User");
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEditor = mPreferences.edit();
        String name= mPreferences.getString(getString(R.string.name),"");

        databaseReference.child(name).child("score").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                a = Integer.parseInt((String.valueOf(task.getResult().getValue())));



            }
        });












        init();
        if (index==1){
            setAllData();


        }else {

        }






    }




    public void loadAnswer(View view) {



        int op = radioGroup.getCheckedRadioButtonId();

        switch (op){
            case R.id.VarA:

                teshkirish="A";

                break;

            case R.id.VarB:
                teshkirish="B";

                break;

            case R.id.VarC:
                teshkirish="C";

                break;

            case R.id.VarD:
                teshkirish="D";

                break;

            default:
                return;

        }


        radioGroup.clearCheck();
        this.startActivity(isRightOrWrong(teshkirish));



    }
    private void setAllData() {

        mDatabase.child(String.valueOf(bb)).child(String.valueOf(index)).child("savol").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                savol.setText(String.valueOf(task.getResult().getValue()));

            }
        });
        mDatabase.child(String.valueOf(bb)).child(String.valueOf(index)).child("JA").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                optionA.setText(String.valueOf(task.getResult().getValue()));

            }
        });
        mDatabase.child(String.valueOf(bb)).child(String.valueOf(index)).child("JB").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                optionB.setText(String.valueOf(task.getResult().getValue()));

            }
        });
        mDatabase.child(String.valueOf(bb)).child(String.valueOf(index)).child("JC").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                optionC.setText(String.valueOf(task.getResult().getValue()));

            }
        });
        mDatabase.child(String.valueOf((bb))).child(String.valueOf(index)).child("JD").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                optionD.setText(String.valueOf(task.getResult().getValue()));

            }
        }); mDatabase.child(String.valueOf(bb)).child(String.valueOf(index)).child("javob").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                javob=(String.valueOf(task.getResult().getValue()));

            }
        });
//        mDatabase.child(String.valueOf(bb)).child(("max")).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                max_page= Integer.parseInt((String.valueOf(task.getResult().getValue())));
//
//            }
//        });




    }
    public void init(){

        radioGroup = findViewById(R.id.radioGroup);
        optionA = findViewById(R.id.VarA);
        optionB = findViewById(R.id.VarB);
        optionC = findViewById(R.id.VarC);
        optionD = findViewById(R.id.VarD);

        savol=findViewById(R.id.savol);


    }
    private Intent isRightOrWrong(String teshkirish){
        Intent screen;
        if(teshkirish.equals(javob)) {
            this.score += 1;
            screen = new Intent(this, RightActivity.class);
            index=index+1;
            if(index==(max_page+1)){
                Intent intent=new Intent(repeat.this,ShowScoreActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();


            }

            setAllData();


        }else {
            screen = new Intent(this, WrongActivity.class);
            index=index+1;
            if(index==(max_page+1)){
                Intent intent=new Intent(repeat.this,ShowScoreActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();


            }

            setAllData();

        }

        return screen;
    }
}