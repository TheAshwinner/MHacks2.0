package com.ashwinsreevatsa.michigantickets2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Buying extends AppCompatActivity {


    private DatabaseReference firebaseDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying);

//Getting reference for firebase db so it can be accessed later on
        firebaseDb = FirebaseDatabase.getInstance().getReference();

    }



}