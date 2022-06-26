package tests.bookStorePageTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTestPage extends BasePage {

    @Test
    public void selectElements() {
        js.executeScript("window.scrollBy(0,1000)");
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Book Store Application"))
                indexPage.listElements().get(i).click();
        }
        js.executeScript("window.scrollBy(0,1000)");
        actions.moveToElement(profile.getSelectButton()).click().perform();
        Assert.assertEquals(driver.getCurrentUrl(),profile.getUrl());
    }

    @Test
    public void LoginAndCheckListLength() throws InterruptedException {
        driver.navigate().to(login.getUrl());
        login.login(login.getValidUser(),login.getValidPassword());
        Thread.sleep(1000);
        int totalOfBooks = profile.listLength();

        Assert.assertEquals(totalOfBooks,1);
    }

    @Test
    public void LoginAndRemoveBook() throws InterruptedException {
        driver.navigate().to(login.getUrl());
        login.login(login.getValidUser(),login.getValidPassword());

        Thread.sleep(1000);
        if(profile.listLength() == 0) Assert.fail();
        profile.deleteItem(0);
        profile.getOkButton().click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertEquals(message,"Book deleted.");
    }
}
