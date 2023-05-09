/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.definedClasses;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Tommy
 */
public class Transaction {
    LocalDateTime date;
    float amount;
    String abr;

    public Transaction(float amount,String date,String abr) throws ParseException {
        this.amount = amount;
        this.abr = abr;
        this.date=LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
    }
    
    public Transaction(float amount, String abr){
        this.amount = amount;
        this.abr=abr;
        this.date=LocalDateTime.now();
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public String getAbr() {
        return abr;
    }
    
    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ISO_DATE_TIME) + " | " + amount + " "+ abr;
    }
    
}
