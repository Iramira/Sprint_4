package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

;


public class HomePage {
    private WebDriver driver;
    private final By buttonOrderInMiddle = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

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


