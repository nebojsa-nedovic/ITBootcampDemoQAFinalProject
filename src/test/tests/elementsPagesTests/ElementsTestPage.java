package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ElementsTestPage extends BasePage {

    @Test
    public void selectElements() {
        for (int i=0; i < indexPage.listElements().size();i++) {
                if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                    indexPage.listElements().get(i).click();
        }
    }
}
