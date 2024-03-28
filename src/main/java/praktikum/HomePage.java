package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


import static praktikum.Locators.buttonOrderInMiddle;


public class HomePage {
    private static WebDriver driver;

    // Локатор
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
//        Метод поиска кнопки "Заказать" в хедере страницы и нажатия на неё

    //        Метод поиска кнопки "Заказать" в середине страницы и нажатия на неё
    public void clickOnMiddleOrderButton() {
        WebElement element = driver.findElement(buttonOrderInMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
}


