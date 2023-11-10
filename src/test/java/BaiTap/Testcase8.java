package BaiTap;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

@Test

public class Testcase8 {
    public static void tc08() {
        String email_address = "son293526@gmail.com";
        String password = "Nngs@19082003";
        String cartCountry = "Turkey";
        String cartRegion = "Kayseri";
        String cartPostCode = "70000";

        //CheckOutPage
        String firstname = "son";
        String lastname = "nguyen";
        String company = "G2 sieu dang";
        String address = "69/69 Tran Hung Dao";
        String address2 = "25/12/2 Hoang Van Thu";
        String city = "Sai Gon";

        String state = "Texas";
        String zip = "700000";

        String country = "United States";
        String telephone = "152663622";
        String fax = " 15151";

        String qty = "10";
        //  Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();

        // import function from POM
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);

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

            // 4.Click on 'REORDER' link , change QTY & click Update
            cartPage.setReOrderLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // belong to 4. ( take first value)
            WebElement firstValues = driver
                    .findElement(By.xpath("//td[@class='a-right']//span"));
            String grandTotalFirstValues = firstValues.getText();

            // 4a.change QTY
            cartPage.setEnterQTY(qty);

            //4b. click Update
            cartPage.setUpdateQTYButton();

            //Verify Grand Total is changed
            WebElement secondValues = driver
                    .findElement(By.xpath("//td[@class='a-right']//span"));
            String grandTotalSecondValues = secondValues.getText();
            Assert.assertNotEquals("Grand Total price not match", grandTotalFirstValues, grandTotalSecondValues);

            // 4c. Click "Proceed to Checkout"
            cartPage.setCheckOutProccess();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //6a. Enter Billing Information, and click Continue

            //Use new Address
            driver.findElement(By.id("billing-address-select")).sendKeys("New Address");

            checkOutPage.setBillingFirstName(firstname);
            checkOutPage.setBillingLastName(lastname);
            checkOutPage.setBillingCompany(company);
            checkOutPage.setBillingAddress(address);
            checkOutPage.setBillingAddress2(address2);
            checkOutPage.setBillingCity(city);
//            checkOutPage.setBillingState(state);
            checkOutPage.setBillingZip(zip);
//            checkOutPage.setBillingCountry(country);
            checkOutPage.setBillingTelephone(telephone);
            checkOutPage.setBillingFax(fax);
            checkOutPage.setBillingContinueButton();
            Thread.sleep(2000);

            //12b. Enter Shipping Information, and click Continue
            checkOutPage.setEnterShippingInformation();
            Thread.sleep(1000);
            driver.findElement(By.id("shipping-address-select")).sendKeys("New Address");

            checkOutPage.setShippingFirstName(firstname);
            checkOutPage.setShippingLastName(lastname);
            checkOutPage.setShippingCompany(company);
            checkOutPage.setShippingAddress(address);
            checkOutPage.setShippingAddress2(address2);
            checkOutPage.setShippingCity(city);
//            checkOutPage.setShippingState(state);
            checkOutPage.setShippingZip(zip);
//            checkOutPage.setShippingCountry(country);
            checkOutPage.setShippingTelephone(telephone);
            checkOutPage.setShippingFax(fax);
            checkOutPage.setShippingContinueButton();
            Thread.sleep(3000);

            //13.In Shipping Method, Click Continue
            checkOutPage.setShippingMethodContinueButton();
            Thread.sleep(2000);

            //14.In Payment Information select 'Check/Money Order' radio button. Click Continue
            checkOutPage.setCheckRadioButton();
            checkOutPage.setPaymentContinueButton();
            Thread.sleep(2000);

            //15.Click 'PLACE ORDER' button
            checkOutPage.setPlaceOrderButton();
            Thread.sleep(2000);

            //16.Verify Oder is generated. Note the order number

            // Verify if the order is generated
            WebElement yourOrder = driver.findElement(By.xpath("//h1[text()='Your order has been received.']"));
            String expectedOrder = "YOUR ORDER HAS BEEN RECEIVED.";
            String orderNumber = "";

            try {
                Assert.assertEquals(expectedOrder, yourOrder.getText());

                // Get the order number
                WebElement orderNumberElement = driver.findElement(By.xpath("//div[@class='col-main']//a"));
                orderNumber = orderNumberElement.getText();

                // Print the order number
                System.out.println("Order Number: " + orderNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }

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
