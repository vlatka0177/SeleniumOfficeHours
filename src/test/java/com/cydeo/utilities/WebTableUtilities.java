package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class WebTableUtilities {

    /* Method #1 info:
       • Name: returnOrderDate ()
       • Return type: String
       • Arg1: WebDriver driver
       • Arg2: String customerName
       This method should accept a customerName and return the customer order date as a String. */

    public static String returnOrderDate(WebDriver driver, String customerName) {

        String locator = "//td[.='" + customerName + "']/following-sibling::td[3]";

        WebElement customerDateCell = driver.findElement(By.xpath(locator));
        return customerDateCell.getText();
    }

    /* Method #2 info:
       • Name: orderVerify ()
       • Return type: void
       • Arg1: WebDriver driver
       • Arg2: String costumerName
       • Arg3: String expectedOrderDate
       This method should accept the above-mentioned arguments and internally assert that expectedOrderDate
       matches actualOrderDate.  */

    public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate) {

        String locator = "//td[.='" + customerName + "']/following-sibling::td[3]";

        WebElement customerDateCell = driver.findElement(By.xpath(locator));

        String actualOrderDate = customerDateCell.getText();

        assertEquals(actualOrderDate, expectedOrderDate);
    }
}
