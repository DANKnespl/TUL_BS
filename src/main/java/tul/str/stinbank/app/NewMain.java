/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tul.str.stinbank.app;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import tul.str.stinbank.definedClasses.Account;
import tul.str.stinbank.definedClasses.Currency;
import tul.str.stinbank.definedClasses.User;
import tul.str.stinbank.services.CurrenciesFetchService;
import tul.str.stinbank.services.FileLoaderService;

/**
 *
 * @author Tommy
 */
public class NewMain {

    private static ArrayList<Currency> Currencies = new ArrayList();
    private static ArrayList<Account> Accounts = new ArrayList();
    private static ArrayList<User> Users = new ArrayList();
    
    public static void main(String[] args) throws IOException{
        CurrenciesFetchService.fetchCurrencies("https://www.cnb.cz/cs/financni-trhy/devizovy-trh/kurzy-devizoveho-trhu/kurzy-devizoveho-trhu/denni_kurz.txt","target/classes/data/kurzy.txt");
        Currencies = FileLoaderService.loadCurrencies("target/classes/data/kurzy.txt");
        Accounts = FileLoaderService.loadAccounts("target/classes/data/Accounts.txt","target/classes/data/Transactions.txt",Currencies);
        Users = FileLoaderService.loadUsers("target/classes/data/Users.txt",Accounts);
        
        SpringApplication.run(NewMain.class, args);
    }
    
    public static ArrayList getUsers(){
        return Users;
    }
    public static ArrayList getAccounts(){
        return Accounts;
    }
    public static ArrayList getCurrencies(){
        return Currencies;
    }
}
