/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.endpoints;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tul.str.stinbank.app.NewMain;
import tul.str.stinbank.definedClasses.User;
import tul.str.stinbank.services.EmailService;

/**
 *
 * @author Tommy
 */
@RestController
public class TwoFactorAuthController {
    
    @CrossOrigin()
    @RequestMapping("/2FA")
    public boolean checkFactor(int userID, String FKey){
        ArrayList<User> users=NewMain.getUsers();
        if (userID >= users.size()){
            return false;
        }
        return users.get(userID).getFactorKey() == null ? FKey == null : users.get(userID).getFactorKey().equals(FKey);
    }

    public User generate2FA(User user){
        try{
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            Random rand = new Random();
            int length = 6;
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                sb.append(characters.charAt(rand.nextInt(characters.length())));
            }
            user.setFactorKey(sb.toString());
            EmailService.sendEmail(user.getEmail(), sb.toString());
        }catch(Exception e){
            user.setFactorKey(user.getPass());
        }
        return user;
    }
}
