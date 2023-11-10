package BaiTap;

import POM.IndexPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Testcase9 {
    public static void tc09(){
        //LoginPage
        String coupon = "GURU50";
        //  Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();

        // import function from POM
        IndexPage indexPage = new IndexPage(driver);
        try{
            // 1. Open target page
            driver.get("http://live.techpanda.org/");
            // Delay Web for Performance

            // 2. Go to Mobile and add IPHONE to cart
            indexPage.setMobileLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 2a.add IPHONE to cart
            indexPage.setAddToCartLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // belong to 3. ( take first value)
            String firstPrice = driver
                    .findElement(By.xpath("//td[@class='a-right']//span")).getText();
            // 3.Enter Coupon Code
            indexPage.setEnterCouponCode(coupon);
            indexPage.setApplyLink();

            //Verify Grand Total is changed
            String secondPrice = driver
                    .findElement(By.xpath("//td[@class='a-right']//span")).getText();
            //second.getText();
            Assert.assertNotEquals(firstPrice, secondPrice);

        } catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
