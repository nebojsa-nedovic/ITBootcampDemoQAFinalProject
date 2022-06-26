package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTables {
    String url = "https://demoqa.com/webtables";
    WebDriver driver;

    By selectButton = By.id("item-3");

    By addButton = By.id("addNewRecordButton");

    //Alert window form
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By userEmail = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");
    By edit = By.cssSelector("span[title='Edit']");
    By delete = By.cssSelector("span[title='Delete']");
    By submit = By.id("submit");
    By rowsContent = By.className("rt-tr-group");
    public WebTables(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void getSelectButton() {
        driver.findElement(selectButton).click();
    }
    public WebElement getAddButton() {
        return driver.findElement(addButton);
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
    public WebElement getAge() {
        return driver.findElement(age);
    }
    public WebElement getSalary() {
        return driver.findElement(salary);
    }
    public WebElement getDepartment() {
        return driver.findElement(department);
    }
    public WebElement getSubmit() {return driver.findElement(submit);}

    public List<WebElement> getEdit() {
        return driver.findElements(edit);
    }

    public List<WebElement> getDelete() {
        return driver.findElements(delete);
    }

    public List<WebElement> getRowsContent() {
        return driver.findElements(rowsContent);
    }

    public void addRecord(String name, String lastName, String userEmail, String age, String salary, String department){
        getAddButton().click();

        getFirstName().sendKeys(name);
        getLastName().sendKeys(lastName);
        getUserEmail().sendKeys(userEmail);
        getAge().sendKeys(age);
        getSalary().sendKeys(salary);
        getDepartment().sendKeys(department);

        getSubmit().click();
    }

    public void updateRecord(int index,String name, String lastName, String userEmail, String age, String salary, String department){
        getEdit().get(index).click();

        if(!(name.equals(""))){
            getFirstName().clear();
            getFirstName().sendKeys(name);
        }

        if(!(lastName.equals(""))){
            getLastName().clear();
            getLastName().sendKeys(lastName);
        }

        if(!(userEmail.equals(""))){
            getUserEmail().clear();
            getUserEmail().sendKeys(userEmail);
        }

        if(!(age.equals(""))){
            getAge().clear();
            getAge().sendKeys(age);
        }

        if(!(salary.equals(""))){
            getSalary().clear();
            getSalary().sendKeys(salary);
        }

        if(!(department.equals(""))){
            getDepartment().clear();
            getDepartment().sendKeys(department);
        }

        getSubmit().click();
    }
    public void deleteRecord(int index){
        getDelete().get(index).click();
    }
}
