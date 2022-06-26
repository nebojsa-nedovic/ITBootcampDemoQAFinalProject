package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {
    String url = "https://demoqa.com/checkbox";

    WebDriver driver;
    By selectButton = By.id("item-1");
    By toggleButton = By.cssSelector("button[title='Toggle']");
    By folderName = By.className("rct-title");
    By textSuccess = By.className("text-success");
    public CheckBox(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public WebElement getSelectButton() {
        return driver.findElement(selectButton);
    }

    public List<WebElement> getToggleButton() {
        return driver.findElements(toggleButton);
    }

    public List<WebElement> getFolderName() {
        return driver.findElements(folderName);
    }

    public List<WebElement> getTextSuccess() {
        return driver.findElements(textSuccess);
    }

    public void expand(int index){
        for (int i = 0; i <= index; i++) {
            getToggleButton().get(i).click();
        }
    }
    public void selecByName(String folderName){
        boolean folderFound = false;
        for (int i = 0; i <= getToggleButton().size(); i++) {

            for (int j = 0; j < getFolderName().size(); j++) {
                if(getFolderName().get(j).getText().equalsIgnoreCase(folderName)){
                    getFolderName().get(j).click();
                    folderFound = true;
                }
            }
            if(folderFound){
                break;
            }
            getToggleButton().get(i).click();
        }
    }
}
