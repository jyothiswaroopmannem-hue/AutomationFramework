package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

import java.io.IOException;

public class EmployeePage {
    WebDriver driver;
    Utils uobj;
    public EmployeePage(WebDriver driver){
        this.driver=driver;
        this.uobj=new Utils(driver);
    }

    By addEmployee = By.xpath("//button[contains(text(),'Add Employee')]");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By empId = By.id("employeeID");
    By email = By.name("email");
    By password = By.name("password");
    By dob = By.xpath("(//input[@class='sc-imWYAI fbrKEO'])[6]");
    By joiningDate = By.name("joiningDate");
    By department = By.name("department");
    By mobileNumber = By.name("mobileNumber");
    By designation = By.name("designation");
    By salary = By.id("salary");
    By location = By.name("location");
    By cancel = By.xpath("//button[@class='sc-gsFSXq gycIdR']");
    By add = By.xpath("//button[text()='Add']");
    By toastMessage=By.xpath("//div[text()='Saved Successfully']");
    By role=By.id("role");
    By qualifications=By.id("qualifications");
    By bloodGroup=By.id("bloodGroup");
    By reportingTo=By.id("reportingTo");
    By gender=By.id("gender");


    public void clickAddEmployee() {
        uobj.visibilityOfElement(addEmployee);
        driver.findElement(addEmployee).click();
    }

    public void enterFirstName(String fn) {
        uobj.visibilityOfElement(firstName);
        driver.findElement(firstName).sendKeys(fn);
    }

    public void enterLastName(String ln) {
        uobj.visibilityOfElement(lastName);
        driver.findElement(lastName).sendKeys(ln);
    }

    public void enterEmpId(String emplid) {
        uobj.visibilityOfElement(empId);
        driver.findElement(empId).sendKeys(emplid);
    }

    public void enterEmail(String mail) {
        uobj.visibilityOfElement(email);
        driver.findElement(email).sendKeys(mail);
    }
    public void selectDropdownOption(By dropdown,String value){
        String dynamicXpath=String.format(".//option[normalize-space()='%s']",value);
        uobj.visibilityOfElement(dropdown);
        driver.findElement(dropdown).findElement(By.xpath(dynamicXpath)).click();
    }

    public void selectRole(String roleName) {
        selectDropdownOption(role,roleName);

    }

    public void selectQualification(String qualificationName){
       selectDropdownOption(qualifications,qualificationName);
    }

    public void selectBloodGroup(String bloodGroupName){
        selectDropdownOption(bloodGroup,bloodGroupName);
    }

    public void selectReportingTo(String reportingToName){
        selectDropdownOption(reportingTo,reportingToName);
    }

    public void selectGender(String genderName) {
        selectDropdownOption(gender,genderName);
    }


    public void enterPassword(String pwd) {
        uobj.visibilityOfElement(password);
        driver.findElement(password).sendKeys(pwd);
    }


    public void selectDob(String bDate){
        driver.findElement(dob).sendKeys(bDate);
    }

    public void selectJoiningDate(String jDate){
        driver.findElement(joiningDate).sendKeys(jDate);
    }
    public void enterDeptName(String dept) {
        uobj.visibilityOfElement(department);
        driver.findElement(department).sendKeys(dept);
    }

    public void enterMobileNumber(String mobNo) {
        driver.findElement(mobileNumber).sendKeys(mobNo);
    }

    public void enterDesignation(String desig) {
        uobj.visibilityOfElement(designation);
        driver.findElement(designation).sendKeys(desig);
    }

    public void enterSalary(double sal) {
        driver.findElement(salary).sendKeys(String.valueOf(sal));
    }

    public void enterlocation(String loc) {
        driver.findElement(location).sendKeys(loc);
    }

    public void clickCancel() {
        driver.findElement(cancel).click();
    }

    public void clickAdd() {
        driver.findElement(add).click();
    }

    public void addEmployee(String fn,String ln,String emplid, String mail, String roleName,String qualificationName,String genderName,String bloodGroupName,String reportingToName ,String pwd, String date, String jdate, String dept,String mno, String desig,double sal,String loc   ) throws InterruptedException, IOException, IOException {

        enterFirstName(fn);
        enterLastName(ln);
        enterEmpId(emplid);
        selectRole(roleName);
        selectQualification(qualificationName);
        selectGender(genderName);
        selectReportingTo(reportingToName);
        selectBloodGroup(bloodGroupName);
        enterEmail(mail);
        enterPassword(pwd);
        selectDob(date);
        selectJoiningDate(jdate);
        enterDeptName(dept);
        enterMobileNumber(mno);
        enterDesignation(desig);
        enterSalary(sal);
        enterlocation(loc);
        uobj.screenshotMethod();
    }
    public String getToastMessage(){
        uobj.visibilityOfElement(toastMessage);
        return driver.findElement(toastMessage).getText();
    }
}
