/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package polynom;

/**
 *
 * @author Tommy
 */
public class Polyn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] lel={1,0,3};
        Polynom a = Polynom.getInstanceNonRev(1,1);
        Polynom b = Polynom.getInstanceNonRev(1,0,1);
        System.out.println(PolynomLib.addP(a, a,b));
        System.out.println(PolynomLib.mulP(a,b,a));
    }
    
}
