package com.cydeo.tests.day02;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void confirmAlertTest() {
        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirmBtn.click();

        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String expected = "You clicked: Ok";
        String actual = result.getText();
        assertEquals(actual, expected, "Text result was not correct.");
    }

    @Test
    public void promptAlertTest() {
        WebElement jsPromptBtn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPromptBtn.click();

        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("hello");
        promptAlert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String expected = "You entered: hello";
        String actual = result.getText();
        assertEquals(actual, expected, "Prompt Alert result was not correct");
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }
}
