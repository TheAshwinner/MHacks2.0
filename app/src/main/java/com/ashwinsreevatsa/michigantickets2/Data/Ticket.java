package com.ashwinsreevatsa.michigantickets2.Data;

/**
 * Ticket object along with information needed for each ticket including game, section, seller, phone
 * number, and price
 */
public class Ticket {

    //TODO make these values private
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

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getSeatSection() {
        return seatSection;
    }

    public void setSeatSection(String seatSection) {
        this.seatSection = seatSection;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
