package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class IndexPageTest extends BasePage {

    @Test(priority = 2)
    public void clickLogo(){
        indexPage.getLogo_image().click();

        Assert.assertEquals(PAGE_URL,driver.getCurrentUrl());
    }

    @Test(priority = 3)
    public void clickContent(){
        indexPage.getContent().click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.toolsqa.com/selenium-training/");
    }

    @Test(priority = 1)
    public void selectElement(){
        indexPage.selectAnElement(0);

        Assert.assertEquals("https://demoqa.com/elements",driver.getCurrentUrl());
    }
}
