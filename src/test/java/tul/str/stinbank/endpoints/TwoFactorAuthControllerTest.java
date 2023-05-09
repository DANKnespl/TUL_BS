/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.endpoints;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import tul.str.stinbank.definedClasses.User;
import tul.str.stinbank.NewMain;
/**
 *
 * @author Tommy
 */

@RunWith(SpringRunner.class)
@WebMvcTest(TwoFactorAuthController.class)
public class TwoFactorAuthControllerTest {
    @Autowired
    MockMvc mockMvc;
    
    @Mock
    private TwoFactorAuthController tfaController;

    @Test
    public void testCheckFactor() throws Exception {
        User user = new User("name","surname","password","test@example.com",null);
        NewMain.setUsers(new ArrayList<>(Arrays.asList(user)));
        user.setFactorKey("123456");
        mockMvc.perform(get("/2FA")
            .param("userID", "0")
            .param("FKey", "123456"))
            .andExpect(status().isOk())
            .andExpect(content().string("true"));
        
        mockMvc.perform(get("/2FA")
            .param("userID", "0")
            .param("FKey", "123455"))
            .andExpect(status().isOk())
            .andExpect(content().string("false"));
        
        mockMvc.perform(get("/2FA")
            .param("userID", "10")
            .param("FKey", "123456"))
            .andExpect(status().isOk())
            .andExpect(content().string("false"));
        
        mockMvc.perform(get("/2FA")
            .param("userID", "z")
            .param("FKey", "123456"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testGenerate2FA() throws Exception {
        User user = new User("name","surname","password","test@example.com",null);
        NewMain.setUsers(new ArrayList<>(Arrays.asList(user)));
        when(tfaController.generate2FA(any(User.class))).thenCallRealMethod();

        User result = tfaController.generate2FA(user);
        assert(result.getFactorKey() != null);
    }
}
