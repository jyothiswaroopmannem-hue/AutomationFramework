package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class DashboardPage {
    WebDriver driver;
    public DashboardPage(WebDriver driver){

        this.driver=driver;
    }
    By employeeMenu=By.xpath("//p[text()='Employees']");
    public void goToEmployeePage() throws InterruptedException {
        Utils uobj=new Utils(driver);
        uobj.visibilityOfElement(employeeMenu);
        driver.findElement(employeeMenu).click();
    }
}
