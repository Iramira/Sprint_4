package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class RentPage {
    private WebDriver driver;
    public final By fieldDeliveryDate = By.cssSelector(".Order_MixedDatePicker__3qiay .Input_Input__1iN_Z");
    //Поле когда привезти самокат

    public final By fieldOfRentalPeriod = By.className("Dropdown-arrow");
    // Локатор списка "Срок аренды" на странице "Про аренду"

    public final By listOfRentalPeriod = By.className("Dropdown-option");
    // Локатор поля "Комментарий" на странице "Про аренду"

    public final By fieldComment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    // Локатор кнопки "Заказать" на странице "Про аренду"

    public final By buttonMakeAnOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    // Локатор кнопки "Да" в модальном окне "Хотите сделать заказ?"

    public final By buttonYes = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    // Локатор модального окна "Заказ оформлен"

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
