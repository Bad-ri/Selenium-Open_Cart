package Pages;

import Base.edgeBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends edgeBrowser {
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
    By email = By.xpath("//input[@id=\"ap_email\"]");
    By submit = By.xpath("//input[@id=\"continue\"]");
    By alert = By.xpath("//h4[@class=\"a-alert-heading\"]");
    public void EnterEmail(String input){
        WebElement Email = driver.findElement(email);
        wait.until(ExpectedConditions.elementToBeClickable(Email));
        Email.sendKeys(input);
    }
    public void ClickSubmit(){
        WebElement Submit = driver.findElement(submit);
        Submit.click();
    }
    public void CheckNotification(){
        WebElement Alert = driver.findElement(alert);
        wait.until(ExpectedConditions.presenceOfElementLocated(alert));
        String Actual = Alert.getText();
        String Expected = "There was a problem";
        Assert.assertTrue(Actual.contains(Expected));
    }
}