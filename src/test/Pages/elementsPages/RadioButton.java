package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton {
    String url = "https://demoqa.com/radio-button";
    WebDriver driver;

    By selectRadioButton = By.id("item-2");
    By selectYes = By.id("yesRadio");
    By selectImpressive = By.id("impressiveRadio");
    By selectNo = By.id("noRadio");
    By text = By.className("text-success");

    public String getUrl() {
        return url;
    }

    public RadioButton(WebDriver driver){
        this.driver = driver;
    }

    public void getSelectRadioButton() {
         driver.findElement(selectRadioButton).click();
    }

    public WebElement getSelectYes() {
        return driver.findElement(selectYes);
    }

    public WebElement getSelectImpressive() {
        return driver.findElement(selectImpressive);
    }

    public WebElement getSelectNo() {
        return driver.findElement(selectNo);
    }

    public WebElement getText() {
         return driver.findElement(text);
    }
}
