import com.google.common.io.Files;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class Search_Results_Test extends BaseTest {
    @Test
    public void successfulSearch() {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.sucessfulLogin("haigaz_soghmonian@edu.aua.am","helloWorld+1");
        Search_Results search_results = userPage.search_courses();
        ArrayList<String> elements = search_results.getCaptions();
        assertAll(
                ()-> {
                    for (String element : elements) {
                         assertTrue(element.toLowerCase().contains("combinatorics") || element.toLowerCase().contains("combi"));
                    }
                },
                ()-> assertEquals("Search", search_results.check_search_button()),
                ()-> assertTrue(search_results.search_bar_isPresent()),
                ()-> assertTrue(search_results.checkHeaders()));
    }
}