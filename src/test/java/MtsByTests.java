
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class MtsByTests {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Настройка ChromeDriver с помощью WebDriverManager
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

        // Создание экземпляра ChromeDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");

        // Закрытие всплывающего окна с согласием на cookie (если есть)
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]")));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Всплывающее окно с согласием на cookie не найдено или не удалось закрыть.");
        }
    }

    @Test
    public void testBlockTitle() {
        // Ожидание появления элемента с названием блока
        WebDriverWait wait = new WebDriverWait(driver, 30);


        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2")));

        String actualTitle = blockTitle.getText();
        System.out.println("Оригинал: " + actualTitle);

        // Проверка названия блока
        String expectedTitle = "Онлайн пополнение без комиссии";
        assertEquals(expectedTitle, actualTitle, "Название блока не совпадает");
    }
    @Test
    public void testLogos() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Проверка наличия лого
        WebElement visaLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[1]/img")));
        WebElement mastercardLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[3]/img")));
        WebElement belkartLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[5]/img")));

        // Проверка отображения лого
        assertTrue(visaLogo.isDisplayed(), "Логотип Visa отсутствует");
        assertTrue(mastercardLogo.isDisplayed(), "Логотип Mastercard отсутствует");
        assertTrue(belkartLogo.isDisplayed(), "Логотип Белкарт отсутствует");
    }
    @Test
    public void testLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //  Ссыль "Подробнее о сервисе"
        WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a")));

        // Кликаем
        detailsLink.click();

        // Ожидаем изменения URL
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty")); // Ожидаем, что URL содержит "poryadok-oplaty"

        // Проверяем, что URL изменился на ожидаемый
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"; // Ожидаемый URL
        String actualUrl = driver.getCurrentUrl(); // Текущий URL
        assertEquals(expectedUrl, actualUrl, "Перенаправление на страницу с подробностями не произошло или URL не совпадает");
    }

    @Test
    public void testButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Увеличено время ожидания

        // Выбор  «Услуги связи»
        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")
        ));
        serviceOption.click();

        // Ввод номера телефона
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='connection-phone']")
        ));
        phoneNumberField.sendKeys("297777777");

        // Ввод суммы
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='connection-sum']")
        ));
        amountField.sendKeys("20"); // Пример суммы: 20 рублей

        // Ввод email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='connection-email']")
        ));
        emailField.sendKeys("test@example.com");
        // Клик по кнопке  «Продолжить»
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-connection']/button")
        ));
        continueButton.click();

        // Ожидание появления поля c указанным номером и оплачиваемым форматом услуг
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span")));
        assertTrue(resultElement.isDisplayed(), "Поле не найдено или не отображается");
    }

    @AfterAll
    public static void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
