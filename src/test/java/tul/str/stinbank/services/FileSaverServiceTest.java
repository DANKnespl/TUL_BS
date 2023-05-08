/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tul.str.stinbank.definedClasses.Account;
import tul.str.stinbank.definedClasses.Currency;
import tul.str.stinbank.definedClasses.Transaction;

/**
 *
 * @author Tommy
 */
public class FileSaverServiceTest {
    
    static ArrayList<Account> accounts = new ArrayList<>();
    
    @BeforeEach
    public void init(){
        ArrayList<Currency> currs= new ArrayList();
        currs.add(new Currency(1,"CZK",1));
        currs.add(new Currency(1,"USD",23.5f));
        currs.add(new Currency(1,"EUR",27.5f));
        ArrayList<Float> money= new ArrayList();
        money.add(10f);
        money.add(0f);
        money.add(15f);
        ArrayList<Transaction> history1= new ArrayList();
        
        
        Account account1 = new Account("123456789", money, currs, history1);
        Account account2 = new Account("12345", money, currs, history1);
        accounts.add(account1);
        accounts.add(account2);
    }
    
    
    @Test
    public void testSaveAccounts() throws IOException {
        // create some test data
        
        // call the method under test
        FileSaverService.saveAccounts(accounts,"target/classes/data/testing/fakeAcc.txt");

        // read the contents of the file and check that it matches the expected output
        try (BufferedReader reader = new BufferedReader(new FileReader("target/classes/data/testing/fakeAcc.txt"))) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            assertEquals("123456789|10.0|CZK|0.0|USD|15.0|EUR", line1);
            assertEquals("12345|10.0|CZK|0.0|USD|15.0|EUR", line2);
        }
    }

    @Test
    public void testSaveTransaction() throws IOException {
        // create some test data
        Account account = accounts.get(0);
        account.addMoney(100,0);
        // call the method under test
        FileSaverService.saveTransaction(account.getNumber(), account.getHistory().get(0),"target/classes/data/testing/fakeTrans.txt");

        // read the contents of the file and check that it matches the expected output
        try (BufferedReader reader = new BufferedReader(new FileReader("target/classes/data/testing/fakeTrans.txt"))) {
            String line = reader.readLine();
            assertTrue(line.contains("123456789|"));
        }
    }
}
