package com.ashwinsreevatsa.michigantickets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Define the Switching Activities Button
        button = (Button) findViewById(R.id.sellBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSelling();
            }
        });
        }

        public void openSelling() {
            Intent intent = new Intent(this, Selling.class);
            startActivity(intent);
        }
    }

