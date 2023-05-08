/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.endpoints;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tommy
 */
@RestController
public class LoginController {
    
    @CrossOrigin()
    @RequestMapping("/login")
    public int login(String email, String password){
        ArrayList<User> users = NewMain.Users;
        System.out.println(email+" "+password);
        for(int i=0;i<users.size();i++){
            if(email == null ? users.get(i).getEmail() == null : email.equals(users.get(i).getEmail())){
                if(password == null ? users.get(i).getPass() == null : password.equals(users.get(i).getPass())){
                    NewMain.Users.set(i,(new TFAController()).generate2FA(users.get(i)));
                    return i;
                }
            }
        }
        return -1;
    }
}