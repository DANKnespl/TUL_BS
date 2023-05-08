/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.definedClasses;


/**
 *
 * @author Tommy
 */
public class Currency {
    private String abr;
    private int value;
    private float CZK;

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public float getCZK() {
        return CZK;
    }

    public void setCZK(float CZK) {
        this.CZK = CZK;
    }

    public Currency(int value, String abr, float CZK) {
        this.abr = abr;
        this.value = value;
        this.CZK = CZK;
    }
    
    public float Transform(float money,Currency curr){
        throw new UnsupportedOperationException();
    }
    
}
