package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class RentPage {
    private WebDriver driver;
    public final By fieldDeliveryDate = By.cssSelector(".Order_MixedDatePicker__3qiay .Input_Input__1iN_Z");
    //Поле когда привезти самокат

    public final By fieldOfRentalPeriod = By.className("Dropdown-arrow");
    // Локатор списка "Срок аренды" на странице "Про аренду"

    public final By listOfRentalPeriod = By.className("Dropdown-option");
    // Локатор поля "Комментарий" на странице "Про аренду"

    public final By fieldComment = By.cssSelector(".Input_InputContainer__3NykH .Input_Input__1iN_Z.Input_Responsible__1jDKN");
    // Локатор кнопки "Заказать" на странице "Про аренду"

    public final By buttonMakeAnOrder = By.xpath(".//*[text() = 'Заказать' and contains(@class, 'Button_Middle__1CSJM')]");
    // Локатор кнопки "Да" в модальном окне "Хотите сделать заказ?"

    public final By buttonYes = By.xpath(".//*[text() = 'Да']");
    // Локатор модального окна "Заказ оформлен"

    public final By modalWindow = By.className("Order_Modal__YZ-d3");
    // Локатор кнопки "Посмотреть статус" на странице завершения оформления заказа

    public final By buttonCheckStatus = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

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


    public void checkState () {

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(buttonYes));

        boolean modalWindowDisplayed = driver.findElement(modalWindow).isDisplayed();
        boolean buttonCheckStatusDisplayed = driver.findElement(buttonCheckStatus).isDisplayed();
        String modalWindowText = driver.findElement(modalWindow).getAttribute("innerText");
        boolean orderConfirmationTextPresent = modalWindowText.contains("Заказ оформлен");


        assertTrue("Модальное окно не отображается", modalWindowDisplayed);
        assertTrue("Кнопка 'Посмотреть статус' не отображается", buttonCheckStatusDisplayed);
        assertTrue("Текст 'Заказ оформлен' отсутствует в модальном окне", orderConfirmationTextPresent);
    }

}

