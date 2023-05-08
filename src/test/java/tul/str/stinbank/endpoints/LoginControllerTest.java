/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.endpoints;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import tul.str.stinbank.NewMain;
import tul.str.stinbank.definedClasses.User;

/**
 *
 * @author Tommy
 */

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //@MockBean
    //private NewMain newMain;

    @Test
    public void testSuccessfulLogin() throws Exception {
        // Arrange
        User user = new User("name","surname","password","test@example.com",null);
        NewMain.setUsers(new ArrayList<>(Arrays.asList(user)));
        int expectedIndex = 0;

        // Act and Assert
        mockMvc.perform(get("/login")
                .param("email", user.getEmail())
                .param("password", user.getPass()))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedIndex)));
    }

    @Test
    public void testIncorrectEmail() throws Exception {
        // Arrange
        User user = new User("name","surname","password","test@example.com",null);
        NewMain.setUsers(new ArrayList<>(Arrays.asList(user)));
        String incorrectEmail = "wrong@example.com";

        // Act and Assert
        mockMvc.perform(get("/login")
                .param("email", incorrectEmail)
                .param("password", user.getPass()))
                .andExpect(status().isOk())
                .andExpect(content().string("-1"));
    }

    @Test
    public void testIncorrectPassword() throws Exception {
        // Arrange
        User user = new User("name","surname","password","test@example.com",null);
        NewMain.setUsers(new ArrayList<>(Arrays.asList(user)));
        String incorrectPassword = "wrongPassword";

        // Act and Assert
        mockMvc.perform(get("/login")
                .param("email", user.getEmail())
                .param("password", incorrectPassword))
                .andExpect(status().isOk())
                .andExpect(content().string("-1"));
    }

    @Test
    public void testNullEmail() throws Exception {
        // Arrange
        User user = new User("name","surname","password","test@example.com",null);
        NewMain.setUsers(new ArrayList<>(Arrays.asList(user)));
        
        // Act and Assert
        mockMvc.perform(get("/login")
                .param("email", (String) null)
                .param("password", user.getPass()))
                .andExpect(status().isOk())
                .andExpect(content().string("-1"));
    }

    @Test
    public void testNullPassword() throws Exception {
        // Arrange
        User user = new User("name","surname","password","test@example.com",null);
        NewMain.setUsers(new ArrayList<>(Arrays.asList(user)));
        
        // Act and Assert
        mockMvc.perform(get("/login")
                .param("email", user.getEmail())
                .param("password", (String) null))
                .andExpect(status().isOk())
                .andExpect(content().string("-1"));
    }
}
