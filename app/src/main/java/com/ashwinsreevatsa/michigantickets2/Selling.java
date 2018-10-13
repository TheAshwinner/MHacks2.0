package com.ashwinsreevatsa.michigantickets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Selling extends AppCompatActivity {
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling);

        Spinner dropdown = findViewById(R.id.gameSpinner);
        String[] items = new String[]{" ----- ", "Western Michigan","SMU" , "Nebraska", "Maryland", "Wisconsin", "Penn State", "Indiana"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = findViewById(R.id.sectionSpinner);
        String[] items2 = new String[]{" ----- ", "25","26" , "27", "28", "29", "30", "31", "32", "33"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);

        Spinner dropdown3 = findViewById(R.id.priceSpinner);
        String[] items3 = new String[]{" ----- ", "$5","$10" , "$15", "$20", "$25", "30", "$35", "$40", "$45", "$50", "$55", "$60", "$65", "$70", "$75", "$80", "$85", "$90", "$95", "$100", "$100+"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        dropdown3.setAdapter(adapter3);

        //Define the Switching Activities Button
        button = (Button) findViewById(R.id.homeBtn);
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                openMainActivity2();
                }
        });
    }

    public void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}