package tul.str.stinbank.services;

import java.io.File;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tommy
 */
public class CurrenciesFetchServiceTest {
    
    @Test
    public void testFetchCurrencies() {
        String Surl="https://www.cnb.cz/cs/financni-trhy/devizovy-trh/kurzy-devizoveho-trhu/kurzy-devizoveho-trhu/denni_kurz.txt";
        String Sfile="target/classes/data/kurzy.txt";
        CurrenciesFetchService.fetchCurrencies(Surl,Sfile);
        File file = new File(Sfile);
        assertTrue(file.exists());
        
        Surl="https://www.cnb.cz/h/kurzy-devizoveho-trhu/kurzy-devizoveho-trhu/denni_kurz.txt";
        Sfile="target/classes/foo.bar";
        CurrenciesFetchService.fetchCurrencies(Surl,Sfile);
        file = new File(Sfile);
        assertFalse(file.exists());
        
    }
}
