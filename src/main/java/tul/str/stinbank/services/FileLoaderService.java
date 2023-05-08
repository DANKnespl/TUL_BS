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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import tul.str.stinbank.definedClasses.Account;
import tul.str.stinbank.definedClasses.Currency;
import tul.str.stinbank.definedClasses.Transaction;
import tul.str.stinbank.definedClasses.User;

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
        ArrayList<Currency> currencies = new ArrayList();
        currencies.add(new Currency(1,"CZK",1));
        Scanner sc;
        try{
            sc = new Scanner(readFromBlob(filePath));
        }catch(Exception e){
            return currencies;
        }
        Scanner sData;
        try{
            sc.nextLine();
            sc.nextLine();    
        }catch(NoSuchElementException e){}
        String tmp;
        while(sc.hasNextLine()){
            tmp=sc.nextLine();
            sData=new Scanner(tmp).useDelimiter("\\|");
            sData.useLocale(new Locale("cs", "CZ"));
            sData.next();
            sData.next();
            try{
                Currency curr = new Currency(sData.nextInt(),sData.next(),sData.nextFloat());
                currencies.add(curr);
            }catch(Exception e){}
        }
        return currencies;
    }
    
    public static ArrayList loadAccounts(String filePath,String transFilePath,ArrayList<Currency> currencies) {
        ArrayList<Account> accounts = new ArrayList();
        Scanner sc;
        try{
            sc = new Scanner(readFromBlob(filePath));
        }catch(Exception e){
            return accounts;
        }
        Scanner sData;
        String tmp;
        while(sc.hasNextLine()){
            ArrayList<Transaction> history;
            boolean add = true;
            tmp=sc.nextLine();
            sData=new Scanner(tmp).useDelimiter("\\|");
            String number = sData.next();
            ArrayList<Currency> AccCurrs = new ArrayList();
            ArrayList<Float> AccValues = new ArrayList();
            while (sData.hasNext()){
                float money;    
                try{
                    money = sData.nextFloat();
                }catch(InputMismatchException ime){
                    add = false;
                    break;
                }
                String currency = sData.next();
                Currency curr = strToCurrency(currency,currencies);   
                if(curr != null && add){
                    AccValues.add(money);
                    AccCurrs.add(curr);
                }
            }
            history = loadTransactions(number,transFilePath);
            if (add){
                Account acc = new Account(number,AccValues,AccCurrs,history);
                accounts.add(acc);
            }
        }
        return accounts;
    }

    private static ArrayList<Transaction> loadTransactions(String number,String filePath){
        ArrayList<Transaction> trans= new ArrayList();
        Scanner sc;
        try{
            sc = new Scanner(readFromBlob(filePath));
        }catch(Exception e){
            return trans;
        }
        String tmp;
        Scanner sData;
        while(sc.hasNextLine()){
            tmp = sc.nextLine();
            sData=new Scanner(tmp).useDelimiter("\\|");
            while(sData.hasNext()){
                if (number.equals(sData.next())){
                    try{
                        String date = sData.next();
                        float value = sData.nextFloat();
                        String abr = sData.next();
                        Transaction tr = new Transaction(value,date,abr);
                        trans.add(tr);
                    }catch(ParseException e){
                        break;
                    }
                }
            }
        }
        return trans;
    }
    
    public static ArrayList loadUsers(String filePath,ArrayList<Account> accounts) {
        ArrayList<User> users = new ArrayList();
        Scanner sc;
        try{
            sc = new Scanner(readFromBlob(filePath));
        }catch(Exception e){
            return users;
        }
        Scanner sData;
        String tmp;
        while(sc.hasNextLine()){
            tmp = sc.nextLine();
            sData = new Scanner(tmp).useDelimiter("\\|");
            sData.useLocale(new Locale("cs", "CZ"));
            User user = new User(sData.next(),sData.next(),sData.next(),sData.next(),findAcc(accounts,sData.next()));
            users.add(user);
        }   
        return users;
    }
    
    static Currency strToCurrency(String currency, ArrayList<Currency> currencies){
        Currency curr = null;
            for(int i = 0;i< currencies.size();i++){
                if(currencies.get(i).getAbr().equals(currency)){
                    curr = currencies.get(i);
                    break;
                }
            }
        return curr;
    }
    
    private static Account findAcc(ArrayList<Account> accounts,String accNumber){
        for(int i = 0;i<accounts.size();i++){
            if (accounts.get(i).getNumber().equals(accNumber)) {
                return accounts.get(i);
            }
        }
        return null;
    }
}
