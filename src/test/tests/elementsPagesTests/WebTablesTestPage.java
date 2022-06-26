package tests.elementsPagesTests;

import BasePagePackage.BasePage;
import Pages.elementsPages.WebTables;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTestPage extends BasePage {
    @Test
    public void selectElements() {
        for (int i=0; i < indexPage.listElements().size();i++) {
            if(indexPage.listElements().get(i).getText().equalsIgnoreCase("Elements"))
                indexPage.listElements().get(i).click();
        }
        webTables.getSelectButton();
        Assert.assertEquals(driver.getCurrentUrl(),webTables.getUrl());
    }

    @Test
    public void validInput(){
        selectElements();

        webTables.addRecord("Nebojsa","Nedovic","nebojsa@gmail.com","29","111111","Airfreight");

        int currentSize = webTables.getEdit().size();

        Assert.assertEquals(currentSize,webTables.getEdit().size());
    }

    @Test
    public void updateRecord(){
        selectElements();
        webTables.updateRecord(0,"","Gonzales","gonzales@gmail.com","40","140000","");

        int currentSize = webTables.getEdit().size();

        Assert.assertEquals(currentSize,webTables.getEdit().size());
    }

    @Test
    public void deleteRecord(){
        selectElements();
        webTables.deleteRecord(0);

        int currentSize = webTables.getEdit().size();

        Assert.assertEquals(currentSize,2);
    }

}
