/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.services;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Tommy
 */
public class CurrenciesFetchService {
    public static void fetchCurrencies(String url,String file){
        try {
            downloadUsingStream(url, file);
        } catch (Exception e) {}
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
        FileSaverService.saveToFile("kurzy.txt", currencies, false);
        FileSaverService.saveToFile(file, currencies, false);
    }
}
