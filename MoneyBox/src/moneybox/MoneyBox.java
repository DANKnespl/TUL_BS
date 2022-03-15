package moneybox;
public class MoneyBox{
        private String name;
        private int ones;
        private int twos;
        
        public MoneyBox(String name){
            this.name=name;
            this.ones=0;
            this.twos=0; 
            
        }
        public MoneyBox(String name,int ones, int twos){
            this.name=name;
            this.ones=ones;
            this.twos=twos;            
        }
        
        public void setName(String newName){
            name=newName;
        }
        
        public int getSum(){
            return ones+2*twos;
        }
        
        public void incrementOnes(){
            incrementOnes(1);
        }
        
        public void incrementTwos(){
            incrementTwos(1);
        }
        
        public void incrementOnes(int numOnes){
            ones+=numOnes; 
        }

        public void incrementTwos(int numTwos){
            twos+=numTwos;
        }
        
        public void insertMoney(int numOnes,int numTwos){
            incrementOnes(numOnes);
            incrementTwos(numTwos);
        }
        
        public boolean boolGift(int price){
            return (getSum()>price);
        }
        
        public void transfermoney(MoneyBox end, int ones, int twos){
            insertMoney(-ones,-twos);
            end.insertMoney(ones,twos);
        }
        
        
        @Override
        public String toString(){
            return name+" má v pokladničce "+getSum()+"Kč - "+ones+"x1Kč, "+twos+"x2Kč";
        }
}
