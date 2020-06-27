import com.google.common.io.Files;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


import static org.junit.Assert.*;
public class Invalid_Test extends BaseTest {
    @Test
    public void unsuccessfulTest() {
        LoginPage loginPage = new LoginPage(driver);
        String alertMessage = loginPage.unsucessfullLogin("haigaz_soghmonian@edu.aua.am","helloWorld+");
        assertEquals(alertMessage,"Your login or password is incorrect.");
    }
}
