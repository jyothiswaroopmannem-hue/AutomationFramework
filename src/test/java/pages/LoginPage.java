package pages;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    Utils uobj;
    public LoginPage(WebDriver driver){
        this.driver= driver;
        this.uobj=new Utils(driver);
    }
    private final By usernameTxt= By.id("userEmail");
    private final By pwd=By.id("userPassword");
    private final By loginBtn=By.xpath("//button[@type='submit']");
    private final By dashboardElement=By.xpath("(//p[text()='Dashboard'])[2]");


    public void enterUserName(String username) {
        driver.findElement(usernameTxt).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(pwd).sendKeys(password);
    }

    public void clickLogin() {
        uobj.elementToBeClickable(loginBtn);
        driver.findElement(loginBtn).click();
    }

    public boolean isDashboardDisplayed() {
       uobj=new Utils(driver);
       uobj.visibilityOfElement(dashboardElement);
        return driver.findElement(dashboardElement).isDisplayed();
    }
}
