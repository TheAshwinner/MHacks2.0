package com.ashwinsreevatsa.michigantickets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ashwinsreevatsa.michigantickets2.Data.Ticket;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Selling extends AppCompatActivity {
    private Button homeButton;
    private Button submitButton;

    private Spinner gameSpinner;
    private Spinner sectionSpinner;
    private Spinner priceSpinner;
    private EditText editRowNum;
    private EditText editName;
    private EditText editPhoneNum;

    private String game; //Game (Nebraska, Ohio St, etc)
    private String seatSection;
    private String seatRow;
    private String seatNum; //Seat number
    private String name;
    private String phoneNumber;
    private String price; //Asking price of the seller

    private DatabaseReference firebaseDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling);

        //Create spinners in homepage
        createGameSpinner();
        createSectionSpinner();
        createpriceSpinner();
        createEditRowNum();
        createEditName();
        createEditPhoneNum();

        //Define the Switching Activities Button
        homeButton = (Button) findViewById(R.id.homeBtn);
        homeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                openMainActivity2();
                }
        });


        //Getting reference for firebase db so it can be accessed later on
        firebaseDb = FirebaseDatabase.getInstance().getReference();

        //Creating submit button
        submitButton = (Button) findViewById(R.id.submitBtn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check if all fields are entered; if they are, submit, if not let user know

                if(getTicketValues()) {
                    Ticket ticketItem = createTicketObject();
                    firebaseDb.push().setValue(ticketItem);

//                    Ticket testTicket = new Ticket("Indiana", "27", 15,
//                            26, "Ashwin Sreevatsa", 1234567890, 100.0); //TODO change this so that it takes the value given
//                    firebaseDb.push().setValue(testTicket);

                } else {
                    Log.v("Missing data", "Please fill in all data fields");
                }//TODO if the get ticket method returns false, tell user to fill in fields
            }
        });

    }

    private void createEditPhoneNum() {
        editPhoneNum = (EditText) findViewById(R.id.editTextPhone);
    }

    private void createEditName() {
        editName = (EditText) findViewById(R.id.editTextName);
    }

    private void createEditRowNum() {
        editRowNum = (EditText) findViewById(R.id.editTextRow);
    }


    /**
     * Creates spinner to select game for ticket
     */
    private void createGameSpinner() {
        gameSpinner = (Spinner) findViewById(R.id.gameSpinner);
        String[] items = new String[]{" ----- ", "Western Michigan","SMU" , "Nebraska", "Maryland", "Wisconsin", "Penn State", "Indiana"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        gameSpinner.setAdapter(adapter);
    }

    /**
     * Creates spinner to select the section for ticket
     */
    private void createSectionSpinner() {
        sectionSpinner = (Spinner) findViewById(R.id.sectionSpinner);
        String[] items2 = new String[]{" ----- ", "25","26" , "27", "28", "29", "30", "31", "32", "33"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        sectionSpinner.setAdapter(adapter2);
    }

    /**
     * Creates spinner to select price for ticket
     */
    private void createpriceSpinner() {
        priceSpinner = (Spinner) findViewById(R.id.priceSpinner);
        String[] items3 = new String[]{" ----- ", "5","10" , "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "100+"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        priceSpinner.setAdapter(adapter3);
    }

    public void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    private Boolean getTicketValues(){
        //Extract all needed values
        try {
            game = gameSpinner.getSelectedItem().toString();
            seatSection = sectionSpinner.getSelectedItem().toString();
            seatRow = editRowNum.getText().toString();
            seatNum = "0"; //TODO is this needed?
            name = editName.getText().toString();
            phoneNumber = editPhoneNum.getText().toString();
            price = priceSpinner.getSelectedItem().toString();
        } catch (Exception e){
            return false;
        }
        return true;
    }
    private Ticket createTicketObject(){
        return new Ticket(game, seatSection, seatRow, seatNum, name, phoneNumber, price); //TODO bug is with asking price
    }



}