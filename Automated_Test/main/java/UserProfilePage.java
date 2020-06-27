import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {
    private WebDriver driver;
    private By realName = By.id("nickname");
    private By username = By.id("username");
    private By bio = By.id("bio-picker");
    private By cancelButton = By.className("_mme1yf7");
    private By avatar = By.className("avatar-pic");
    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
    }



    public String getRealName(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nickname")));
         return driver.findElement(realName).getAttribute("value");
    }
    public String getBio(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bio-picker")));
        String _bio =  driver.findElement(bio).getText();
        return _bio;
    }
    public String getUsername(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        return driver.findElement(username).getAttribute("value");
    }
    public boolean clickCancel(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_mme1yf7")));
        WebElement element = driver.findElement(cancelButton);
        boolean button =  element.isDisplayed();
        element.click();
        return button;
    }
    public boolean clickAvatar(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-pic")));
        WebElement a = driver.findElement(avatar);
        return a.isDisplayed();
    }
}
