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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
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
        try{
            credentials = GoogleCredentials.fromStream(new FileInputStream("target/classes/stinbanking-22f19bfc0a3a.json"));
        }catch(IOException e){
            credentials = null;
        }
    }
    
    private static void saveToBlob(String fileName, String text) throws IOException{
        FSSSetup();
        Storage storage;
        if (credentials == null){
            storage = StorageOptions.getDefaultInstance().getService();
        }else{
            storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        }
        BlobId blobId = BlobId.of("stinbnkdata", fileName);
        Blob blob = storage.get(blobId);
        try (WritableByteChannel channel = blob.writer()) {
            ByteBuffer buffer = ByteBuffer.wrap(text.getBytes());
            channel.write(buffer);
        }
    }
    
    public static void saveAccounts(ArrayList<Account> accounts,String path) throws IOException{
        StringBuilder sb = new StringBuilder();
        for(int j = 0;j<accounts.size();j++){
            Account account = accounts.get(j);
            sb.append(account.getNumber());
            for (int i = 0;i<account.getCurrencies().size();i++){
                sb.append("|").append(account.getMoney().get(i)).append("|").append(account.getCurrencies().get(i).getAbr());
            }
        sb.append("\n");
        }
        FileSaverService.saveToFile(path,sb.toString(),false);
    }
    
    public static void saveTransaction(String AccountNumber, Transaction transaction,String path) throws IOException{
        StringBuilder sb = new StringBuilder();
        sb.append(AccountNumber).append("|").append(transaction.getDate()).append("|").append(transaction.getAmount()).append("|").append(transaction.getAbr()).append("\n");
        FileSaverService.saveToFile(path,sb.toString(),true);
    }
    
    public static void saveToFile(String path,String text,boolean append) throws UnsupportedEncodingException, IOException{
        if (append){
            text=FileLoaderService.readFromBlob(path)+text;
            saveToBlob(path,text);
        }else{
            saveToBlob(path,text);
        }
    }
}
