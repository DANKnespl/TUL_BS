/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop_01_01_bod;

/**
 *
 * @author Tommy
 */
public class Point {
    //data
    private double x;
    private double y;
    //metody
        //konstruktor
    public Point(){
        x=0.0;
        y=0.0;
    }
    //přetížení
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
     //překrytí
    @Override
    public String toString(){
        return String.format("(%.2f,%.2f)", x,y);
    }
    
    public double distanceFromOrigin(){
        return Math.hypot(x, y);
    }
    public double distanceFrom(double x, double y){
        return Math.hypot(this.x-x, this.y-y);
    }
    public double distanceFrom(Point p){
        return Math.hypot(x-p.x, y-p.y);
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    
}