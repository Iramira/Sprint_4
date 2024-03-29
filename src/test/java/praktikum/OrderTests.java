package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;
import praktikum.pages.StatusPage;


//import java.timeDuration;
public class OrderTests {
    private final String invalidOrderNumber = "123";  // Доп. тестовый сценарий "Неправильный номер заказа"

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void invalidOrderNumber() {
        WebDriver driver = driverRule.getDriver();

        MainPage main = new MainPage(driver)
                .open()
                .clickOnOrderStatus()
                .enterOrderNumber(invalidOrderNumber);

        StatusPage status = main.clickOnGo();
        status.checkNotFound();
    }
}


