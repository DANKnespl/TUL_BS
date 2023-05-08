/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.definedClasses;

import java.util.ArrayList;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Tommy
 */
public class UserTest {
    
    static ArrayList<Currency> currencies = new ArrayList();
    static ArrayList<Float> money = new ArrayList();
    static ArrayList<Transaction> history = new ArrayList();
    
    @Before
    static void init(){
        Currency US = new Currency(1,"USD",23.5f);
        currencies.add(US);
        money.add(1000f);
    }
    
    @Test
    public void True(){
        assertEquals("1","1");
    }
    
    @Test
    public void testUserConstructor() {
        init();
        Account account = new Account("12345678", money, currencies, history);
        
        User user = new User("John", "Doe", "password123", "johndoe@example.com", account);
        assertNotNull(user);
        assertEquals("John", user.Name);
        assertEquals("Doe", user.Surname);
        assertEquals("password123", user.pass);
        assertEquals("johndoe@example.com", user.email);
        assertEquals(account, user.account);
        assertNull(user.factorKey);
    }
    
    @Test
    public void testSetAndGetFactorKey() {
        //init();
        Account account = new Account("12345678", money, currencies, history);
        
        
        User user = new User("John", "Doe", "password123", "johndoe@example.com", account);
        user.setFactorKey("1234");
        assertEquals("1234", user.getFactorKey());
    }
    
    @Test
    public void testGetAccount() {
        //init();
        Account account = new Account("12345678", money, currencies, history);
        
        User user = new User("John", "Doe", "password123", "johndoe@example.com", account);
        assertEquals(account, user.getAccount());
    }

    @Test
    public void testGetPass() {
        //init();
        Account account = new Account("12345678", money, currencies, history);
        
        User user = new User("John", "Doe", "password123", "johndoe@example.com", account);
        assertEquals("password123", user.getPass());
    }

    @Test
    public void testGetEmail() {
        //init();
        Account account = new Account("12345678", money, currencies, history);
        
        User user = new User("John", "Doe", "password123", "johndoe@example.com", account);
        assertEquals("johndoe@example.com", user.getEmail());
    }
    
    @Test
    public void testToString() {
        //init();
        Account account = new Account("12345678", money, currencies, history);
        
        User user = new User("John", "Doe", "password123", "johndoe@example.com", account);
        String expectedOutput = "John Doe\n" + account.toString();
        assertEquals(expectedOutput, user.toString());
    }
    
}
