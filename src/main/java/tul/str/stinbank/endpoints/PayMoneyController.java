/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.endpoints;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tul.str.stinbank.NewMain;
import tul.str.stinbank.definedClasses.Account;
import tul.str.stinbank.definedClasses.Currency;
import tul.str.stinbank.definedClasses.User;
import tul.str.stinbank.services.FileSaverService;

/**
 *
 * @author Tommy
 */
@RestController
public class PayMoneyController {
    @CrossOrigin()
    @RequestMapping("/pay")
    public String payMoney(float amount, String abr, int userID){
        try{
            ArrayList<User> users=NewMain.getUsers();
            ArrayList<Currency> currs=NewMain.getCurrencies();
            ArrayList<Account> accounts = NewMain.getAccounts();
            Account acc = users.get(userID).getAccount();

            if(abr.equals("XXX")){
                Random rd = new Random();
                int currID = rd.nextInt(currs.size());
                amount =rd.nextFloat(100, 4900)/currs.get(currID).getCZK();
                abr = currs.get(currID).getAbr();
            }
            for (int i = 0;i<currs.size();i++){
                if (currs.get(i).getAbr() == null ? abr == null : currs.get(i).getAbr().equals(abr)){
                    if(acc.payMoney(amount, currs.get(i))){
                        FileSaverService.saveAccounts(accounts,"target/classes/data/Accounts.txt");
                        return "uspesne provedeno";
                    }else{
                        return "nedostatek financi";
                    }
                }
            }
        }catch(IOException e){
            try {
                FileSaverService.saveToFile("logs.txt", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+" IOException - PayMoneyController\n", true);
            } catch (IOException ex) {
                Logger.getLogger(AddMoneyController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "platba nemohla byt provedena";
        }
        return "Nenalezena mena";
    }
}
