/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.endpoints;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tul.str.stinbank.definedClasses.User;

/**
 *
 * @author Tommy
 */
@RestController
public class TwoFactorAuthController {
    
    @CrossOrigin()
    @RequestMapping("/2FA")
    public boolean checkFactor(int userID, String FKey){
        throw new UnsupportedOperationException();
    }

    public User generate2FA(User user){
        throw new UnsupportedOperationException();
    }
}
