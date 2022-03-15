/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bus;

import java.util.Scanner;

/**
 *
 * @author Tommy
 */
public class BusApp {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        
        Bus uni=new Bus(41,15,"DPMLJ");
        for (int i = 1; i <= 5; i++) {
            int out=0,in=0;
            System.out.println(i+". zastávka"+(i==5?", konečná":""));
            System.out.println(uni);
            if (i<5){
                System.out.println("Kolik lidí chce vystoupit a nastoupit");
                out=sc.nextInt();
                in=sc.nextInt();
                uni.outPassengers(out);
                uni.inPassengers(in);
            }else{
                uni.end();
            }
                System.out.println(uni);
                System.out.println("");
            
        }
    }
    
}
