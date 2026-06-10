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
public class CompareName implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        String jm1=o1.getPrijmeni()+o1.getJmeno();
        String jm2=o2.getPrijmeni()+o2.getJmeno();
        return jm1.compareTo(jm2);
    }
}
