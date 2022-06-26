package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DynamicPropertiesTestPage extends BasePage {
    @Test
    public void selectElements() {
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                indexPage.listElements().get(i).click();
        }
            js.executeScript("arguments[0].scrollIntoView();", dynamicProperties.selectButton());
            dynamicProperties.selectButton().click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/dynamic-properties");
    }

    @Test
    public void clickAfterFiveSec(){
        selectElements();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(dynamicProperties.getEnableAfterFiveSec()));
        dynamicProperties.getEnableAfterFiveSec().click();

        Assert.assertTrue(dynamicProperties.getEnableAfterFiveSec().isEnabled());
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/dynamic-properties");
    }

    @Test
    public void clickToChangeColor() throws InterruptedException {
        selectElements();

        dynamicProperties.getColorChange().click();

        Thread.sleep(5000);
        String textColoer = driver.findElement(By.id("colorChange")).getCssValue("color");

        Assert.assertEquals(textColoer,"rgba(220, 53, 69, 1)"); //Button has changed color
    }

    @Test
    public void clickToBeVisible(){
        selectElements();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(dynamicProperties.getEnableAfterFiveSec()));
        dynamicProperties.getVisibleAfterFiveSec().click();

        Assert.assertTrue(dynamicProperties.getVisibleAfterFiveSec().isEnabled());
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/dynamic-properties");
    }

    @Test
    public void clickAfterBeforeFiveSec(){
        selectElements();
        dynamicProperties.getEnableAfterFiveSec().click();

        Assert.assertFalse(dynamicProperties.getEnableAfterFiveSec().isEnabled());
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/dynamic-properties");
    }
}
