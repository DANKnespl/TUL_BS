/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.services;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import tul.str.stinbank.endpoints.AddMoneyController;

/**
 *
 * @author Tommy
 */
public class CurrenciesFetchService {
    public static void fetchCurrencies(String url,String file){
        try {
            downloadUsingStream(url, file);
        } catch (IOException e) {
            try {
                FileSaverService.saveToFile("logs.txt", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+" IOException - fetchCurrency\n", true);
            } catch (IOException ex) {
                Logger.getLogger(AddMoneyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void downloadUsingStream(String urlStr, String file) throws MalformedURLException, IOException{
        URL url = new URL(urlStr);
        String currencies="";
        try(
            BufferedInputStream bis = new BufferedInputStream(url.openStream());){
            byte[] buffer = new byte[1024];
            int count;
            while((count = bis.read(buffer,0,1024)) != -1)
            {
                currencies+= new String(buffer, 0, count);
            }
        }
        FileSaverService.saveToFile(file, currencies, false);
    }
}
