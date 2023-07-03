/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package knespl.porovnavani;

import java.util.Comparator;
import knespl.Skola.Student;

/**
 *
 * @author Tommy
 */
public class CompareNumber implements Comparator<Student>{
    
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCislo(),o2.getCislo());
    }
}
