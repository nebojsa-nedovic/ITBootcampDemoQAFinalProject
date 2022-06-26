package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChekBoxPageTest extends BasePage {
    @Test
    public void selectElements() {
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                indexPage.listElements().get(i).click();
        }
        checkBox.getSelectButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),checkBox.getUrl());
    }

    @Test
    public void expandList(){
        selectElements();
        checkBox.expand(3);

        Assert.assertEquals(driver.getCurrentUrl(),checkBox.getUrl());
    }

    @Test
    public void selectByName() throws InterruptedException {
        selectElements();
        checkBox.selecByName("Excel File.doc");

        Thread.sleep(1000);
        Assert.assertEquals(checkBox.getTextSuccess().get(0).getText(),"react");
    }
}
