package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadAndDownloadPage extends BasePage {
    @Test
    public void selectElements() {
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                indexPage.listElements().get(i).click();
        }
            js.executeScript("arguments[0].scrollIntoView();", uploadAndDownload.getSelectButton());
            uploadAndDownload.getSelectButton().click();
    }

    @Test
    public void download() throws InterruptedException {
        selectElements();

        uploadAndDownload.getDownloadButton().click();
        Thread.sleep(3000);
        boolean b = uploadAndDownload.isFileDownloaded("C:\\Users\\Shone\\Downloads","sampleFile.jpeg");

        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/upload-download");
        Assert.assertTrue(b);
    }

    @Test
    public void upload(){
        selectElements();
        uploadAndDownload.uploadFile("C:\\Users\\Shone\\Desktop\\sampleFile.jpeg");

        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/upload-download");
        Assert.assertEquals(uploadAndDownload.getUploadTextMessage(),"C:\\fakepath\\sampleFile.jpeg");
    }
}
