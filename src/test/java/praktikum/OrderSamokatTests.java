package praktikum;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;
import praktikum.pages.RentPage;

@RunWith(Parameterized.class)

public class OrderSamokatTests {

    @Rule
    public DriverRule driverRule = new DriverRule();
    private final boolean isHeader;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String metroStation;
    private final String deliveryDate;
    private final String comment;
    private final int daysRent;
    private final String colour;

    public OrderSamokatTests(boolean isHeader, String firstName, String lastName, String address, String metroStation, String phoneNumber, String deliveryDate, int daysRent, String colour, String comment) {
        this.isHeader = isHeader;
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
                {true,"Александр", "Смирнов", "Москва, ул. Тверская, д. 38", "Тверская", "+79988765432", "28.03.2024", 4,"black", "Какой-то комментарий по заказу"},

                {false,"Мария", "Остапова", "Москва, ул. Большая Дмитровка, д. 12", "Охотный ряд", "+79193981903", "28.03.2024", 1,"black", "Какой-то комментарий по заказу"},

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
                isHeader,
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

        // После нажатия кнопки "Да" проверяем состояние модального окна
        objRentPage.checkState();

    }
}

