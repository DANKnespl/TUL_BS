/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polynom;

import java.util.Arrays;

/**
 *
 * @author Tommy
 */
public class PolynomLib {
    public static Polynom addP(Polynom ... p) {
        int MaxL=-1;
        for (int j = 0; j < p.length; j++) {
                if (MaxL<p[j].getLevel())
                    MaxL=p[j].getLevel();
            }
        double[] tmp = new double[MaxL+1];
        for (int i = 0; i < MaxL+1; i++) {
            for (int j = 0; j < p.length; j++) {
                    tmp[i] += p[j].getKoef(i);
            }
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
    public static Polynom mulP(Polynom ... p) {
        int sumL=0;
        for (int j = 0; j < p.length; j++) {
            sumL+=p[j].getLevel();
            }
        double[] tmp = new double[sumL+1];
        double[] tmp2= new double[sumL+1];
        for (int i = 0; i < p[0].getLevel()+1; i++) {
            tmp[i]=p[0].getKoef(i);
        }
        for (int k = 1; k < p.length; k++) {
            Arrays.fill(tmp2,0);
            for (int j = 0; j < p[k].getLevel() + 1; j++) {
                for (int i = 0; i < tmp.length-j; i++) {
                    tmp2[i+j]+=tmp[i]*p[k].getKoef(j);
                }
                
                System.out.println("");
            }
            tmp=tmp2.clone();
        }
        Polynom out = Polynom.getInstanceNonRevA(tmp);
        return out;
    }

}
