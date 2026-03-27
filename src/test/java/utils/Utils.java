package utils;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;



public class Utils {
    WebDriver driver;
  public int randomMethod(){
      Random robj=new Random();
      return robj.nextInt(10000);
  }
    public Utils(WebDriver driver){
        this.driver=driver;
    }
    public void visibilityOfElement(By locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void elementToBeClickable(By locator){
      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
      wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void screenshotMethod() throws IOException {
//        Random robj=new Random();
//        int customcount=robj.nextInt(100);
//        uobj=new Utils(driver);
        int customValue=randomMethod();
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File dest=new File("src/test/screenshotss/"+"Scrshot"+System.currentTimeMillis()+customValue+".png");
        FileHandler.copy(src,dest);
    }
    static String path=System.getProperty("user.dir")+"/src/test/resources/testdata/Excelfile.xlsx";
    static Workbook workbook;
    static Sheet sheet;
    public static void ExcelReader() throws IOException {
        FileInputStream fis=new FileInputStream(path);
        workbook= WorkbookFactory.create(fis);
        sheet=workbook.getSheet("Sheet2");
    }
    public static int getRowCount(){
        return sheet.getLastRowNum();
    }
    public static String getExcelData(int row,int col){
        Row r= sheet.getRow(row);
        Cell c=r.getCell(col);
//        return c.getStringCellValue();
        return new org.apache.poi.ss.usermodel.DataFormatter().formatCellValue(c);
    }
}
