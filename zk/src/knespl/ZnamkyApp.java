/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package knespl;

import java.awt.image.RasterOp;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import knespl.Skola.StudentskaKniha;

/**
 *
 * @author Tommy
 */
public class ZnamkyApp {

    /**
     * @param args the command line arguments
     * Daniel Knespl M21000119
     */
    private static Scanner sc = new Scanner(System.in);
    private static StudentskaKniha sk= null;
    
    public static void main(String[] args) {
        boolean ukonci = false;
        //LocalDateTime ldt = LocalDateTime.of(2002, 3, 27, 13, 0, 0);
        //System.out.println(ldt.format(DateTimeFormatter.ISO_DATE_TIME));
        while(!ukonci){
            vykresli();
            int moznost = vyber();
            ukonci=zpracuj(moznost);
        }
    }
    
    private static void vykresli(){
        System.out.println("================================");
        System.out.println("0. Konec");
        System.out.println("1. Otevření knihy");
        System.out.println("2. Počítání průměru");
        System.out.println("3. Přidání známky");
        System.out.println("4. Výpis knihy na obrazovku");
        System.out.println("6. Výpis knihy do souboru");
        System.out.println("================================");
    }
    
    private static int vyber(){
        int moznost;
        try{
            moznost= sc.nextInt();
        }catch(Exception e){
            moznost=-1;
        }finally {
            sc.nextLine();
        }
        return moznost;
    }
    
    private static boolean zpracuj(int moznost){
        switch(moznost){
            case 0 -> {return true;}
            case 1 -> otevritKnihu();
            case 2 -> pocitaniPrumeru();
            case 3 -> pridaniZnamky();
            case 4 -> vypisNaKonzoli();
            case 6 -> vypisDoSouboru();
            default -> System.out.println("Chybný vstup");
        }
        return false;
    }
    
    private static void otevritKnihu(){
        System.out.println("Zadejte absolutní cestu k souboru se seznamem studentů");
        String studentPath=sc.nextLine().trim();
        System.out.println("Zadejte absolutní cestu k souboru se seznamem známek");
        String znamkyPath=sc.nextLine().trim();
        try{
            sk = new StudentskaKniha(studentPath,znamkyPath,false);
            System.out.println("Soubory uspěšně načteny");
        }catch(IllegalArgumentException e){
            if("znamkyNotFound".equals(e.getMessage())){
                System.out.println("Nebyl nalezen soubor se známkami. vytvořit nový? (ano/ne)");
                if(sc.nextLine().trim()=="ano"){
                    try{
                        sk = new StudentskaKniha(studentPath,znamkyPath,true);
                    }catch(IOException e2){
                        System.out.println(e.getMessage());
                    }
                }
            }
            else{
                System.out.println(e.getMessage());
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    private static void pocitaniPrumeru(){
        if(sk==null){
            System.out.println("Nebyla vybrána třídní kniha");
        }else{
            try{
                System.out.println("Zadejte číslo studenta");
                int cislo =sc.nextInt();
                sc.nextLine();
                System.out.println("Průměr: "+sk.getPrumerStudenta(cislo));
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch(InputMismatchException e){
                System.out.println("Byla zadána chybná hodnota");
            }catch(Exception e){
                System.out.println("Student nema znamky");
            }
        }
    }
    
    private static void pridaniZnamky(){
        if(sk==null){
            System.out.println("Nebyla vybrána třídní kniha");
        }else{
            try{
                System.out.println("Zadejte cislo v knize studentu");
                int cislo =sc.nextInt();
                System.out.println("Zadejte znamku s desetinou tečkou");
                double znamka =sc.nextDouble();
                System.out.println("Zadejte váhu s desetinou tečkou");
                double vaha =sc.nextDouble();
                sc.nextLine();
                sk.pridejZnamkuStudentovi(cislo,znamka,vaha);
                System.out.println("Známka úspěšně přidána");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.out.println(e.getMessage());
            }catch(InputMismatchException e){
                System.out.println("Byla zadána chybná hodnota");
            }
        }
    }
    
    private static void vypisNaKonzoli(){
        if(sk==null){
            System.out.println("Nebyla vybrána třídní kniha");
        }else{
            System.out.println(sk.toString());
        }
    }
    
    private static void vypisDoSouboru(){
        if(sk==null){
            System.out.println("Nebyla vybrána třídní kniha");
        }else{
            try{
                System.out.println("Zadejte absolutní cestu k souboru pro zápis");
                String outPath =sc.nextLine().trim();
                System.out.println("Vyberte z nabídky");
                System.out.println("    1. seřadit dle průměru");
                System.out.println("    2. seřadit dle abecedy");
                System.out.println("    ostatní - seřadit dle studentských čísel");
                String comparatorChoice =sc.nextLine().trim();
                sk.saveToFile(outPath, comparatorChoice);
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
}
