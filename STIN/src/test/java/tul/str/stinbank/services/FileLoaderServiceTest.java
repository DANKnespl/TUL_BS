/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tul.str.stinbank.definedClasses.Account;
import tul.str.stinbank.definedClasses.Currency;
import tul.str.stinbank.definedClasses.Transaction;
import tul.str.stinbank.definedClasses.User;

/**
 *
 * @author Tommy
 */
public class FileLoaderServiceTest {
    
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
        
        
        Account account1 = new Account("123", money, currs, history1);
        Account account2 = new Account("456", money, currs, history1);
        accounts.add(account1);
        accounts.add(account2);
    }
    
    
    @Test
    public void testLoadAccount(){
        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency(1,"USD", 23.50f));

        ArrayList<Account> accounts = FileLoaderService.loadAccounts("target/classes/data/testing/SingleAccount.txt","target/classes/data/testing/SAT.txt", currencies);
        assertEquals(1, accounts.size());

        Account acc = accounts.get(0);
        assertEquals("123456", acc.getNumber());
        assertEquals(1, acc.getMoney().size());
        assertEquals(100.0f, acc.getMoney().get(0), 0.01f);
        assertEquals(currencies.get(0).getAbr(), acc.getCurrencies().get(0).getAbr());
        assertEquals(1, acc.getHistory().size());
        
        accounts = FileLoaderService.loadAccounts("target/classes/data/InvalidPath.txt","target/classes/data/testing/SAT.txt", currencies);
        assertEquals(0, accounts.size());
    }
    
    @Test
    public void testStrToCurrency(){
        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency(1, "CZK", 1));
        currencies.add(new Currency(2, "USD", 23.5f));
        currencies.add(new Currency(3, "EUR", 27.5f));
        Currency expected = currencies.get(1);
        Currency actual = FileLoaderService.strToCurrency("USD", currencies);
        assertEquals(expected, actual);
        
        
        expected = null;
        actual = FileLoaderService.strToCurrency("ABC", currencies);
        assertEquals(expected, actual);
        
        currencies = new ArrayList<>();
        actual = FileLoaderService.strToCurrency("USD", currencies);
        assertEquals(expected, actual);
        
    }
    
    @Test
    public void testLoadCurrencies(){
        assertEquals(1, FileLoaderService.loadCurrencies("invalid_file_path.txt").size());
        
        ArrayList<Currency> expected = new ArrayList<>();
        expected.add(new Currency(1, "CZK", 1));
        expected.add(new Currency(1, "USD", 23.5f));
        expected.add(new Currency(1, "EUR", 27.5f));
        ArrayList<Currency> out = FileLoaderService.loadCurrencies("target/classes/data/testing/fakeCurrencies1.txt");
        assertEquals(expected.get(0).getAbr(), out.get(0).getAbr());
        assertEquals(expected.get(1).getAbr(), out.get(1).getAbr());
        assertEquals(expected.get(2).getAbr(), out.get(2).getAbr());
        
        expected = new ArrayList<>();
        expected.add(new Currency(1, "CZK", 1));
        out = FileLoaderService.loadCurrencies("target/classes/data/testing/fakeCurrencies2.txt");
        assertEquals(expected.get(0).getAbr(), out.get(0).getAbr());
        assertEquals(1,out.size());
        
        out = FileLoaderService.loadCurrencies("target/classes/data/testing/fakeCurrencies3.txt");
        assertEquals(expected.get(0).getAbr(), out.get(0).getAbr());
        assertEquals(1,out.size());
    }

    @Test
    public void testLoadUsers() throws FileNotFoundException {
        ArrayList<User> result = FileLoaderService.loadUsers("target/classes/data/testing/fakeUsers2.txt", accounts);
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Doe", result.get(0).getSurname());
        assertEquals("johndoe@example.com", result.get(0).getEmail());
        assertEquals("123", result.get(0).getAccount().getNumber());
        assertEquals("Jane", result.get(1).getName());
        assertEquals("Smith", result.get(1).getSurname());
        assertEquals("janesmith@example.com", result.get(1).getEmail());
        assertEquals("456", result.get(1).getAccount().getNumber());
        
        result = FileLoaderService.loadUsers("target/classes/data/testing/Missing.txt", accounts);
        assertEquals(0, result.size());
        
        result = FileLoaderService.loadUsers("target/classes/data/testing/fakeUsersEmpty.txt", accounts);
        assertEquals(0, result.size());
        
        result = FileLoaderService.loadUsers("target/classes/data/testing/fakeUsers.txt", accounts);
        assertEquals(2, result.size());
        assertNull(result.get(0).getAccount());
    }
}
