/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.definedClasses;

import java.io.IOException;
import java.util.ArrayList;
import tul.str.stinbank.services.FileSaverService;

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
        if(this.money.get(index)>=amount){
            return true;
        }
        return false;
    }
    
    private int findCurrency(Currency curr){
        int index =0;
        for(int i = 0;i<currencies.size();i++){
            if (curr.getAbr() == null ? this.currencies.get(i).getAbr() == null : curr.getAbr().equals(this.currencies.get(i).getAbr())){
                index=i;
                break;
            }
        }
        return index;
    }
    
    public boolean addMoney(float amount,int index) throws IOException{
        if (amount>0){
            Transaction tr = new Transaction(amount,currencies.get(index).getAbr());
            this.history.add(tr);
            this.money.set(index,this.money.get(index)+amount);
            FileSaverService.saveTransaction(number, tr,"target/classes/data/Transactions.txt");
            return true;
        }else{
            return false;
        }
    }
    
    public boolean addMoney(float amount,Currency curr) throws IOException{ 
        int index = findCurrency(curr);
        return addMoney(this.currencies.get(index).Transform(amount, curr),index); 
    }

    public boolean payMoney(float amount,int index) throws IOException{
        if (amount>0){
            if(!enoughMoney(amount,index)){
                amount = this.currencies.get(index).Transform(amount, this.currencies.get(0));
                index=0;
                if(!enoughMoney(amount,index)){
                    
                    System.out.println("Nedostatek peněz");
                    return false;
                }
            }
            
            Transaction tr = new Transaction(-amount,currencies.get(index).getAbr());
            this.history.add(tr);
            this.money.set(index,this.money.get(index)-amount);
            FileSaverService.saveTransaction(number, tr,"target/classes/data/Transactions.txt");
            return true;
        }else{
            return false;
        }
    }
    
    public boolean payMoney(float amount,Currency curr) throws IOException{
        int index = findCurrency(curr);
        return payMoney(this.currencies.get(index).Transform(amount, curr),index);
    }
    
    public String TransactionOut(){
        StringBuilder sb = new StringBuilder();
        for(int i=history.size()-1;i>=0;i--){
            sb.append(history.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.number).append("\n");
        for(int i = 0;i<currencies.size();i++){
            sb.append(currencies.get(i).getAbr()).append(" ").append(money.get(i)).append("\n");
        }
        return sb.toString();
    }
}
