package com.example.matematika;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class mavzular extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mavzular);





    }
    public void test1clic(View view){

        Intent i=new Intent(mavzular.this,Game.class);
        startActivity(i);


    }
    public void repeat1(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","0");
        startActivity(intent1);
        finish();


    }
    public void repeat2(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","1");
        startActivity(intent1);
        finish();


    }
    public void repeat3(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","2");
        startActivity(intent1);
        finish();


    }
    public void repeat4(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","3");
        startActivity(intent1);
        finish();


    }
    public void repeat5(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","4");
        startActivity(intent1);
        finish();


    }
    public void repeat6(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","5");
        startActivity(intent1);
        finish();


    }
    public void repeat7(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","6");
        startActivity(intent1);
        finish();


    }
    public void repeat8(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","7");
        startActivity(intent1);
        finish();


    }
    public void repeat9(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","8");
        startActivity(intent1);
        finish();


    }
    public void repeat10(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","9");
        startActivity(intent1);
        finish();


    }
    public void repeat11(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","10");
        startActivity(intent1);
        finish();


    }
    public void repeat12(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","11");
        startActivity(intent1);
        finish();


    }
    public void repeat13(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","12");
        startActivity(intent1);
        finish();


    }
    public void repeat14(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","13");
        startActivity(intent1);
        finish();


    }
    public void repeat15(View view){
        Intent intent1=new Intent(mavzular.this,repeat.class);
        intent1.putExtra("rep","14");
        startActivity(intent1);
        finish();


    }

}