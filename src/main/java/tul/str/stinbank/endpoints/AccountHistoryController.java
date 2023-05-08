/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.endpoints;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tul.str.stinbank.app.NewMain;
import tul.str.stinbank.definedClasses.User;

/**
 *
 * @author Tommy
 */
@RestController
public class AccountHistoryController {
    
    @CrossOrigin()
    @RequestMapping("/getTransactions")
    public String getTransactions(int userID){
        User user= (User) NewMain.getUsers().get(userID);
        return user.getAccount().TransactionOut();
    }
}
