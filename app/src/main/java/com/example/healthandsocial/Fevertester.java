package com.example.healthandsocial;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Fevertester extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fevertester);
    }
        public void Onclick (View view){
            TextView tv = findViewById(R.id.textView);
            EditText ed = findViewById(R.id.editTextTextPersonName);
            int temp = Integer.parseInt(ed.getText().toString());
            String x;
            if (temp > 100) {
                x = "High Fever";
            } else if (temp > 90 && temp < 100) {
                x = "Moderate Fever";
            } else {
                x = "Fine";
            }
            tv.setText(x);
        }
    }
