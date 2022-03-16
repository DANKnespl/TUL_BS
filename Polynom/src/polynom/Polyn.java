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
        System.out.println(a);
        lel[1]=8;
        System.out.println(a);
        System.out.println(a.getLevel());
        System.out.println(a.getKoef(0));
        Polynom b = a.derive();
        System.out.println(b);
        System.out.println(a.add(a));
        
    }
    
}
