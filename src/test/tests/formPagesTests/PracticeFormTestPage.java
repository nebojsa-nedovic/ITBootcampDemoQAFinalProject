package tests.formPagesTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class PracticeFormTestPage extends BasePage {
    @Test
    public void selectElements(){
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Forms"))
                indexPage.listElements().get(i).click();
        }

            actions.moveToElement(practiceForm.getSelectButton()).click().perform();
            Assert.assertEquals(driver.getCurrentUrl(),practiceForm.getUrl());
    }

    @Test
    public void validInput() throws InterruptedException {
        selectElements();
        //js.executeScript("document.body.style.zoom='70%'");
        practiceForm.getFirstName().sendKeys("Nebojsa");
        practiceForm.getLastName().sendKeys("Nedovic");
        practiceForm.getUserEmail().sendKeys("nebojsa@gmail.com");
        actions.moveToElement(practiceForm.getMale()).click().perform();
        practiceForm.getUserNumber().sendKeys("0645618228",Keys.TAB);
        actions.moveToElement(practiceForm.getDateOfBirth()).sendKeys("11 07 1992",Keys.ENTER,Keys.TAB).perform();
        actions.moveToElement(practiceForm.getSubjectsContainer()).sendKeys("English",Keys.ENTER,Keys.TAB).perform();
        actions.moveToElement(practiceForm.getSports()).click().perform();
        practiceForm.getUploadPicture().sendKeys("C:\\Users\\Shone\\Desktop\\","sampleFile.jpeg");
        practiceForm.getCurrentAddress().sendKeys("Carice Milice 11",Keys.TAB);
        actions.moveToElement(practiceForm.getState()).sendKeys("NCR",Keys.ENTER,Keys.TAB).perform();;
        actions.moveToElement(practiceForm.getCity()).sendKeys("Delhi",Keys.ENTER,Keys.TAB, Keys.ENTER).perform();
    }
}
