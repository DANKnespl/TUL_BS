/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Tommy
 */
public class FractionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fraction f1=new Fraction(-2,-4);
        Fraction f2=new Fraction("2/-6");
        System.out.println(f1.getNum());
        System.out.println(f1.getDenum());
        System.out.println(f1.calcDouble());
        System.out.println(f1);
        System.out.println(f2);
    }
    
}
