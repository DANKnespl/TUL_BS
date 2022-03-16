/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polynom;

/**
 *
 * @author Tommy
 */
public class PolynomLib {
    public static Polynom add(Polynom p1, Polynom p2) {
        double[] tmp = new double[p1.getLevel()+1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = p1.getKoef(i) + p2.getKoef(i);
        }
        Polynom out = Polynom.getInstanceNonRevA(tmp);
        return out;
    }
    public static Polynom sub(Polynom p1, Polynom p2) {
        double[] tmp = new double[p1.getLevel()+1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = p1.getKoef(i) - p2.getKoef(i);
        }
        Polynom out = Polynom.getInstanceNonRevA(tmp);
        return out;
    }
    public static Polynom mulC(Polynom p1, double c) {
        double[] tmp = new double[p1.getLevel()+1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = p1.getKoef(i)*c;
        }
        Polynom out = Polynom.getInstanceNonRevA(tmp);
        return out;
    }
    public static Polynom mulP(Polynom p1, Polynom p2) {
        double[] tmp = new double[p1.getLevel()+p2.getLevel()+1];
        for (int i = 0; i < p1.getLevel()+1; i++) {
            for (int j = 0; j < p2.getLevel()+1; j++) {
                tmp[i+j] += p1.getKoef(i)*p2.getKoef(j);
                System.out.println(tmp[i+j]);
            }
        }
        Polynom out = Polynom.getInstanceNonRevA(tmp);
        return out;
    }
    
}
