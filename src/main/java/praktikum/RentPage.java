package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static praktikum.Locators.*;

public class RentPage {
    private WebDriver driver;
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deliveryDate(String deliveryDate) {
        driver.findElement(fieldDeliveryDate).sendKeys(deliveryDate);
    }
    public void clickRentalPeriod() {
        driver.findElement(fieldOfRentalPeriod).click();
    }
    public void selectRentalPeriod(int days){
        int maxDays = 7;
        int dayIndex;
        if(days > 0 && days <= maxDays) {
            dayIndex = days - 1;
            List<WebElement> dropdownOptions = driver.findElements(listOfRentalPeriod);
            dropdownOptions.get(dayIndex).click();
        }
    }
    public void selectColour(String colour) {
        driver.findElement(By.id(colour)).click();
    }

    public void setComment(String comment) {
        driver.findElement(fieldComment).sendKeys(comment);
    }

    public void clickOnFinalOrderButton() {
        driver.findElement(buttonMakeAnOrder).click();
    }
    public void aboutRent (String deliveryDate,int days,String colour,String comment) {
        deliveryDate(deliveryDate);
        clickRentalPeriod();
        selectRentalPeriod(days);
        selectColour(colour);
        setComment(comment);
    }
    public void clickOnYesButton() {
        driver.findElement(buttonYes).click();
    }
}
