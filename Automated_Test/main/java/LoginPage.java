import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private  WebDriver driver;
    private  By usernameField = By.id("uid-identity-text-field-0-email-or-username");
    private  By passwordField = By.id("uid-identity-text-field-1-password");
    // I used the absolute xpath because whenever I try other elements a small windows pops up preventing me from executing the automated log In
    private  By loginButton = By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/div[3]/section[2]/div/div/div[2]/button");
    private By alertMessage = By.cssSelector("._6fw40cu");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void  LogIn (String username, String password)  {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }
    public void click_login (){
        driver.findElement(loginButton).click();
    }
    public UserPage sucessfulLogin(String username, String password){
        LogIn(username,password);
        click_login();
        return new UserPage(driver);
    }

    public String unsucessfullLogin(String username, String password) {
        LogIn(username,password);
        click_login();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("._6fw40cu"),"Your login or password is incorrect."));
        return driver.findElement(alertMessage).getText();
    }
}
