/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
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
        try{
            credentials = GoogleCredentials.fromStream(new FileInputStream("target/classes/stinbanking-22f19bfc0a3a.json"));
        }catch(Exception e){
            credentials = null;
        }
    }

    public static String readFromBlob(String fileName) throws UnsupportedEncodingException{
        FLSSetup();
        Storage storage;
        if (credentials == null){
            storage = StorageOptions.getDefaultInstance().getService();
        }else{
            storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        }
        Blob blob = storage.get(BlobId.of("stinbnkdata", fileName));
        byte[] content = blob.getContent();
        return new String(content, "UTF-8");
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
