package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Buttons {
    public final String url = "https://demoqa.com/buttons";
    WebDriver driver;
    public Buttons(WebDriver driver){
        this.driver = driver;
    }

    By selectButton = By.id("item-4");
    By doubleClick = By.id("doubleClickBtn");
    By rightClick = By.id("rightClickBtn");
    By regularClick = By.xpath("//button[text()='Click Me']");

    By doubleClickMessage = By.id("doubleClickMessage");
    By rightClickMessage = By.id("rightClickMessage");
    By regularClickMessage = By.id("dynamicClickMessage");

    public String getUrl() {
        return url;
    }

    public void getSelectButton() {
        driver.findElement(selectButton).click();
    }

    public void getDoubleClick() {
        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(doubleClick);
        actions.moveToElement(webElement);
        actions.doubleClick(webElement).perform();
    }

    public void getRightClick() {
        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(rightClick);
        actions.moveToElement(webElement);
        actions.contextClick(webElement).perform();
    }

    public void getRegularClick() {
        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(regularClick);
        actions.moveToElement(webElement);
        actions.click(webElement).perform();
    }

    public String getDoubleClickMessage() {
        return driver.findElement(doubleClickMessage).getText();
    }

    public String getRightClickMessage() {
        return driver.findElement(rightClickMessage).getText();
    }

    public String getRegularClickMessage() {
        return driver.findElement(regularClickMessage).getText();
    }
}
