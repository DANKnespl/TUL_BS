/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Tommy
 */
public class EmailServiceTest {
    
    @Test
    public void testSendEmailSuccess() {
        String to = "test@example.com";
        String code = "123456";
        
        assertDoesNotThrow(() -> {
            EmailService.sendEmail(to, code);
        });
    }
}
