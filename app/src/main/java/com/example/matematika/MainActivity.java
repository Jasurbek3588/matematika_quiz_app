package com.example.matematika;

import android.content.Intent;
import android.os.Bundle;
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


public class MainActivity extends AppCompatActivity {
    private EditText edLogin,edPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init()
    {
        edLogin=findViewById(R.id.edLogin);
        edPassword=findViewById(R.id.edPassword);
        mAuth= FirebaseAuth.getInstance();
    }
    public void onClickSignIn(View view){
        if (!TextUtils.isEmpty(edLogin.getText().toString())&&!TextUtils.isEmpty(edPassword.getText().toString())){
            mAuth.signInWithEmailAndPassword(edLogin.getText().toString(),edPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(), "Kirish muafiqiyatli bajarildi", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(MainActivity.this,asosiy.class);
                        startActivity(i);
                        finish();


                    }else
                    {
                        Toast.makeText(getApplicationContext(), "Login yoki parol Xato!", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }
    }

    public void registratsiya(View view){
        Intent i =new Intent(MainActivity.this,Royxatdan_otish.class);
        startActivity(i);
        finish();

    }

}