package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.EmployeePage;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;
import java.util.Random;

public class AddEmployeeSteps {
//=new DashboardPage(driver)
    //=new EmployeePage(driver)

    String name1="ramya";
    String name2="swmannem";
    String expectedText="Saved Successfully";
    WebDriver driver=Hooks.driver;
    LoginPage lp;
    DashboardPage dp;
    EmployeePage ep;
    Utils uobj=new Utils(driver);
    @Given("user is on login page")
    public void user_is_on_login_page(){
        driver= Hooks.driver;
        lp=new LoginPage(driver);
    }
    @When("user enters email {string}")
    public void user_enters_email(String username){
        lp.enterUserName(username);
    }
    @When("user enters password {string}")
    public void user_enters_password(String password){
        lp.enterPassword(password);
    }

    @When("user enters credentials from Excel")
    public void user_enters_credentials_from_excel() throws IOException {
        Utils.ExcelReader();
        String email=Utils.getExcelData(1,0);
        String password=Utils.getExcelData(1,1);
        int rowCount=Utils.getRowCount();

        lp.enterUserName(email);
        lp.enterPassword(password);
        System.out.println(rowCount);
    }
    @And("user click on login button")
    public void user_click_on_login_button(){
        lp.clickLogin();
    }
    @Then("user should be logged in and see the dashboard")
    public void user_should_see_the_dashboard(){
        Assert.assertTrue("Dashboard not visible", lp.isDashboardDisplayed());
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver);
    }
    @Given("user is logged into the application from Excel")
    public void user_is_logged_into_the_application_from_Excel() throws IOException {
        driver=Hooks.driver;
        Utils.ExcelReader();
        lp=new LoginPage(driver);
        String email=Utils.getExcelData(1,0);
        String password=Utils.getExcelData(1,1);
//        int rowCount=Utils.getRowCount();

        lp.enterUserName(email);
        lp.enterPassword(password);
        lp.clickLogin();
        dp=new DashboardPage(driver);
    }
    @Given("user is logged into the application {string} {string}")
    public void user_is_logged_into_the_application(String mail, String pass){
        driver=Hooks.driver;
        lp=new LoginPage(Hooks.driver);
        dp=new DashboardPage(driver);
        ep=new EmployeePage(Hooks.driver);
        lp.enterUserName(mail);
        lp.enterPassword(pass);
        lp.clickLogin();
        System.out.println("User is in the login page");
    }

    @And("user navigates to employee page")
    public void user_navigates_to_employees_page() throws InterruptedException {
       dp=new DashboardPage(driver);
        dp.goToEmployeePage();
    }
    @And("user clicks on add employee button")
    public void user_clicks_on_add_employee_button(){
       ep=new EmployeePage(driver);
        ep.clickAddEmployee();
    }
    @When("user enters employee details from Excel")
    public void user_enters_employee_details_from_Excel() throws IOException {
        driver=Hooks.driver;
        Utils.ExcelReader();
        ep=new EmployeePage(driver);
        int customNos=uobj.randomMethod();

        String firstName=Utils.getExcelData(1,2);
        String lastName=Utils.getExcelData(1,3);
        String empId=Utils.getExcelData(1,4);
        String role=Utils.getExcelData(1,5);
        String qualification=Utils.getExcelData(1,6);
        String gender=Utils.getExcelData(1,7);
        String bloodGroup=Utils.getExcelData(1,8);
        String reportingTo=Utils.getExcelData(1,9);
        String password=Utils.getExcelData(1,10);
        String dob=Utils.getExcelData(1,11);
        String joinDate=Utils.getExcelData(1,12);
        String department=Utils.getExcelData(1,13);
        String mobileNumber=Utils.getExcelData(1,14);
        String designation=Utils.getExcelData(1,15);
        String salary=Utils.getExcelData(1,16);
        String location=Utils.getExcelData(1,17);
        String emailId=Utils.getExcelData(1,18);

        ep.enterFirstName(firstName);
        ep.enterLastName(lastName);
        ep.enterEmpId(empId+customNos);
        ep.enterEmail(name1+customNos+emailId);
        ep.selectRole(role);
        ep.selectQualification(qualification);
        ep.selectGender(gender);
        ep.selectBloodGroup(bloodGroup);
        ep.selectReportingTo(reportingTo);
        ep.enterPassword(password);
        ep.selectDob(dob);
        ep.selectJoiningDate(joinDate);
        ep.enterDeptName(department);
        ep.enterMobileNumber(mobileNumber);
        ep.enterDesignation(designation);
        ep.enterSalary(Double.parseDouble(salary));
        ep.enterlocation(location);
    }
    @When("user enters employee details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void user_enters_employee_details(String firstName,
                                             String lastName,
                                             String empId,
                                             String email,
                                             String role,
                                             String qualification,
                                             String gender,
                                             String bloodGroup,
                                             String reportingTo,
                                             String password,
                                             String dob,
                                             String joiningDate,
                                             String department,
                                             String mobileNumber,
                                             String designation,
                                             String salary,
                                             String location) throws IOException, InterruptedException {

        int customNos =uobj.randomMethod();
        ep.addEmployee(firstName,
                lastName,
                empId+customNos,
                name2+customNos+email,
                role,
                qualification,
                gender,
                bloodGroup,
                reportingTo,
                password,
                dob,
                joiningDate,
                department,
                mobileNumber,
                designation,
                Double.parseDouble(salary),
                location);
    }
    @And("user clicks on add button")
    public void user_clicks_on_add_button(){
        ep.clickAdd();
    }
    @Then("employee should be added successfully")
    public void employee_should_be_added_successfully(){
        String actualMsg=ep.getToastMessage();
//        Assert.assertSame("employee should be added successfully",actualmsg);
        //Assert.assertEquals("Saved Successfully", actualmsg);
        org.testng.Assert.assertEquals(actualMsg,expectedText);

    }
}
