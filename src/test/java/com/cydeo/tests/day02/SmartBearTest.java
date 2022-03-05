package com.cydeo.tests.day02;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmartBearTest {

    WebDriver driver;

    String appUrl= "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    String userName="Tester";
    String password="test";

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(appUrl);

        String expectedTitle= "Web Orders Login"; // Required title from documentation
        String actualTitle=driver.getTitle(); // Title from Selenium

        assertEquals(actualTitle,expectedTitle,"Before login title did not match!");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    @Test
    public void loginTest() {

        String expectedTitle= "Web Orders";
        String actualTitle=driver.getTitle();

        assertEquals(actualTitle,expectedTitle,"After login title did not match!");
    }

    @Test
    public void checkBoxTest() {

        WebElement paulBox = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        paulBox.click();

        assertTrue(paulBox.isSelected());
        System.out.println(paulBox.isSelected());
        paulBox.click();

        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement eachBox : boxes) {
            eachBox.click();
            assertTrue(eachBox.isSelected());
        }
    }

    @Test
    public void radioButtonTest() {
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();

        WebElement visaButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaButton.click();

        assertTrue(visaButton.isSelected());
    }

    @Test
    public void dropDownTest() {
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();

        WebElement product = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select select = new Select(product);
        select.selectByVisibleText("FamilyAlbum");

        String expectedOption = "FamilyAlbum";
        String actualOption = select.getFirstSelectedOption().getText();

        assertEquals(actualOption, expectedOption, "FamilyAlbum option was not selected.");
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }
}
