package com.ashwinsreevatsa.michigantickets2.Data;

/**
 * Ticket object along with information needed for each ticket including game, section, seller, phone
 * number, and price
 */
public class Ticket {
    private int ticketID;

    private String game; //Game (Nebraska, Ohio St, etc)
    private int seatSection;
    private int seatRow;
    private int seatNum; //Seat number

    private String name;
    private int phoneNumber;
    private double price; //Asking price of the seller

    public Ticket(){
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Ticket(String game, int seatSection, int seatRow, int seatNum, String name,
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
