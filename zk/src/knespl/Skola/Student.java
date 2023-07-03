/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package knespl.Skola;

import java.util.ArrayList;

/**
 *
 * @author Tommy
 */
public class Student {
    private int cislo;
    private String jmeno;
    private String prijmeni;
    private ArrayList<Double> znamky;
    private ArrayList<Double> vahy;

    public Student(int cislo, String jmeno, String prijmeni) {
        this.cislo = cislo;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.znamky = new ArrayList<Double>();
        this.vahy = new ArrayList<Double>();
    }

    @Override
    public String toString() {
        
        try{
            return String.format("%d|%s|%s|%.2f", cislo,jmeno,prijmeni,this.getPrumer());
        }catch(Exception e){
            return String.format("%d|%s|%s|", cislo,jmeno,prijmeni);
        }
    }

    void addZnamka(double znamka, double vaha) {
        znamky.add(znamka);
        vahy.add(vaha);
    }

    public int getCislo() {
        return cislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public double getPrumer() throws Exception {
        double num=0;
        double denum=0;
        for(int i=0;i<znamky.size();i++){
            num+=znamky.get(i)*vahy.get(i);
            denum+=vahy.get(i);
        }
        if (denum!=0){
            return num/denum;
        }
        throw new Exception("nedostatek hodnot");
    }
    
    
    
}
