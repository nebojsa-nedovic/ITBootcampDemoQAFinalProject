package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements  {

    WebDriver driver;
    String url = "https://demoqa.com/elements";
    public Elements(WebDriver driver) {
        this.driver = driver;
    }

    By expandListButton = By.className("pr-1");
    By expandListArrow = By.className("");

    public WebElement getExpandList() {
        return driver.findElement(expandListButton);
    }
}
