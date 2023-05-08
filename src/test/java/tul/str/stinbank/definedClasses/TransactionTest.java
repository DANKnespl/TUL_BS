/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.definedClasses;

import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Tommy
 */
public class TransactionTest {
    @Test
    public void testConstructorWithDateString() throws ParseException {
        Transaction t = new Transaction(100.0f, "2022-01-01T12:00:00", "USD");
        assertEquals("2022-01-01T12:00:00", t.getDate());
        assertEquals(100.0f, t.getAmount(), 0.01);
        assertEquals("USD", t.getAbr());
    }

    @Test
    public void testConstructorWithoutDateString() {
        Transaction t = new Transaction(200.0f, "EUR");
        assertNotNull(t.getDate());
        assertEquals(200.0f, t.getAmount(), 0.01);
        assertEquals("EUR", t.getAbr());
    }

    @Test
    public void testToString() throws ParseException {
        Transaction t = new Transaction(300.0f, "2022-01-01T12:00:00", "USD");
        assertEquals("2022-01-01T12:00:00 | 300.0 USD", t.toString());
    }
}
