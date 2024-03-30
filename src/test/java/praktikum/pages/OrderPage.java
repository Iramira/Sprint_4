package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    // Локатор
    public final By fieldDeliveryDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Поле когда привезти самокат

    public static final By BUTTON_ORDER_IN_HEADER = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    // Локатор кнопки "Заказать" в header страницы

    /** Локатор кнопки "Заказать" в центре страницы */
    public static final By BUTTON_ORDER_IN_BODY = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");

    public final By fieldFirstName = By.xpath(".//input[@placeholder = '* Имя']");
    // Локатор поля "Имя" на странице "Для кого самокат"

    public final By fieldLastName = By.xpath(".//input[@placeholder = '* Фамилия']");
    // Локатор поля "Фамилия" на странице "Для кого самокат"

    public final By fieldAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Локатор поля "Адрес" на странице "Для кого самокат"

    /** Локатор поля "Станция метро" на странице "Для кого самокат" */
    public final By fieldMetroStation = By.className("select-search__input");

    public final By fieldPhoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Локатор поля "Телефон" на странице "Для кого самокат"

    public final By buttonNext = By.cssSelector(".Order_NextButton__1_rCA .Button_Button__ra12g");
    // Локатор кнопки "Далее" на странице "Для кого самокат"

    public final By listOfMetroStation = By.className("select-search__row");
    // Локатор кнопки "Далее" на странице "Для кого самокат"

    public final By buttonCheckStatus = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

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
    public void createOrder (boolean isHeader,String firstName, String lastName, String address, String metroStation, String phoneNumber) {
        clickOnMakeOrderButton(isHeader ? BUTTON_ORDER_IN_HEADER : BUTTON_ORDER_IN_BODY);
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
