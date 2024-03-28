package praktikum;

import org.openqa.selenium.By;

public class Locators {
    // Локатор стрелки в блоке "Вопросы о важном"
    public static final By buttonShowAnswer = By.className("accordion__button");
    // Локатор кнопки "Заказать" в хедере страницы
    public static final By buttonOrderInHeader = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    // Локатор кнопки "Заказать" в центре страницы
    public static final By buttonOrderInMiddle = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    // Локатор поля "Фамилия" на странице "Для кого самокат"
    public static final By fieldFirstName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    // Локатор поля "Имя" на странице "Для кого самокат"
    public static final By fieldLastName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // Локатор поля "Адрес" на странице "Для кого самокат"
    public static final By fieldAddress = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // Локатор поля "Станция метро" на странице "Для кого самокат"
    public static final By fieldMetroStation = By.className("select-search__input");
    // Локатор списка станций метро в поле "Станция метро" на странице "Для кого самокат"
    public static final By listOfMetroStation = By.className("select-search__row");
    // Локатор поля "Телефон" на странице "Для кого самокат"
    public static final By fieldPhoneNumber = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // Локатор кнопки "Далее" на странице "Для кого самокат"
    public static final By buttonNext = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    // Локатор поля "Когда привезти самокат" на странице "Про аренду"
    public static final By fieldDeliveryDate = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    // Локатор поля "Когда Срок аренды" на странице "Про аренду"

    public static final By fieldOfRentalPeriod = By.className("Dropdown-arrow");
    // Локатор списка "Срок аренды" на странице "Про аренду"
    public static final By listOfRentalPeriod = By.className("Dropdown-option");
    // Локатор поля "Комментарий" на странице "Про аренду"
    public static final By fieldComment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    // Локатор кнопки "Заказать" на странице "Про аренду"
    public static final By buttonMakeAnOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    // Локатор кнопки "Да" в модальном окне "Хотите сделать заказ?"
    public static final By buttonYes = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    // Локатор модального окна "Заказ оформлен"
    public static final By modalWindow = By.className("Order_Modal__YZ-d3");
    // Локатор кнопки "Посмотреть статус" на странице завершения оформления заказа
    public static final By buttonCheckStatus = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
}
