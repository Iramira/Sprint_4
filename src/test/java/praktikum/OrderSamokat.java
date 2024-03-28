package praktikum;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import praktikum.pages.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.Locators.*;

@RunWith(Parameterized.class)
public class OrderSamokat {
    private WebDriver driver;
    private final By button;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String metroStation;
    private final String deliveryDate;
    private final String comment;
    private final int daysRent;
    private final String colour;

    public OrderSamokat(By button, String firstName, String lastName, String address, String metroStation, String phoneNumber, String deliveryDate, int daysRent, String colour, String comment) {
        this.button = button;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metroStation = metroStation;
        this.deliveryDate = deliveryDate;
        this.daysRent = daysRent;
        this.colour = colour;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {buttonOrderInHeader,"Александр", "Смирнов", "Москва, ул. Тверская, д. 38", "Тверская", "+79988765432", "28.03.2024", 4,"black", "Какой-то комментарий по заказу"},

                {buttonOrderInHeader,"Мария", "Остапова", "Москва, ул. Большая Дмитровка, д. 12", "Охотный ряд", "+79193981903", "28.03.2024", 1,"black", "Какой-то комментарий по заказу"},

        };
    }
   
    @Before
    public void init() {

        driver = new FirefoxDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }
    @Test
    public void testOrderHeaderButton() {
        OrderPage objOrderPage = new OrderPage(driver);
        RentPage objRentPage = new RentPage(driver);
        objOrderPage.createOrder(
                button,
                firstName,
                lastName,
                address,
                metroStation,
                phoneNumber);
        objOrderPage.clickOnNextButton();
        objRentPage.aboutRent(
                deliveryDate,
                daysRent,
                colour,
                comment);
        objRentPage.clickOnFinalOrderButton();
        objRentPage.clickOnYesButton();
        assertTrue(driver.findElement(modalWindow).isDisplayed());
        assertTrue(driver.findElement(buttonCheckStatus).isDisplayed());


    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
