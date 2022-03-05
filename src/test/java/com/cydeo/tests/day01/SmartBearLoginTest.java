package com.cydeo.tests.day01;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SmartBearLoginTest {

    public static void main(String[] args) {

    /* Task 1: Basic login authentication
        1- Open a Chrome browser
        2- Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        3- Verify title equals:
           Expected: Web Orders Login
        4- Enter username: Tester
        5- Enter password: test
        6- Click “Sign In” button
        7- Verify title equals:
           Expected: Web Orders  */

        String appUrl = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        String userName = "Tester";
        String password = "test";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(appUrl);

        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification before login is passed!");
        } else {
            System.out.println("Title verification before login is failed!");
        }

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        expectedTitle = "Web Orders";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification after login is passed!");
        } else {
            System.out.println("Title verification afdter login is failed!");
        }

        driver.quit();
    }
}

