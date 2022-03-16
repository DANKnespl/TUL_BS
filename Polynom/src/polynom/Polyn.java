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
        Polynom a = Polynom.getInstanceNonRev(1,2,3);
        Polynom b = Polynom.getInstanceNonRev(1,2);
        
        System.out.println(a);
        System.out.println(PolynomLib.add(a, b));
        System.out.println(a);
        System.out.println(PolynomLib.sub(a, b));
        System.out.println(PolynomLib.mulC(a, 7));
        System.out.println(b.getLevel());
        System.out.println(PolynomLib.mulP(a, b));
    }
    
}
