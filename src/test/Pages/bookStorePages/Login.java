package Pages.bookStorePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class Login {
    String url = "https://demoqa.com/login";
    String validUser = "shone";
    String validPassword = "Shoone7!";
    WebDriver driver;
    By selectButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]");
    By userName = By.id("userName");
    By password = By.id("password");
    By loginButton = By.id("login");
    By allSubmit = By.id("submit");
    By searchBox = By.id("searchBox");
    By gotoStore = By.id("gotoStore");
    By confirmAllBooksDeletion = By.id("closeSmallModal-ok");
    public Login(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public String getValidUser() {
        return validUser;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public WebElement getSelectButton() {
        return driver.findElement(selectButton);
    }

    public WebElement getUserName() {
        return driver.findElement(userName);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement getConfirmAllBooksDeletion() {
        return driver.findElement(confirmAllBooksDeletion);
    }

    /*Log out index 0
          Delete Account index 1
          Delete All Books index 2
        */
    public List allSubmit() {
        return driver.findElements(allSubmit);
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }
    public WebElement getGotoStore() {
        return driver.findElement(gotoStore);
    }
    public void login(String username, String password){
        getUserName().sendKeys(username);
        getPassword().sendKeys(password);

        getLoginButton().click();
    }
}