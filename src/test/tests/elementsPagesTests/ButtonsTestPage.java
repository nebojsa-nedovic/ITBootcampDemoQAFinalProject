package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTestPage extends BasePage {
    @Test
    public void selectElements() {
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                indexPage.listElements().get(i).click();
        }
            buttons.getSelectButton();
            Assert.assertEquals(buttons.getUrl(),"https://demoqa.com/buttons");
    }

    @Test
    public void doubleClick(){
        selectElements();
        buttons.getDoubleClick();

        Assert.assertEquals(driver.getCurrentUrl(),buttons.getUrl());
        Assert.assertEquals(buttons.getDoubleClickMessage(),"You have done a double click");
    }

    @Test
    public void rightClick(){
        selectElements();
        buttons.getRightClick();

        Assert.assertEquals(driver.getCurrentUrl(),buttons.getUrl());
        Assert.assertEquals(buttons.getRightClickMessage(),"You have done a right click");
    }

    @Test
    public void regularClick(){
        selectElements();
        buttons.getRegularClick();

        Assert.assertEquals(driver.getCurrentUrl(),buttons.getUrl());
        Assert.assertEquals(buttons.getRegularClickMessage(),"You have done a dynamic click");
    }
}
