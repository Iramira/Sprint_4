package praktikum;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;
import praktikum.pages.RentPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderSamokatTests {

    public static final By BUTTON_ORDER_IN_HEADER = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    public static final By BUTTON_ORDER_IN_BODY = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");
    // Локатор кнопки "Заказать" в центре страницы

    public final By modalWindow = By.className("Order_Modal__YZ-d3");
    // Локатор кнопки "Посмотреть статус" на странице завершения оформления заказа

    public final By buttonCheckStatus = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    @Rule
    public DriverRule driverRule = new DriverRule();
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

    public OrderSamokatTests(By button, String firstName, String lastName, String address, String metroStation, String phoneNumber, String deliveryDate, int daysRent, String colour, String comment) {
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
                {BUTTON_ORDER_IN_HEADER,"Александр", "Смирнов", "Москва, ул. Тверская, д. 38", "Тверская", "+79988765432", "28.03.2024", 4,"black", "Какой-то комментарий по заказу"},

                {BUTTON_ORDER_IN_BODY,"Мария", "Остапова", "Москва, ул. Большая Дмитровка, д. 12", "Охотный ряд", "+79193981903", "28.03.2024", 1,"black", "Какой-то комментарий по заказу"},

        };
    }
   
    @Before
    public void init() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open();
    }
    @Test
    public void testOrderHeaderButton() {
        OrderPage objOrderPage = new OrderPage(driverRule.getDriver());
        RentPage objRentPage = new RentPage(driverRule.getDriver());
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

        assertTrue(driverRule.getDriver().findElement(modalWindow).isDisplayed());
        assertTrue(driverRule.getDriver().findElement(buttonCheckStatus).isDisplayed());


    }
}
