package bus;

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
    
    public boolean inPassengers(int passengers){
        if (passengers>seats-this.passengers){
            this.passengers=seats;
            return true;
        }else{
            this.passengers+=passengers;
            return false;
        }
    }
    
    public boolean outPassengers(int passengers){
        int tmp=this.passengers-passengers;
        if (tmp<0){
            this.passengers=0;
            return true;
        }else{
            this.passengers-=passengers;
            return false;
        }
    }
    
    public void end(){
        outPassengers(passengers);
    }
}
