package com.ashwinsreevatsa.michigantickets2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Selling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling);

        Spinner dropdown = findViewById(R.id.gameSpinner);
        String[] items = new String[]{"Western Michigan","SMU" , "Nebraska", "Maryland", "Wisconsin", "Penn State", "Indiana"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = findViewById(R.id.sectionSpinner);
        String[] items2 = new String[]{"25","26" , "27", "28", "29", "30", "31", "32", "33"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);
    }
}