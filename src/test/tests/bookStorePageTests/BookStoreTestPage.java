package tests.bookStorePageTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BookStoreTestPage extends BasePage {

    @Test
    public void selectElements() {
        js.executeScript("window.scrollBy(0,1000)");
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Book Store Application"))
                indexPage.listElements().get(i).click();
        }
        js.executeScript("window.scrollBy(0,1000)");
        bookStore.getSelectButton().click();
    }

    @Test
    public void checkImages(){
        selectElements();

        List<WebElement> listOfImages = bookStore.getImages();
        System.out.println(listOfImages.size());
        for (int i = 0; i < listOfImages.size(); i++) {
            if(listOfImages.get(i).getAttribute("outerHTML").equalsIgnoreCase("<img class=\"RightSide-Ad\" src=\"../assets/DemoQA_banner_Katalon_Free_Automation_Tools.png\" width=\"80%\" alt=\"Katalon Acedemy\">")){
                continue;
            }
            if(listOfImages.get(i).getAttribute("naturalWidth").equals("0")){
                System.out.println(listOfImages.get(i).getAttribute("outerHTML") + " is broken.");
                Assert.fail();
            }
        }
    }

    @Test
    public void selectFirstBookAndReturnsBack() throws InterruptedException {
        selectElements();
        bookStore.selectFromBookListText("Git Pocket Guide");
        bookStore.backAddCollection(0);

        Assert.assertEquals(bookStore.getUrl(),"https://demoqa.com/books");
    }

    @Test
    public void selectLastBookAndReturnsBack() throws InterruptedException {
        selectElements();
        js.executeScript("window.scrollBy(0,1000)");
        bookStore.selectFromBookListText("Understanding ECMAScript 6");
        bookStore.backAddCollection(0);

        Assert.assertEquals(bookStore.getUrl(),"https://demoqa.com/books");
    }

    @Test(priority = 1)
    public void selectBookAndLogin() throws InterruptedException {
        selectElements();
        bookStore.selectFromBookListText("Git Pocket Guide");

        login.getLoginButton().click();
        login.login("shone","Shoone7!");
        Thread.sleep(2000);

        bookStore.backAddCollection(1);
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertEquals(bookStore.getUrl(),"https://demoqa.com/books");
        Assert.assertEquals(message,"Book added to your collection.");
    }

    @Test(priority = 2)
    public void selectAddedBook() throws InterruptedException {
        selectElements();
        bookStore.selectFromBookListText("Git Pocket Guide");

        login.getLoginButton().click();
        login.login("shone","Shoone7!");
        Thread.sleep(2000);

        bookStore.backAddCollection(1);
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertEquals(bookStore.getUrl(),"https://demoqa.com/books");
        Assert.assertEquals(message,"Book already present in the your collection!");
    }
}
