package praktikum;

import org.junit.Rule;
import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import praktikum.pages.MainPage;
import praktikum.pages.*;

//import java.time.Duration;

public class OrderTest {
    private final String INVALID_ORDER_NUMBER = "123";  // Доп. тестовый сценарий "Неправильный номер заказа"

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void invalidOrderNumber() {
        WebDriver driver = driverRule.getDriver();

        MainPage main = new MainPage(driver)
                .open()
                .clickOnOrderStatus()
                .enterOrderNumber(INVALID_ORDER_NUMBER);

        StatusPage status = main.clickOnGo();
        status.checkNotFound();
    }
}

   // private static void checkNotFound(WebDriver driver) {
       // new WebDriverWait(driver, Duration.ofSeconds(10))
              //  .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[alt='Not found']")));

       // assert driver.findElement(By.cssSelector("[alt='Not found']")).isDisplayed();
    //}

   // private static void clickOnGo(WebDriver driver) {
       // driver.findElement(By.cssSelector("[class*=Header_Button__]")).click();
  //  }

  //  private static void enterOrderNumber(WebDriver driver) {
   //     new WebDriverWait(driver, Duration.ofSeconds(10))
         //       .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Input_Input__1iN_Z")));

       // driver.findElement(By.cssSelector(".Input_Input__1iN_Z")).sendKeys("123");
   // }

   // private static void clickOnOrderStatus(WebDriver driver) {
      //  driver.findElement(By.className("Header_Link__1TAG7")).click();
   // }

   // private static void open(WebDriver driver) {
      //  driver.get("https://qa-scooter.praktikum-services.ru/");
   // }
//}
