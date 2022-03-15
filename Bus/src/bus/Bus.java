/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bus;

/**
 *
 * @author Tommy
 */
public class Bus {
    private int seats;
    private int passengers;
    private int line;
    private String owner;
    
    
    public Bus(int seats, int line, String owner){
        this.seats=seats;
        this.line=line;
        this.owner=owner;
        this.passengers=0;
    }
    
    public Bus(){
        this.seats=40;
        this.line=-1;
        this.owner="";
        this.passengers=0;
    }
    
    public int getSeats(){
        return seats;
    }
    
    public int getPassengers(){
        return passengers;
    }
    
    public int getLine(){
        return line;
    }
    
    public String getOwner(){
        return owner;
    }
    
    public void setLine(int new_line){
        this.line=new_line;
    }
    
    public void setOwner(String new_owner){
        this.owner=new_owner;
    }
    
    @Override
    public String toString(){
        return "Autobus číslo "+line+" společnosti "+owner+" s počtem sedadel "+seats+" veze "+passengers+" cestujících.";
    }
    
    public void inPassengers(int passengers){
        if (passengers>seats-this.passengers){
            System.out.println("Nastoupit mohlo jen "+(seats-this.passengers));
            this.passengers=seats;
        }else{
            this.passengers+=passengers;
        }
    }
    
    public void outPassengers(int passengers){
        int tmp=this.passengers-passengers;
        if (tmp<0){
            System.out.println("Vystoupit mohlo jen "+(this.passengers));
            this.passengers=0;
        }else{
            this.passengers-=passengers;
        }
    }
    
    public void end(){
        outPassengers(passengers);
    }
}
