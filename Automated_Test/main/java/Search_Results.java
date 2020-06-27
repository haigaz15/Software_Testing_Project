import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Search_Results {
    WebDriver driver;
    private By search_captions = By.className("gsc-thumbnail-inside");
    private By search_button = By.className("button-container");
    private By search_bar = By.className("input-wrapper");
    private By header = By.xpath("//div[@class='gsc-tabHeader gsc-tabhInactive gsc-inline-block']");
    public Search_Results(WebDriver driver) {
        this.driver = driver;
    }

    public String check_search_button(){
        return driver.findElement(search_button).getText();
    }
    public boolean checkHeaders(){
        List<WebElement> elements = driver.findElements(header);
        boolean flag = false;
        for(WebElement element: elements){
           flag =  element.isDisplayed();
           element.getText();
        }
        return flag;
    }
    public boolean search_bar_isPresent(){
        return driver.findElement(search_bar).isDisplayed();
    }

    public ArrayList<String> getCaptions(){
        ArrayList<String> arr = new ArrayList<>();
        List<WebElement> list = driver.findElements(search_captions);
        for(WebElement element : list){
            arr.add(element.getText());
        }
        arr.remove(arr.size()-1);
        return arr;
    }
}
