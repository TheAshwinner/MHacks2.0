package com.ashwinsreevatsa.michigantickets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private Button button2;

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
<<<<<<< HEAD
||||||| merged common ancestors
        }
=======

        //Define the Switching Activities Button
        button2 = (Button) findViewById(R.id.buyBtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuying();
            }
        });
        }
>>>>>>> 0e25016c74d8402b738da0dff3ee61ed1b294cfb

        //Define the Switching Activities Button
        button2 =(Button)

                findViewById(R.id.buyBtn);
        button2.setOnClickListener(new View.OnClickListener()

<<<<<<< HEAD
        {
            @Override
            public void onClick (View v){
                openBuying();
            }
        });

    }

    public void openSelling() {
        Intent intent = new Intent(this, Selling.class);
        startActivity(intent);


    }
||||||| merged common ancestors
            //Define the Switching Activities Button
            button2 = (Button) findViewById(R.id.buyBtn);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openBuying();
                }
        });
        }
=======

        }
>>>>>>> 0e25016c74d8402b738da0dff3ee61ed1b294cfb

        public void openBuying() {
            Intent intent = new Intent(this, Buying.class);
            startActivity(intent);

        }
    }

