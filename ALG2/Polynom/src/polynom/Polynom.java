
package polynom;

import java.util.Arrays;

public class Polynom {

    private double[] koefs;
//    
//    private Polynom(double koef0){
//        koefs[0]=koef0;
//    }
//    private Polynom(double koef0,double koef1){
//        koefs[0]=koef0;
//        koefs[1]=koef1;
//    }

    private Polynom(double[] koef) {
        koefs = Arrays.copyOf(koef, koef.length);
    }

    static Polynom getInstanceRev(double... koef) {
        double[] tmp = new double[koef.length];
        for (int i = 0; i < koef.length; i++) {
            tmp[i] = koef[koef.length - 1 - i];
        }
        return new Polynom(tmp);
    }

    static Polynom getInstanceRevA(double[] koef) {
        double[] tmp = new double[koef.length];
        for (int i = 0; i < koef.length; i++) {
            tmp[i] = koef[koef.length - 1 - i];
        }
        return new Polynom(tmp);
    }

    static Polynom getInstanceNonRev(double... koef) {
        return new Polynom(koef);
    }

    static Polynom getInstanceNonRevA(double[] koef) {
        return new Polynom(koef);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < koefs.length; i++) {
            if (koefs[i] != 0) {
                sb.append(koefs[i]).append("x^").append(i).append(((i == koefs.length - 1) ? "" : " + "));
            }
        }
        return sb.toString();
    }

    public double getX() {
        double out = 0;

        return out;
    }

    public Polynom derive() {
        double[] tmp = new double[koefs.length - 1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = koefs[i + 1] * (i + 1);
        }
        Polynom out = new Polynom(tmp);
        return out;
    }


    public int getLevel() {
        return koefs.length - 1;
    }

    public double getKoef(int index) {
        return (index>koefs.length-1?0:this.koefs[index]);
    }
    public double ValueX(double x){
        double out = 0;
        for (int i = koefs.length-1; i >=0; i--) {
            out=x*out+koefs[i];
        }
        return out;
        
    }
}
