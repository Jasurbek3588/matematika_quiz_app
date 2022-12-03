package com.example.matematika;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Royxatdan_otish extends AppCompatActivity {
    private EditText edLogin,edPassword;
    private EditText edSecName,edEmail;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";
    private FirebaseAuth mAuth;
public String sarvarbek;
  private SharedPreferences mPreferences;
  private SharedPreferences.Editor mEditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_royxatdan_otish);
        init();
        mPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        mEditor=mPreferences.edit();

    }
    private void init()

    {


        edSecName=findViewById(R.id.edSecName);
        edEmail=findViewById(R.id.edLogin);
        mDataBase= FirebaseDatabase.getInstance().getReference(USER_KEY);


        edLogin=findViewById(R.id.edLogin);
        edPassword=findViewById(R.id.edPassword);
        mAuth= FirebaseAuth.getInstance();
//        mDatabase.child(("max")).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                max_page= Integer.parseInt((String.valueOf(task.getResult().getValue())));
//
//            }
//        });






    }
    public void onClickSignUp(View view){
        String id=mDataBase.getKey();







        String sec_name= edSecName.getText().toString();
        String email= edEmail.getText().toString();
        String score= String.valueOf(0);
        String level =String.valueOf(1);
        String progressBar=String.valueOf(0);




        User newUser = new User(id,sec_name,email,score,level,progressBar);



        if (!TextUtils.isEmpty(edSecName.getText().toString())&&!TextUtils.isEmpty(edLogin.getText().toString())&&!TextUtils.isEmpty(edPassword.getText().toString())){
            mAuth.createUserWithEmailAndPassword(edLogin.getText().toString(),edPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())

                    {mDataBase.child(sec_name).setValue(newUser);
                        String name= sec_name;
                        mEditor.putString(getString(R.string.name),name);
                        mEditor.commit();







                        Toast.makeText(getApplicationContext(), "Foydalanuvchi Ro'yxatga Olindi", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(Royxatdan_otish.this,asosiy.class);
                        startActivity(i);
                        finish();
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "Foydalanuvchi Ro'yxatga Olinmadi", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "Iltimos Login yoki Parolni to'g'ri kiriting ", Toast.LENGTH_SHORT).show();}


    }



}