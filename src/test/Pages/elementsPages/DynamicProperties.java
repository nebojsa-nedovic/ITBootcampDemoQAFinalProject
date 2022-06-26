package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DynamicProperties {
    public String url = "https://demoqa.com/dynamic-properties";
    WebDriver driver;
    By enableAfterFiveSec = By.id("enableAfter");
    By colorChange = By.id("colorChange");
    By visibleAfterFiveSec = By.id("visibleAfter");
    By selectButton = By.id("item-8");
    public DynamicProperties(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }
    public WebElement getEnableAfterFiveSec() {
        return driver.findElement(enableAfterFiveSec);
    }
    public WebElement getColorChange() {
        return driver.findElement(colorChange);
    }

    public WebElement getVisibleAfterFiveSec() {
        return driver.findElement(visibleAfterFiveSec);
    }

    public WebElement selectButton() {
         return driver.findElement(selectButton);
    }
}
