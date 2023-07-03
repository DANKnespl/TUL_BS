/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package knespl.porovnavani;

import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import knespl.Skola.Student;

/**
 *
 * @author Tommy
 */
public class CompareAvg implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        double avg1;
        double avg2;
        try {
            avg1=o1.getPrumer();
        } catch (Exception ex) {
            avg1=Double.POSITIVE_INFINITY;
        }
        try {
            avg2=o2.getPrumer();
        } catch (Exception ex) {
            avg2=Double.POSITIVE_INFINITY;
        }
        return Double.compare(avg1, avg2);
    }
    
}
