package Pages.formsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PracticeForm {
    String url = "https://demoqa.com/automation-practice-form";
    WebDriver driver;
    By selectButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li/span");
    //Form elements
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By userEmail = By.id("userEmail");
    By male = By.id("gender-radio-1");
    By female = By.id("gender-radio-2");
    By other = By.id("gender-radio-3");

    By gender = By.className("custom-control-label");
    By userNumber = By.id("userNumber");
    By dateOfBirth = By.id("dateOfBirth");
    By subjectsContainer = By.id("subjectsContainer");
    By sports = By.id("hobbies-checkbox-1");
    By reading = By.id("hobbies-checkbox-2");
    By music = By.id("hobbies-checkbox-3");
    By uploadPicture = By.id("uploadPicture");
    By currentAddress = By.id("currentAddress");
    By state = By.id("state");
    By city = By.id("city");
    By submit = By.id("submit");
    public PracticeForm(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public WebElement getSelectButton() {
         return driver.findElement(selectButton);
    }
    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }
    public WebElement getLastName() {
        return driver.findElement(lastName);
    }
    public WebElement getUserEmail() {
        return driver.findElement(userEmail);
    }
    public WebElement getMale() {
        return driver.findElement(male);
    }

    public WebElement getFemale() {
        return driver.findElement(female);
    }

    public WebElement getOther() {
        return driver.findElement(other);
    }
    public WebElement getUserNumber() {
        return driver.findElement(userNumber);
    }
    public WebElement getDateOfBirth() {
        return driver.findElement(dateOfBirth);
    }
    public WebElement getSubjectsContainer() {
        return driver.findElement(subjectsContainer);
    }
    public WebElement getSports() {
        return driver.findElement(sports);
    }

    public WebElement getReading() {
        return driver.findElement(reading);
    }

    public WebElement getMusic() {
        return driver.findElement(music);
    }
    public WebElement getUploadPicture() {
        return driver.findElement(uploadPicture);
    }
    public WebElement getCurrentAddress() {
        return driver.findElement(currentAddress);
    }
    public WebElement getState() {
        return driver.findElement(state);
    }
    public WebElement getCity() {
        return driver.findElement(city);
    }

    public WebElement getSubmit() {
        return driver.findElement(submit);
    }

    public List<WebElement> getGender() {
        return driver.findElements(gender);
    }
}
