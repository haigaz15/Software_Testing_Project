import Util.EventReporter;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    static WebDriver driver;
    static UserPage userPage;
    @BeforeClass
    public static void setUp(){
        System.setProperty("WebDriver.chrome.driver","recources/chromeDriver");
        driver = new EventFiringWebDriver(new ChromeDriver());
        ((EventFiringWebDriver) driver).register(new EventReporter());
        driver.get("https://www.khanacademy.org/login?continue=%2F");
        userPage = new UserPage(driver);
    }
    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenShot,new File("src/Resource" , "failedTest" + ".png" ));
            }catch (IOException f){
                e.printStackTrace();
            }
        }
    };
/*    @AfterClass
    public void quit(){
        driver.quit();
    }*/
}
