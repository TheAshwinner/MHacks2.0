package com.ashwinsreevatsa.michigantickets2.Data;

/**
 * Ticket object along with information needed for each ticket including game, section, seller, phone
 * number, and price
 */
public class Ticket {
    public String game; //Game (Nebraska, Ohio St, etc)
    public String seatSection;
    public String seatRow;
    public String seatNum; //Seat number

    public String name;
    public String phoneNumber;
    public String price; //Asking price of the seller

    public Ticket(){
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Ticket(String game, String seatSection, String seatRow, String seatNum, String name,
                  String phoneNumber, String price){

        this.game = game;
        this.seatSection = seatSection;
        this.seatRow = seatRow;
        this.seatNum = seatNum;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.price = price;


    }
}
