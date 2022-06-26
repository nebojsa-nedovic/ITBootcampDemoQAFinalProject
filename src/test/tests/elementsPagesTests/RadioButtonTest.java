package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;;

public class RadioButtonTest extends BasePage {
    @Test
    public void selectElements() {
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                indexPage.listElements().get(i).click();
        }
            radioButton.getSelectRadioButton();
            Assert.assertEquals(driver.getCurrentUrl(),radioButton.getUrl());
    }

    @Test
    public void selectYesOption() throws InterruptedException {
        selectElements();
        Actions action = new Actions(driver);
        action.moveToElement(radioButton.getSelectYes()).click().perform();

        Assert.assertEquals(radioButton.getText().getText() , "Yes");
    }

    @Test
    public void selectImpressiveOption() throws InterruptedException {
        selectElements();
        Actions action = new Actions(driver);
        action.moveToElement(radioButton.getSelectImpressive()).click().perform();

        Assert.assertEquals(radioButton.getText().getText() , "Impressive");
    }

    @Test
    public void selectNoOption() throws InterruptedException {
        selectElements();
        Actions action = new Actions(driver);
        action.moveToElement(radioButton.getSelectNo()).click().perform();

        Assert.assertFalse(radioButton.getSelectNo().isEnabled());
    }
}
