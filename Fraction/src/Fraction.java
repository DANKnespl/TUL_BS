/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tommy
 */
public class Fraction {
    private int num;
    private int denum;
    
    public Fraction(int num, int denum){
        int u=num;
        int w=denum;
        int r=1;
        while (w!=0){
            r = u%w;
            u=w;
            w=r;
        }
        if (denum/u<0){
        this.num=num/u*(-1);
        this.denum=denum/u*(-1);
        }else{
        this.num=num/u;
        this.denum=denum/u;
        }
    }
    public Fraction(String fraction){
        int index=fraction.lastIndexOf('/');
        int num=Integer.parseInt(fraction.substring(0, index));
        int denum=Integer.parseInt(fraction.substring(index+1));
        int u=num;
        int w=denum;
        int r=1;
        while (w!=0){
            r = u%w;
            u=w;
            w=r;
        }    
        if (denum/u<0){
        this.num=num/u*(-1);
        this.denum=denum/u*(-1);
        }else{
        this.num=num/u;
        this.denum=denum/u;
        }
    }
    public int getNum(){
        return num;
    }
    public int getDenum(){
        return denum;
    }
    public double calcDouble(){
        return (double)num/denum;
    }
    @Override
    public String toString(){
        if (num==0) return "0";
        if (denum==1) return String.format("%d", num);
        if (num==denum) return "1";
        return String.format("%d/%d", num,denum);
    }
}
