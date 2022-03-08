package pkg27danknesemestralprojcect;

import java.util.Locale;
import java.util.Scanner;

    /**
     * 27. Program searches for the largest dot product of multiple vectors
     * @author dankne
     * @version 1.0 10.1.22
     */
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Locale loc = new Locale("CS", "cz"); 

    /**
     * Method used for chosing what program should be started
     * @param args 
     */
    public static void main(String[] args) {
        boolean cont = true;
        sc.useLocale(loc);
        while (cont) {
            drawMenu();
            switch (sc.nextInt()) {
                case 0:
                    cont = false;
                    break;
                case 1:
                    SkalarniSoucin.logic();
                    break;
                case 2:
                    Christmas.logic();
                    break;
                default:
                    System.out.println("Neplatny výber");
            }
        }
    }
    
    /**
     * Method used for printing menu
     */
    private static void drawMenu() {
        System.out.println("---------------------");
        System.out.println("1 - Skalarni soucin");
        System.out.println("2 - Vanocni prace");
        System.out.println("0 - Konec");
        System.out.println("---------------------");
    }
}