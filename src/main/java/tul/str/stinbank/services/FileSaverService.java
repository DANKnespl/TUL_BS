/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.services;

import com.google.auth.oauth2.GoogleCredentials;
import java.util.ArrayList;
import tul.str.stinbank.definedClasses.Account;
import tul.str.stinbank.definedClasses.Transaction;

/**
 *
 * @author Tommy
 */
public class FileSaverService {
    private static GoogleCredentials credentials;
    public static void FSSSetup(){
        throw new UnsupportedOperationException();
    }
    
    public static void saveAccounts(ArrayList<Account> accounts,String path){
        throw new UnsupportedOperationException();
    }
    
    public static void saveTransaction(String AccountNumber, Transaction transaction,String path){
        throw new UnsupportedOperationException();
    }
    
    
    private static void saveToBlob(String fileName, String text){
        throw new UnsupportedOperationException();
    }
    
    public static void saveToFile(String path,String text,boolean append){
        throw new UnsupportedOperationException();
    }
}
