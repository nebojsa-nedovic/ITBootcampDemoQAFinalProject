package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenImagesLinksPageTest extends BasePage {
    @Test
    public void selectElements() {
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                indexPage.listElements().get(i).click();
        }
            brokenImagesLinks.getSelectButton();
            Assert.assertEquals(driver.getCurrentUrl(),brokenImagesLinks.getUrl());
    }

    @Test
    public void checkImages() throws IOException {
        selectElements();
        List<WebElement> listOfImages = brokenImagesLinks.getImages();

        for (WebElement l : listOfImages){
            if(l.getAttribute("naturalWidth").equals("0")){
                System.out.println(l.getAttribute("outerHTML") + " is broken.");
                Assert.fail();
            }
        }
    }

    @Test
    public void checkLinks() throws InterruptedException, IOException {
        selectElements();

        Thread.sleep(1000);
        List<WebElement> listOfLinks = brokenImagesLinks.getLinks();

        for (int i = 0; i < listOfLinks.size(); i++) {
            listOfLinks.get(i).click();

            //URL connection
            HttpURLConnection cont= (HttpURLConnection)new URL(driver.getCurrentUrl()).openConnection();

            // pass HEAD as parameter to setRequestMethod
            cont.setRequestMethod("HEAD");

            // obtain Response code
            cont.connect();

            int rs = cont.getResponseCode();

            if(i == 0){
                Assert.assertEquals(rs,200);
            }else{
                Assert.assertEquals(rs,500);
            }

            Thread.sleep(2000);
            js.executeScript("window.history.go(-1)");

        }
    }
}
