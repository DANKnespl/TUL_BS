/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.definedClasses;

import java.util.ArrayList;

/**
 *
 * @author Tommy
 */
public class Account {
    private String number;
    private ArrayList<Float> money;
    private ArrayList<Currency> currencies;
    private ArrayList<Transaction> history;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

    public void setHistory(Transaction tr) {
        this.history.add(tr);
    }

    public Account(String number,ArrayList<Float> money, ArrayList<Currency> curr, ArrayList<Transaction> history) {
        this.number = number;
        this.money = money;
        this.currencies = curr;
        this.history = history;
    }

    public ArrayList<Float> getMoney() {
        return money;
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }
    
    private boolean enoughMoney(float amount,int index){
        throw new UnsupportedOperationException();
    }
    
    private int findCurrency(Currency curr){
        throw new UnsupportedOperationException();
    }
    
    public boolean addMoney(float amount,int index){
        throw new UnsupportedOperationException();
    }
    
    public boolean addMoney(float amount,Currency curr){ 
        throw new UnsupportedOperationException();
    }

    public boolean payMoney(float amount,int index){
        throw new UnsupportedOperationException();
    }
    
    public boolean payMoney(float amount,Currency curr){
        throw new UnsupportedOperationException();
    }
    
    public String TransactionOut(){
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Account{" + "number=" + number + ", money=" + money + ", currencies=" + currencies + ", history=" + history + '}';
    }
}
