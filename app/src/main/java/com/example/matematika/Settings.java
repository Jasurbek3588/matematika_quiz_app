package com.example.matematika;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Settings extends AppCompatActivity {
    Spinner spinner;

    public static final String[] languages={"Tilni tanlash","English","Russian","Uzbek"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        spinner=findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang=parent.getItemAtPosition(position).toString();
                if (selectedLang.equals("Ingilizcha")||selectedLang.equals("Englich")||selectedLang.equals("Английский")){

                    setLocal(Settings.this,"eng");
                    Intent intent=new Intent(Settings.this,asosiy.class);
                    startActivity(intent);
                    finish();

                }
                if (selectedLang.equals("Russian")||selectedLang.equals("Русский")||selectedLang.equals("Ruscha")){
                    setLocal(Settings.this,"rus");
                    finish();
                    Intent intent=new Intent(Settings.this,asosiy.class);
                    startActivity(intent);
                    finish();



                }
                if (selectedLang.equals("Uzbek")||selectedLang.equals("Узбекский")||selectedLang.equals("O'zbekcha"))
                { setLocal(Settings.this,"");
                    Intent intent=new Intent(Settings.this,asosiy.class);
                    startActivity(intent);
                    finish();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void setLocal(Activity activity,String langCode){
        Locale locale= new Locale(langCode);
        locale.setDefault(locale);
        Resources resources=activity.getResources();
        Configuration config=resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config,resources.getDisplayMetrics());
    }
    public void share(View view){


        
    }
}