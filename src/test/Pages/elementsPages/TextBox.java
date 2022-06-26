package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox {
    String url = "https://demoqa.com/text-box";
    WebDriver driver;

    public TextBox(WebDriver driver) {
        this.driver = driver;
    }
    By selectTextBox = By.id("item-0");
    By fullName = By.id("userName");
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By submitButton = By.id("submit");

    public String getUrl() {
        return url;
    }
    public void getSelect() {
        driver.findElement(selectTextBox).click();
    }
    public WebElement getFullName() {
        return driver.findElement(fullName);
    }
    public WebElement getEmail() {
        return driver.findElement(email);
    }
    public WebElement getCurrentAddress() {
        return driver.findElement(currentAddress);
    }
    public WebElement getPermanentAddress() {
        return driver.findElement(permanentAddress);
    }
    public void getSubmitButton() {
        driver.findElement(submitButton).click();
    }
    public void fillInForm(String name,String email,String currentAddress,String permanentAddress){
        getFullName().sendKeys(name);

        getEmail().sendKeys(email);
        getCurrentAddress().sendKeys(currentAddress);
        getPermanentAddress().sendKeys(permanentAddress);
        getSubmitButton();
    }
}
