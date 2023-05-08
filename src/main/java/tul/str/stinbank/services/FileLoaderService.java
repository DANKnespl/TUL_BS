/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.services;

import com.google.auth.oauth2.GoogleCredentials;
import java.util.ArrayList;
import tul.str.stinbank.definedClasses.Account;
import tul.str.stinbank.definedClasses.Currency;
import tul.str.stinbank.definedClasses.Transaction;

/**
 *
 * @author Tommy
 */
public class FileLoaderService {
    private static GoogleCredentials credentials;
    public static void FLSSetup(){
        throw new UnsupportedOperationException();
    }

    public static String readFromBlob(String fileName){
        throw new UnsupportedOperationException();
    }
        
    public static ArrayList loadCurrencies(String filePath) {
        throw new UnsupportedOperationException();
    }
    
    public static ArrayList loadAccounts(String filePath,String transFilePath,ArrayList<Currency> currencies) {
        throw new UnsupportedOperationException();
    }

    private static ArrayList<Transaction> loadTransactions(String number,String filePath){
        throw new UnsupportedOperationException();
    }
    
    static Currency strToCurrency(String currency, ArrayList<Currency> currencies){
        throw new UnsupportedOperationException();
    }
    
    public static ArrayList loadUsers(String filePath,ArrayList<Account> accounts) {
        throw new UnsupportedOperationException();
    }
    private static Account findAcc(ArrayList<Account> accounts,String accNumber){
        throw new UnsupportedOperationException();
    }
}
