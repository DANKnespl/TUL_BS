/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moneybox;

/**
 *
 * @author Tommy
 */
public class MoneyBoxApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MoneyBox alice= new MoneyBox("Alice",2,3);
        MoneyBox bob = new MoneyBox("Bob");
        bob.incrementOnes(2);
        bob.incrementTwos(3);
        bob.insertMoney(5,10);
        System.out.println(alice);
        System.out.println(bob);
        System.out.println(alice.boolGift(39));
        System.out.println(bob.boolGift(39));
        System.out.println((bob.getSum()<alice.getSum())?"Alice":"Bob");  
        transfermoney(bob, alice,7, 13);
        System.out.println(alice);
        System.out.println(bob);
        alice.transfermoney(bob,7, 13);
        System.out.println(alice);
        System.out.println(bob);
    }
    
    public static void transfermoney(MoneyBox source, MoneyBox end, int ones, int twos){
        source.insertMoney(-ones,-twos);
        end.insertMoney(ones,twos);
    }
    
}
