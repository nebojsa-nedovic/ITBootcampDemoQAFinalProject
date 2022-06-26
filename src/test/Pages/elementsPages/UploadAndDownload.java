package Pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
public class UploadAndDownload {
    String url = "https://demoqa.com/upload-download";
    WebDriver driver;
    By selectButton = By.id("item-7");
    By downloadButton = By.id("downloadButton");
    By uploadButton = By.id("uploadFile");
    By uploadTextMessage =  By.id("uploadedFilePath");
    public UploadAndDownload(WebDriver driver){
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public WebElement getSelectButton() {
        return driver.findElement(selectButton);
    }

    public WebElement getDownloadButton() {
        return driver.findElement(downloadButton);
    }

    public WebElement getUploadButton() {
        return driver.findElement(uploadButton);
    }

    public String getUploadTextMessage() {
         return driver.findElement(uploadTextMessage).getText();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {

                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }
    public void uploadFile(String filePath){
        getUploadButton().sendKeys(filePath);
    }

}
