package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.Locators.*;

public class OrderPage {
    private WebDriver driver;

    // Локатор

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnMakeOrderButton(By button) {
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void setFirstName(String firstName) {
        driver.findElement(fieldFirstName).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        driver.findElement(fieldLastName).sendKeys(lastName);
    }
    public void setAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
    }
    public void setMetroStation(String metroStation) {
        driver.findElement(fieldMetroStation).sendKeys(metroStation);
        WebElement optionsCont = driver.findElement(listOfMetroStation);
        optionsCont.click();
    }
    public void clickOnNextButton() {
        driver.findElement(buttonNext).click();
    }
    public void createOrder (By button,String firstName, String lastName, String address, String metroStation, String phoneNumber) {
        clickOnMakeOrderButton(button);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
    }
    public void clickOnButtonCheckStatus() {
        driver.findElement(buttonCheckStatus);
    }
}
