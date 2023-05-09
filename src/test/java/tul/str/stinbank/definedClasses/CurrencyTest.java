/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.definedClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Tommy
 */
public class CurrencyTest {
    
    @Test
    public void testGetAbr() {
        Currency c = new Currency(1, "USD", 23.5f);
        assertEquals("USD", c.getAbr());
    }

    @Test
    public void testGetValue() {
        Currency c = new Currency(1, "USD", 23.5f);
        assertEquals(1, c.getValue());
    }

    @Test
    public void testGetCZK() {
        Currency c = new Currency(1, "USD", 23.5f);
        assertEquals(23.5f, c.getCZK(), 0.01);
    }

    @Test
    public void testSetAbr() {
        Currency c = new Currency(1, "USD", 23.5f);
        c.setAbr("EUR");
        assertEquals("EUR", c.getAbr());
    }

    @Test
    public void testSetValue() {
        Currency c = new Currency(1, "USD", 23.5f);
        c.setValue(2);
        assertEquals(2, c.getValue());
    }

    @Test
    public void testSetCZK() {
        Currency c = new Currency(1, "USD", 23.5f);
        c.setCZK(25.0f);
        assertEquals(25.0f, c.getCZK(), 0.01);
    }

    @Test
    public void testTransform() {
        Currency c1 = new Currency(1, "USD", 23.5f);
        Currency c2 = new Currency(1, "EUR", 27.5f);
        float result = c1.Transform(100.0f, c2);
        assertEquals(117.02f, result, 0.01);
        result = c2.Transform(100.0f, c1);
        assertEquals(85.45f, result, 0.01);
        result = c2.Transform(100.0f, c2);
        assertEquals(100.0f, result, 0.01);
    }

}
