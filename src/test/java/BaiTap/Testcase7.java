package BaiTap;

import POM.LoginPage;
import POM.OrderPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

@Test

public class Testcase7 {
    public static void tc7(){
        String email_address = "son293526@gmail.com";
        String password = "Nngs@19082003";

        //  Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();

        // import function from POM
        LoginPage loginPage = new LoginPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        try {
            // 1. Open target page
            driver.get("http://live.techpanda.org/");
            // Delay Web for Performance

            // 2. Click on my account link
            loginPage.myAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 3.Login in application using previously created credential
            loginPage.enterEmailAddress(email_address);
            loginPage.enterPassword(password);

            // 3a. Click Login
            loginPage.loginButton();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 4.Click on 'My Orders'
            orderPage.setMyOrderLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 5.Click on 'View Order'
            orderPage.setViewOrderLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //6.Click on 'Print Order' link
            orderPage.setPrintOrderLink();

            // Take Screen shot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png = "D:\\FA23\\SWT\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap";
            FileUtils.copyFile(srcFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Quit browser session
        driver.quit();
    }
}
