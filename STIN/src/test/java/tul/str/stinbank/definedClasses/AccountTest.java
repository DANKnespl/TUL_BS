/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.definedClasses;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Tommy
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {
    
    private Account account;

    @BeforeEach
    public void setUp() {
        ArrayList<Float> money = new ArrayList<>();
        money.add(1000f);  // set initial balance for USD
        money.add(500f);   // set initial balance for EUR
        money.add(1000f);
        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency(1,"USD", 25f));
        currencies.add(new Currency(1,"EUR", 20f));
        currencies.add(new Currency(1,"GBP", 1f));
        ArrayList<Transaction> history = new ArrayList<>();
        account = new Account("123456789", money, currencies, history);
    }

    @Test
    public void testGetNumber() {
        assertEquals("123456789", account.getNumber());
    }

    @Test
    public void testSetNumber() {
        account.setNumber("987654321");
        assertEquals("987654321", account.getNumber());
    }

    @Test
    public void testGetHistory() {
        assertTrue(account.getHistory().isEmpty());
    }

    @Test
    public void testSetHistory() {
        Transaction tr = new Transaction(100f, "USD");
        account.setHistory(tr);
        assertFalse(account.getHistory().isEmpty());
        assertEquals(tr, account.getHistory().get(0));
    }

    @Test
    public void testPayMoney() {
        Currency currTest = new Currency(1,"CZK",1);
        try{
        assertTrue(account.payMoney(500f, 1)==0);
        assertEquals(0f, account.getMoney().get(1), 0);
        assertEquals(1000f, account.getMoney().get(0), 0);
        assertEquals(1, account.payMoney(2000f, 1));
        assertEquals(0f, account.getMoney().get(1), 0);
        assertEquals(1000f, account.getMoney().get(0), 0);
        assertTrue(account.payMoney(10f, 0)==0);
        assertEquals(0f, account.getMoney().get(1), 0);
        assertEquals(990f, account.getMoney().get(0), 0);
        assertTrue(account.payMoney(-20, 1)==2);
        
        assertTrue(account.payMoney(10000, account.getCurrencies().get(0))==1);
        assertTrue(account.payMoney(1, account.getCurrencies().get(0))==0);
        assertTrue(account.payMoney(100000000, account.getCurrencies().get(1))==1);
        assertTrue(account.payMoney(100000000, currTest)==1);
        assertTrue(account.payMoney(1090,account.getCurrencies().get(2))==0);
        assertEquals(-99f, account.getMoney().get(2), 0);
        assertTrue(account.payMoney(1090,account.getCurrencies().get(2))==1);
        
        }catch(IOException e){
        }
    }

    @Test
    public void testAddMoney() {
        Currency currTest = new Currency(1,"CZK",1);
        try{
        assertTrue(account.addMoney(200f, 0));
        assertEquals(1200f, account.getMoney().get(0), 0);
        assertEquals(500f, account.getMoney().get(1), 0);
        assertFalse(account.addMoney(-100f, 1));
        assertEquals(1200f, account.getMoney().get(0), 0);
        assertEquals(500f, account.getMoney().get(1), 0);
        assertFalse(account.addMoney(-20, 1));
        
        assertTrue(account.addMoney(10000, account.getCurrencies().get(0)));
        assertTrue(account.addMoney(1, account.getCurrencies().get(0)));
        assertTrue(account.addMoney(100000000, currTest));
        assertTrue(account.addMoney(1, currTest));
        }catch(IOException e){
        }
    }

    @Test
    public void testToString() {
        String expected = "123456789\n" +
                "USD 1000.0\n" +
                "EUR 500.0\n" +
                "GBP 1000.0\n";
        assertEquals(expected, account.toString());
    }

    @Test
    public void testTransactionOut() {
        Transaction tr1 = new Transaction(100f, "USD");
        Transaction tr2 = new Transaction(-50f, "EUR");
        account.setHistory(tr1);
        account.setHistory(tr2);
        String expected = tr2.getDate()+" | -50.0 EUR\n"+ tr1.getDate()+" | 100.0 USD\n";
        assertEquals(expected, account.TransactionOut());
    }
}
