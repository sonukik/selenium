package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class CheckOutPage {
    private WebDriver driver;
    By billingFirstName = By.id("billing:firstname");
    By billingMiddleName = By.id("billing:middlename");
    By billingLastName = By.id("billing:lastname");
    By billingCompany = By.id("billing:company");
    By billingAddress = By.id("billing:street1");
    By billingAddress2 = By.id("billing:street2");
    By billingCity = By.id("billing:city");
    By billingState = By.id("billing:region_id");
    By billingZip = By.id("billing:postcode");
    By billingCountry = By.id("billing:country_id");
    By billingTelephone = By.id("billing:telephone");
    By billingFax = By.id("billing:fax");
    By billingContinueButton = By.xpath("//button[@title='Continue']");

    By shippingFirstName = By.id("shipping:firstname");
    By shippingMiddleName = By.id("shipping:middlename");
    By shippingLastName = By.id("shipping:lastname");
    By shippingCompany = By.id("shipping:company");
    By shippingAddress = By.id("shipping:street1");
    By shippingAddress2 = By.id("shipping:street2");
    By shippingCity = By.id("shipping:city");
    By shippingState = By.id("shipping:region_id");
    By shippingZip = By.id("shipping:postcode");
    By shippingCountry = By.id("shipping:country_id");
    By shippingTelephone = By.id("shipping:telephone");
    By shippingFax = By.id("shipping:fax");
    By shippingContinueButton = By.xpath("//button[@class='button']");

    By enterShippingInformation = By.xpath("//h2[text()='Shipping Information']");
    By shippingMethodContinueButton = By.xpath("(//span[text()='Continue'])[3]");
    By checkRadioButton = By.id("p_method_checkmo");
    By paymentContinueButton = By.xpath("(//button[@class='button']//span)[2]");
    By placeOrderButton = By.xpath("//span[text()='Place Order']");


    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setBillingFirstName(String bFirstName) {
        WebElement billingFirstNameElement = driver.findElement(billingFirstName);
        billingFirstNameElement.clear();
        billingFirstNameElement.sendKeys(bFirstName);
    }

    public void setBillingMiddleName(String bMiddleName) {
        WebElement billingMiddleNameElement = driver.findElement(billingMiddleName);
        billingMiddleNameElement.clear();
        billingMiddleNameElement.sendKeys(bMiddleName);
    }

    public void setBillingLastName(String bLastName) {
        WebElement billingLastNameElement = driver.findElement(billingLastName);
        billingLastNameElement.clear();
        billingLastNameElement.sendKeys(bLastName);
    }

    public void setBillingCompany(String bCompany) {
        WebElement billingCompanyElement = driver.findElement(billingCompany);
        billingCompanyElement.clear();
        billingCompanyElement.sendKeys(bCompany);
    }

    public void setBillingAddress(String bAddress) {
        WebElement billingAddressElement = driver.findElement(billingAddress);
        billingAddressElement.clear();
        billingAddressElement.sendKeys(bAddress);
    }

    public void setBillingAddress2(String bAddress2) {
        WebElement billingAddress2Element = driver.findElement(billingAddress2);
        billingAddress2Element.clear();
        billingAddress2Element.sendKeys(bAddress2);
    }

    public void setBillingCity(String bCity) {
        WebElement billingCityElement = driver.findElement(billingCity);
        billingCityElement.clear();
        billingCityElement.sendKeys(bCity);
    }

    public void setBillingState(String bState) {
        WebElement billingStateElement = driver.findElement(billingState);
        billingStateElement.sendKeys(bState);
    }

    public void setBillingZip(String bZip) {
        WebElement billingZipElement = driver.findElement(billingZip);
        billingZipElement.clear();
        billingZipElement.sendKeys(bZip);
    }

    public void setBillingCountry(String bCountry) {
        WebElement billingCountryElement = driver.findElement(billingCountry);
        billingCountryElement.sendKeys(bCountry);
    }

    public void setBillingTelephone(String bTelephone) {
        WebElement billingTelephoneElement = driver.findElement(billingTelephone);
        billingTelephoneElement.clear();
        billingTelephoneElement.sendKeys(bTelephone);
    }

    public void setBillingFax(String bFax) {
        WebElement billingFaxElement = driver.findElement(billingFax);
        billingFaxElement.clear();
        billingFaxElement.sendKeys(bFax);
    }

    public void setBillingContinueButton() {
        driver.findElement(billingContinueButton).click();
    }

    /**************************************/
    // Selling
    public void setShippingFirstName(String sFirstName) {
        WebElement shippingFirstNameElement = driver.findElement(shippingFirstName);
        shippingFirstNameElement.clear();
        shippingFirstNameElement.sendKeys(sFirstName);
    }

    public void setShippingMiddleName(String sMiddleName) {
        WebElement shippingMiddleNameElement = driver.findElement(shippingMiddleName);
        shippingMiddleNameElement.clear();
        shippingMiddleNameElement.sendKeys(sMiddleName);
    }

    public void setShippingLastName(String sLastName) {
        WebElement shippingLastNameElement = driver.findElement(shippingLastName);
        shippingLastNameElement.clear();
        shippingLastNameElement.sendKeys(sLastName);
    }

    public void setShippingCompany(String sCompany) {
        WebElement shippingCompanyElement = driver.findElement(shippingCompany);
        shippingCompanyElement.clear();
        shippingCompanyElement.sendKeys(sCompany);
    }

    public void setShippingAddress(String sAddress) {
        WebElement shippingAddressElement = driver.findElement(shippingAddress);
        shippingAddressElement.clear();
        shippingAddressElement.sendKeys(sAddress);
    }

    public void setShippingAddress2(String sAddress2) {
        WebElement shippingAddress2Element = driver.findElement(shippingAddress2);
        shippingAddress2Element.clear();
        shippingAddress2Element.sendKeys(sAddress2);
    }

    public void setShippingCity(String sCity) {
        WebElement shippingCityElement = driver.findElement(shippingCity);
        shippingCityElement.clear();
        shippingCityElement.sendKeys(sCity);
    }

    public void setShippingState(String sState) {
        WebElement shippingStateElement = driver.findElement(shippingState);
        shippingStateElement.clear();
        shippingStateElement.sendKeys(sState);
    }

    public void setShippingZip(String sZip) {
        WebElement shippingZipElement = driver.findElement(shippingZip);
        shippingZipElement.clear();
        shippingZipElement.sendKeys(sZip);
    }

    public void setShippingCountry(String sCountry) {
        WebElement shippingCountryElement = driver.findElement(shippingCountry);
        shippingCountryElement.sendKeys(sCountry);
    }

    public void setShippingTelephone(String sTelephone) {
        WebElement shippingTelephoneElement = driver.findElement(shippingTelephone);
        shippingTelephoneElement.clear();
        shippingTelephoneElement.sendKeys(sTelephone);
    }

    public void setShippingFax(String sFax) {
        WebElement shippingFaxElement = driver.findElement(shippingFax);
        shippingFaxElement.clear();
        shippingFaxElement.sendKeys(sFax);
    }

    public void setShippingContinueButton() {
        driver.findElement(shippingContinueButton).click();
    }

    // Ohter
    public void setEnterShippingInformation(){driver.findElement(enterShippingInformation).click();}

    public void setShippingMethodContinueButton() {
        driver.findElement(shippingMethodContinueButton).click();
    }

    public void setCheckRadioButton() {
        driver.findElement(checkRadioButton).click();
    }

    public void setPaymentContinueButton() {
        driver.findElement(paymentContinueButton).click();
    }

    public void setPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }
}
