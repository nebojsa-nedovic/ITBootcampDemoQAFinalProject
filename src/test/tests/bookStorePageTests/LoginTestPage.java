package tests.bookStorePageTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginTestPage extends BasePage {
    @Test
    public void selectElements() {
        js.executeScript("window.scrollBy(0,1000)");
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Book Store Application"))
                indexPage.listElements().get(i).click();
        }
            js.executeScript("window.scrollBy(0,1000)");
            login.getSelectButton().click();
    }

    @Test
    public void validRegistration() throws InterruptedException {
        selectElements();
        login.login(login.getValidUser(),login.getValidPassword());
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/profile");
    }

    @Test
    public void validRegistrationAndLogout() throws InterruptedException {
        selectElements();
        login.login(login.getValidUser(),login.getValidPassword());
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        List<WebElement> list = new ArrayList(login.allSubmit());
        list.get(0).click();
        Assert.assertEquals(driver.getCurrentUrl(),login.getUrl());
    }

    @Test
    public void goToBookStoreFromProfile() throws InterruptedException {
        selectElements();
        login.login(login.getValidUser(),login.getValidPassword());

        Thread.sleep(500);
        js.executeScript("window.scrollBy(0,1000)");

        login.getGotoStore().click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/books");
    }

    public void deleteAllBooksEmptyList() {
        selectElements();
        login.login(login.getValidUser(),login.getValidPassword());

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        List<WebElement> list = new ArrayList(login.allSubmit());
        list.get(2).click();

        login.getConfirmAllBooksDeletion().click();
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/profile");
        Assert.assertEquals(message,"No books available in your's collection!");
    }

    @Test
    public void deleteAllBooks()  {
        selectElements();
        login.login(login.getValidUser(),login.getValidPassword());

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        List<WebElement> list = new ArrayList(login.allSubmit());
        list.get(2).click();

        profile.getOkButton().click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/profile");
        Assert.assertEquals(message,"All Books deleted.");
    }

    @Test
    public void loginAndSelectBook() throws InterruptedException {
        selectElements();
        login.login(login.getValidUser(),login.getValidPassword());
        Thread.sleep(1000);
        login.getGotoStore().click();

        bookStore.selectFromBookListText("Git Pocket Guide");
        bookStore.backAddCollection(1);

        webDriverWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertEquals(message,"Book added to your collection.");
        Assert.assertEquals(bookStore.getUrl(),"https://demoqa.com/books");
    }

    @Test
    public void loginAndSelectAddedBook() throws InterruptedException {
        selectElements();
        login.login(login.getValidUser(),login.getValidPassword());
        Thread.sleep(1000);
        login.getGotoStore().click();

        bookStore.selectFromBookListText("Git Pocket Guide");
        bookStore.backAddCollection(1);

        webDriverWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertEquals(message,"Book already present in the your collection!");
        Assert.assertEquals(bookStore.getUrl(),"https://demoqa.com/books");
    }

}
