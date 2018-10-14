package com.ashwinsreevatsa.michigantickets2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ashwinsreevatsa.michigantickets2.Data.Ticket;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Buying extends AppCompatActivity {


    private DatabaseReference firebaseDb;
    private RecyclerView ticketList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying);

        //Getting reference for firebase db so it can be accessed later on
        firebaseDb = FirebaseDatabase.getInstance().getReference().child("Tickets");
        firebaseDb.keepSynced(true); //Will sync database automatically whenever opened

        ticketList = (RecyclerView) findViewById(R.id.myRecyclerView);
        ticketList.setHasFixedSize(true);
        ticketList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();


        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Tickets")
                .limitToLast(50);

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        query.addChildEventListener(childEventListener);


        FirebaseRecyclerOptions<Ticket> options = new FirebaseRecyclerOptions.Builder<Ticket>()
                .setQuery(query, Ticket.class)
                .build();


        FirebaseRecyclerAdapter<Ticket,TicketViewHolder>firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Ticket, TicketViewHolder>
                (options) {
            @Override
            protected void onBindViewHolder(@NonNull TicketViewHolder holder, int position, @NonNull Ticket model) {
                holder.setGame(model.getGame());
                holder.setSeat(model.getSeatNum());
                holder.setPrice(model.getPrice());//TODO Change- this is meant for the populateviewholder method which doesn't exist
            }

            @NonNull
            @Override
            public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.buying_ticket_row,parent,false);
                return new TicketViewHolder(view);
            }
        };

        ticketList.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();

    }

    public static class TicketViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public TicketViewHolder(View itemView){
            super(itemView);
            mView = itemView;
        }
        public void setGame(String game){
            TextView gameView = (TextView)mView.findViewById(R.id.ListGame);
            gameView.setText(game);
        }
        public void setSeat(String seat){
            TextView seatView = (TextView)mView.findViewById(R.id.ListSeat);
            String seatString = "Seat Number: " + seat;
            seatView.setText(seatString);
        }
        public void setPrice(String price){
            TextView priceView = (TextView)mView.findViewById(R.id.ListPrice);
            price = "$" + price;
            if(!(price == "100+")){
                price = price + ".00";
            }
            String priceString = "Price: " + price;
            priceView.setText(priceString);
        }
    }
}