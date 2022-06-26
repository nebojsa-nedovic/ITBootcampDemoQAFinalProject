package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksTestPage extends BasePage {

    @Test(priority = 0)
    public void selectElements() {
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                indexPage.listElements().get(i).click();
        }
            links.getSelectLinks();
    }

    // Valid Links
    @Test(priority = 1)
    public void selectHomeLink(){
        selectElements();
        links.selectLink(0);

        Assert.assertEquals(links.windowTabs(),"https://demoqa.com/");
    }

    @Test(priority = 2)
    public void selectHomeF6GjN() {
        selectElements();
        links.selectLink(1);

        Assert.assertEquals(links.windowTabs(),"https://demoqa.com/");
    }

    @Test(priority = 3)
    public void selectCreated() {
        selectElements();
        links.selectLink(2);

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(links.getAddtionaltext(), links.getAddtionaltext().getText()));
        Assert.assertEquals(links.getAddtionaltext().getText(),"Link has responded with staus 201 and status text Created");
    }

    @Test(priority = 4)
    public void selectNoContent() {
        selectElements();
        links.selectLink(3);

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(links.getAddtionaltext(), links.getAddtionaltext().getText()));
        Assert.assertEquals(links.getAddtionaltext().getText(),"Link has responded with staus 204 and status text No Content");
    }

    @Test(priority = 5)
    public void selectMoved() {
        selectElements();
        links.selectLink(4);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("linkResponse")));
        Assert.assertEquals(links.getAddtionaltext().getText(),"Link has responded with staus 301 and status text Moved Permanently");
    }

    @Test(priority = 6)
    public void selectBadRequest() {
        selectElements();
        links.selectLink(5);

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(links.getAddtionaltext(), links.getAddtionaltext().getText()));
        Assert.assertEquals(links.getAddtionaltext().getText(),"Link has responded with staus 400 and status text Bad Request");
    }

    @Test(priority = 7)
    public void selectUnauthorized() {
        selectElements();
        links.selectLink(6);

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(links.getAddtionaltext(), links.getAddtionaltext().getText()));
        Assert.assertEquals(links.getAddtionaltext().getText(),"Link has responded with staus 401 and status text Unauthorized");
    }

    @Test(priority = 8)
    public void selectForbidden() {
        selectElements();
        links.selectLink(7);

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(links.getAddtionaltext(), links.getAddtionaltext().getText()));
        Assert.assertEquals(links.getAddtionaltext().getText(),"Link has responded with staus 403 and status text Forbidden");
    }

    @Test(priority = 9)
    public void selectNotFound() {
        selectElements();
        links.selectLink(8);

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(links.getAddtionaltext(), links.getAddtionaltext().getText()));
        Assert.assertEquals(links.getAddtionaltext().getText(),"Link has responded with staus 404 and status text Not Found");
    }
}
