/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package knespl.Skola;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import knespl.porovnavani.CompareAvg;
import knespl.porovnavani.CompareName;
import knespl.porovnavani.CompareNumber;

/**
 *
 * @author Tommy
 */
public class StudentskaKniha {
    private final static String ZNAMKYHEAD="student znamka vaha";
    private final static String STUDENTIHEAD="cislo;jmeno;prijmeni";
    private ArrayList<Student> studenti;
    private String znamkyPath;

    public StudentskaKniha(String studentPath, String znamkyPath, boolean create) throws IOException {
        if(create){
            try(FileWriter fw = new FileWriter(znamkyPath,false);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(ZNAMKYHEAD);
            }catch(IOException e){
                throw new IOException("Chyba zápisu");
            }
        }
        
        studenti = new ArrayList<Student>();
        this.znamkyPath=znamkyPath;
        String data= null;
        try(FileInputStream fis = new FileInputStream(studentPath)) {
            Scanner sc = new Scanner(fis,"UTF-8");
            Scanner sData;
            if(!(data=sc.nextLine().trim()).equals(STUDENTIHEAD)){throw new IllegalArgumentException("Špatná hlavička souboru se studenty");}
            while (sc.hasNextLine()){
                data = sc.nextLine();
                sData=new Scanner(data).useDelimiter(";");
                studenti.add(new Student(sData.nextInt(),sData.next(),sData.next()));
            }
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("Soubor se studenty nebyl nalezen");
        }catch(InputMismatchException e){
            throw new IllegalArgumentException("Chybná data v souboru se studenty");
        }
        
        try(FileInputStream fis = new FileInputStream(znamkyPath)){
            Scanner sc = new Scanner(fis,"UTF-8");
            Scanner sData;
            if(!sc.nextLine().trim().equals(ZNAMKYHEAD)){throw new IllegalArgumentException("Špatná hlavička souboru se známkami");}
            while(sc.hasNextLine()){                    
                data = sc.nextLine();
                sData=new Scanner(data);
                sData.useLocale(new Locale("cs","CZ"));
                int cislo = sData.nextInt();
                for(int i=0;i<studenti.size();i++){
                    if(studenti.get(i).getCislo()==cislo){
                        studenti.get(i).addZnamka(sData.nextDouble(),sData.nextDouble());
                    }
                }
            }
        }catch(FileNotFoundException ex){
            throw new IllegalArgumentException("znamkyNotFound");
        }catch(InputMismatchException e){
            throw new IllegalArgumentException("Chybná data v souboru se známkami");
        }
        
       
    }
    
    public double getPrumerStudenta(int student) throws Exception{
        for(int i = 0; i<studenti.size();i++){
            if(studenti.get(i).getCislo()==student){
                return studenti.get(i).getPrumer();
            }
        }
        throw new IllegalArgumentException("Neznámý student");
    }
    
    public void pridejZnamkuStudentovi(int student,double znamka,double vaha) throws IOException{
        boolean found=false;
        String line = String.format(new Locale("cs","CZ"), "%d %10.1f %.1f\n", student, znamka, vaha);
        for(int i = 0; i<studenti.size();i++){
            if(studenti.get(i).getCislo()==student){
                studenti.get(i).addZnamka(znamka, vaha);
                found=true;
                try(FileWriter fw = new FileWriter(znamkyPath,true);
                    BufferedWriter bw = new BufferedWriter(fw)){
                    bw.write(line);
                }catch(IOException e){
                    throw new IOException("Chyba zápisu");
                }
            }
        }
        if(!found){
            throw new IllegalArgumentException("Neznámý student");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cislo|jmeno|prijmeni|prumer\n");
        for(int i =0;i<studenti.size();i++){
            sb.append(studenti.get(i).toString()).append("\n");

        }
        return sb.toString();
    }
    
    public void saveToFile(String fileName,String comparator) throws IOException{
        switch(comparator){
            case "1" -> Collections.sort(studenti, new CompareAvg());
            case "2" -> Collections.sort(studenti, new CompareName());
            default -> Collections.sort(studenti, new CompareNumber());
        }
        try(FileWriter fw = new FileWriter(fileName,false);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(this.toString());
        }catch(IOException e){
            throw new IOException("Chyba zápisu");
        }
    }
}
