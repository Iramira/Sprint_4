package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MainPage {
    private final WebDriver driver;
    private final By goButton = By.cssSelector("[class*=Header_Button__]");
    private final By orderField = By.cssSelector(".Input_Input__1iN_Z"); // Для доп.тестового сценария (неправильный номер заказа).
    private final By orderStatusField = By.className("Header_Link__1TAG7"); // Для доп.тестового сценария (неправильный номер заказа).

    private final By faqHeader = By.className("Home_SubHeader__zwi_E");

    private final String faqQuestion = "accordion__heading-";  // Вопросы в разделе «Вопросы о важном»

    private final String faqAnswer = "accordion__panel-";  // Ответы в разделе «Вопросы о важном»

    private final By cookieButton = By.id("rcc-confirm-button");  // Для закрытия окна с куки

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkNotFound() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[alt='Not found']")));

        assertTrue(driver.findElement(By.cssSelector("[alt='Not found']")).isDisplayed());
    }

    public StatusPage clickOnGo() {
        driver.findElement(goButton).click();

        return new StatusPage(driver);
    }

    public MainPage enterOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderField));

        driver.findElement(orderField).sendKeys(orderNumber);

        return this;
    }

    public MainPage clickOnOrderStatus() {
        driver.findElement(orderStatusField).click();

        return this;
    }

    public MainPage scrollToFaq() {

        WebElement faqHeaderElement = driver.findElement(faqHeader);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", faqHeaderElement);

        return this;
    }


    public MainPage clickFaqQuestion(int questionId) {
        WebElement questionElement = driver.findElement(By.id(faqQuestion + questionId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionElement);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(questionElement));
        questionElement.click();

        return this;

    }

    public boolean isFaqAnswerDisplayed(int answerId) {
        WebElement faqAnswerElement  = driver.findElement(By.id(faqAnswer + answerId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", faqAnswerElement);
        return faqAnswerElement.isDisplayed();

    }

    public String getQuestionText(String questionId) {
        return driver.findElement(By.id(faqQuestion + questionId)).getText();

    }

    public String getAnswerText(int answerId) {
        return driver.findElement(By.id(faqAnswer + answerId)).getText();

    }

    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);
        driver.manage().window().maximize();
        driver.findElement(cookieButton).click();  // Закрыть окно с куки

        return this;
    }


}


