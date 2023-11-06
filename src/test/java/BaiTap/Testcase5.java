package BaiTap;

import POM.RegisterPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class Testcase5 {
    public static void Tc5(){
        String firstname ="son";
        String lastname ="nguyen";
        String email_address ="son293526@gmail.com";
        String password ="Nngs@19082003";
        String confirmation = "Nngs@19082003";
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 1. Open target page
            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);
            // Delay Web for Performance

            // 2. Click on my account link
            registerPage.myAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 3. Click Create an Account link and fill New User information excluding the registered Email ID.
            registerPage.createAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // 3a. fill New User information excluding the registered Email ID
            registerPage.enterFirstName(firstname);
            registerPage.enterLastName(lastname);
            registerPage.enterEmailAddress(email_address);
            registerPage.enterPassword(password);
            registerPage.enterPasswordConfirmation(confirmation);

            //4. Click Register
            registerPage.registerButton();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //5. Verify Registration is done. Expected account registration done.
            String vWelcome = ("WELCOME, "+firstname.toUpperCase()+"  "+lastname.toUpperCase()+"!");
            String tWelcome = driver.findElement(By.xpath("//div[1]/p[1]")).getText();
            System.out.println(tWelcome);

            // Catch Error
            try {
                Assert.assertEquals(vWelcome, tWelcome);
            }catch (Exception e) {
                e.printStackTrace();
            }

            // 6. Go To TV Menu
            driver.findElement(By.xpath("(//a[@class='level0 '])[2]")).click();

            // 7. Add product in your wish list - use product - LG LCD
            driver.findElement(By.xpath("//a[@class='link-wishlist']")).click();

            // 8. Click SHARE WISHLIST
            driver.findElement(By.xpath("//button[@class='button btn-share']")).click();

            //9. In next page enter Email and a message and click SHARE WISHLIST
            WebElement typeEmail = driver.findElement(By.id("email_address"));
            typeEmail.clear();
            typeEmail.sendKeys("son293526@gmail.com");

            WebElement typeMess = driver.findElement(By.id("message"));
            typeMess.clear();
            typeMess.sendKeys("hihihi");

            // click SHARE WISHLIST
            driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 10.Check wishlist is shared. Expected wishlist shared successfully.
            WebElement messageWishlist = driver.findElement(By.xpath("//li[@class='success-msg']//li[1]"));
            String expectedMessageWishlist = "Your Wishlist has been shared.";

            try {
                Assert.assertEquals(expectedMessageWishlist, messageWishlist.getText());
            }catch (Exception e) {
                e.printStackTrace();
            }

            // Take Screen shot
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = "D:\\FA23\\SWT\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap";
            FileUtils.copyFile(srcFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Quit browser session
        driver.quit();
    }

}
