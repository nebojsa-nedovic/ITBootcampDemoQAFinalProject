package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TexBoxTest extends BasePage {
    @Test
    public void selectElementsAndSubElement() {
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                indexPage.listElements().get(i).click();
        }
            textBox.getSelect();
    }

    @Test
    public void validInput(){
        selectElementsAndSubElement();
        textBox.fillInForm("Nebojsa","nebojsa@gmail.com","Current address","Permanent");

        Assert.assertTrue(driver.findElement(By.className("border")).isDisplayed());
    }

    @Test
    public void fillInInvalidEmail() throws InterruptedException {
        selectElementsAndSubElement();
        textBox.fillInForm("Nebojsa","nebojsagmail.com","Current address","Permanent");

        Thread.sleep(500);
        String color = driver.findElement(By.id("userEmail")).getCssValue("border-bottom-color");

        Assert.assertEquals(color,"rgba(255, 0, 0, 1)");
    }
}
