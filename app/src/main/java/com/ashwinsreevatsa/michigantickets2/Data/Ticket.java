package com.ashwinsreevatsa.michigantickets2.Data;

/**
 * Ticket object along with information needed for each ticket including game, section, seller, phone
 * number, and price
 */
public class Ticket {
    public int ticketID;//TODO delete if unnecessary

    public String game; //Game (Nebraska, Ohio St, etc)
    public String seatSection;
    public int seatRow;
    public int seatNum; //Seat number

    public String name;
    public int phoneNumber;
    public double price; //Asking price of the seller

    public Ticket(){
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Ticket(String game, String seatSection, int seatRow, int seatNum, String name,
                  int phoneNumber, double price){

        this.game = game;
        this.seatSection = seatSection;
        this.seatRow = seatRow;
        this.seatNum = seatNum;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.price = price;


    }
}
