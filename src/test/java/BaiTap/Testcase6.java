package BaiTap;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class Testcase6 {

    public void purchaseProductWithRegisteredEmail() {
        String email_address = "son293526@gmail.com";
        String password = "Nngs@19082003";
        String cartCountry = "Turkey";
        String cartRegion = "Kayseri";
        String cartPostCode = "2000";

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

            // 4.Click on MY WISHLIST link
            cartPage.setWishListLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 5.In next page, Click ADD TO CART link
            cartPage.setAddToCartLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //6.Enter general shipping country, state/province and zip for the shipping cost estimate
            cartPage.setEnterCountry(cartCountry);

            cartPage.setEnterRegion(cartRegion);

            cartPage.setEnterPostCode(cartPostCode);

            //7.Click Estimate
            cartPage.setEstimateLink();

            // 8.Verify Shipping cost generated
            WebElement shippingCost = driver.findElement(By.xpath("//dt[text()='Flat Rate']"));
            String expectedshippingCost = "Flat Rate";
            try {
                Assert.assertEquals(expectedshippingCost, shippingCost.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }

            //9.Select Shipping Cost, Update Total
            cartPage.setChooseShippingCost();
            // Click Update Total
            cartPage.setUpdateTotal();

            // 10.Verify shipping cost is added to total.
            WebElement shippingVsHandlingCost = driver.findElement(By.xpath("//td[text()[normalize-space()='Shipping & Handling (Flat Rate - Fixed)']]"));
            String expectedshippingVsHandlingCost = "SHIPPING & HANDLING (FLAT RATE - FIXED)";
            try {
                Assert.assertEquals(expectedshippingVsHandlingCost, shippingVsHandlingCost.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 11. Click "Proceed to Checkout"
            cartPage.setCheckOutProccess();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //12a. Enter Billing Information, and click Continue

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

