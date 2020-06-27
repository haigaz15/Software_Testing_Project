import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserPage {
    private WebDriver driver;
    private By MycoursesHeader = By.className("_xutnbcb");
    private By MyStuffHeader = By.className("_18undph9");
    private By UserHeader = By.className("_o77ufew");
    private By startButton = By.cssSelector("._c74hcox");
    private By profile_page = By.cssSelector("._1cy26d5u");
    // I used the xpath for these two elements instead of the other type because the elements where hard to locate
    //  and they kept giving errors even when I implemented Implicit or explicit waits.
    private By searchBar = By.xpath("//*[@id=\"app-shell-root\"]/div/div[1]/nav/div/div[1]/div[2]/a");
    private By searchBarclick = By.xpath("//*[@id=\"app-shell-root\"]/div/div[1]/nav/div/span/div/div/div/form/div/input");

    public UserPage(WebDriver driver){
        this.driver = driver;
    }
    public String myUserHeader() {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_o77ufew")));
        return driver.findElement(UserHeader).getText();
    }
    public String mycourseHeader()  {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_xutnbcb")));
        return driver.findElement(MycoursesHeader).getText();
    }
    public String myStuffHeader()  {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_18undph9")));
        return driver.findElement(MyStuffHeader).getText();
    }
    public String getStartButton()  {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._c74hcox")));
        return driver.findElement(startButton).getText();
    }

    public UserProfilePage enterUserProfile() {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._g20yn58")));
        driver.findElement(profile_page).click();
        return new UserProfilePage(driver);
    }
    public Search_Results search_courses() {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-shell-root\"]/div/div[1]/nav/div/div[1]/div[2]/a")));
        driver.findElement(searchBar).click();
        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-shell-root\"]/div/div[1]/nav/div/span/div/div/div/form/div/input")));
        driver.findElement(searchBarclick).sendKeys("combinatorics",Keys.ENTER);
        return new Search_Results(driver);
    }
}
