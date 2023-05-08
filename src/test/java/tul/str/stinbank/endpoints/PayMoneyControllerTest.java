/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tul.str.stinbank.endpoints;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import tul.str.stinbank.services.FileSaverService;
import tul.str.stinbank.definedClasses.User;
import tul.str.stinbank.definedClasses.Account;
import tul.str.stinbank.definedClasses.Currency;
import tul.str.stinbank.NewMain;
import tul.str.stinbank.definedClasses.Transaction;
import tul.str.stinbank.services.FileLoaderService;

/**
 *
 * @author Tommy
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PayMoneyController.class)
public class PayMoneyControllerTest {
    @Autowired
    MockMvc mockMvc;
    //float amount, String abr, int userID
    @Test
    public void addMoney() throws Exception{
        ArrayList<Currency> actualCurrencies = FileLoaderService.loadCurrencies("target/classes/data/kurzy.txt");
        ArrayList<Account> actualAccounts = FileLoaderService.loadAccounts("target/classes/data/Accounts.txt", "target/classes/data/Transactions.txt", actualCurrencies);
        Currency c1 = new Currency(1, "CZK", 1f);
        Currency c2 = new Currency(1, "EUR", 27.5f);
        Currency c3 = new Currency(1, "USD", 23.5f);
        ArrayList<Currency> curr = new ArrayList();
        ArrayList<Currency> currMain = new ArrayList();
        
        ArrayList<Float> money = new ArrayList();
        ArrayList<Transaction> history = new ArrayList();
        curr.add(c1);
        curr.add(c2);
        currMain.add(c1);
        currMain.add(c2);
        currMain.add(c3);
        money.add(10000f);
        money.add(100f);
        Account account = new Account("testPay",money,curr,history);
        
        User user = new User("name","surname","password","test@example.com",account);
        NewMain.setAccounts(new ArrayList<>(Arrays.asList(account)));
        NewMain.setUsers(new ArrayList<>(Arrays.asList(user)));
        NewMain.setCurrencies(currMain);
        mockMvc.perform(get("/pay")
               .param("amount", "21.1")
               .param("abr", "CZK")
               .param("userID", "0"))
               .andExpect(status().isOk());
        assertEquals(account.getMoney().get(0),10000-21.1,0.01);
        mockMvc.perform(get("/pay")
               .param("amount", "10")
               .param("abr", "USD")
               .param("userID", "0"))
               .andExpect(status().isOk());
        
        mockMvc.perform(get("/pay")
               .param("amount", "10")
               .param("abr", "EUR")
               .param("userID", "0"))
               .andExpect(status().isOk());
        assertEquals(account.getMoney().get(0),10000-256.1,0.01);
        assertEquals(account.getMoney().get(1),90,0.01); 
        
        mockMvc.perform(get("/pay")
               .param("amount", "100")
               .param("abr", "AUD")
               .param("userID", "0"))
               .andExpect(status().isOk());
        assertEquals(account.getMoney().get(1),90,0.01);
        assertEquals(account.getMoney().get(0),10000-256.1,0.01);
        
        mockMvc.perform(get("/pay")
               .param("amount", "100")
               .param("abr", "EUR")
               .param("userID", "0"))
               .andExpect(status().isOk());
        assertEquals(account.getMoney().get(1),90,0.01);
        
        
        
        mockMvc.perform(get("/pay")
               .param("amount", "10")
               .param("abr", "XXX")
               .param("userID", "0"))
               .andExpect(status().isOk());
        
        if("EUR".equals(account.getHistory().get(account.getHistory().size()-1).getAbr())){
            //assertEquals(account.getMoney().get(1),80,0.01);
        }else{
            //assertNotEquals(account.getMoney().get(0),10000-256.1,0.01);
        }
        
        FileSaverService.saveAccounts(actualAccounts, "target/classes/data/Accounts.txt");
    }
}
