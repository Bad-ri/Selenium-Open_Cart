package TestCases;

import Base.edgeBrowser;
import Functions.ExcelData;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends edgeBrowser {
    @Test
    public void ValidSearch(){
        HomePage home = new HomePage(driver);
        ExcelData data = new ExcelData();
        home.SearchFor(data.GetValidSearch());
        this.NotificationCheck(home.GetSearchResult());
    }
    public void NotificationCheck(String input){
        String Expected = "iphone 14 pro max";
        Assert.assertTrue(input.contains(Expected));
    }
}