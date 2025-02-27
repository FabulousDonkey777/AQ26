import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;

public class MtsByTests {
    private static WebDriver driver;
    private static Payment payment;

    @BeforeAll
    public static void setUp() {
        // Настройка ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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

        // Инициализация PageObject
        payment = new Payment(driver);
    }

    @Test
    public void testBlockTitle() {
        String actualTitle = payment.getBlockTitle();
        assertEquals("Онлайн пополнение без комиссии", actualTitle, "Название блока не совпадает");
    }

    @Test
    public void testLogos() {
        assertTrue(payment.isLogoDisplayed(payment.getVisaLogo()), "Логотип Visa отсутствует");
        assertTrue(payment.isLogoDisplayed(payment.getMastercardLogo()), "Логотип Mastercard отсутствует");
        assertTrue(payment.isLogoDisplayed(payment.getBelkartLogo()), "Логотип Белкарт отсутствует");
    }

    @Test
    public void testLink() {
        payment.clickDetailsLink();
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"), "Перенаправление на страницу с подробностями не произошло");
    }


    @Test
    public void ServiceLink() {
        // Выбор варианта "Домашний интернет"
        payment.selectHomeInternetLink();

        // Проверка placeholder для номера телефона
        assertEquals("Номер телефона", payment.getPhonePlaceholder(), "Текст placeholder не совпадает для номера телефона (Домашний интернет)");

        // Проверка placeholder для суммы
        assertEquals("Сумма", payment.getAmountPlaceholder(), "Текст placeholder не совпадает для суммы (Домашний интернет)");

        // Проверка placeholder для email
        assertEquals("Email", payment.getEmailPlaceholder(), "Текст placeholder не совпадает для email (Домашний интернет)");
    }

    @Test
    public void testHomeInternetPlaceholders() {
        // Выбор варианта "Домашний интернет"
        payment.selectHomeInternetLink();

        // Проверка placeholder для номера телефона
        assertEquals("Номер телефона", payment.getPhonePlaceholder(), "Текст placeholder не совпадает для номера телефона (Домашний интернет)");

        // Проверка placeholder для суммы
        assertEquals("Сумма", payment.getAmountPlaceholder(), "Текст placeholder не совпадает для суммы (Домашний интернет)");

        // Проверка placeholder для email
        assertEquals("Email", payment.getEmailPlaceholder(), "Текст placeholder не совпадает для email (Домашний интернет)");
    }

    @Test
    public void testInstallmentPlaceholders() {
        // Выбор варианта "Рассрочка"
        payment.selectInstallmentLink();

        // Проверка placeholder для номера телефона
        assertEquals("Номер телефона", payment.getPhonePlaceholder(), "Текст placeholder не совпадает для номера телефона (Рассрочка)");

        // Проверка placeholder для суммы
        assertEquals("Сумма", payment.getAmountPlaceholder(), "Текст placeholder не совпадает для суммы (Рассрочка)");

        // Проверка placeholder для email
        assertEquals("Email", payment.getEmailPlaceholder(), "Текст placeholder не совпадает для email (Рассрочка)");
    }

    @Test
    public void testDebtPlaceholders() {
        // Выбор варианта "Задолженность"
        payment.selectDebtLink();

        // Проверка placeholder для номера телефона
        assertEquals("Номер телефона", payment.getPhonePlaceholder(), "Текст placeholder не совпадает для номера телефона (Задолженность)");

        // Проверка placeholder для суммы
        assertEquals("Сумма", payment.getAmountPlaceholder(), "Текст placeholder не совпадает для суммы (Задолженность)");

        // Проверка placeholder для email
        assertEquals("Email", payment.getEmailPlaceholder(), "Текст placeholder не совпадает для email (Задолженность)");
    }
    @Test
    public void testButton() {
        payment.selectServiceOption();
        payment.enterPhoneNumber("297777777");
        payment.enterAmount("20");
        payment.enterEmail("test@example.com");
        payment.clickContinueButton();
        assertTrue(payment.isResultElementDisplayed(), "Поле не найдено или не отображается");
    }

    @Test
    public void testPaymentDetailsAfterContinue() {
        // Выбор варианта "Услуги связи"
        payment.selectServicesLink();

        // Заполнение полей
        payment.enterPhoneNumber("297777777");
        payment.enterAmount("20");
        payment.enterEmail("test@example.com");

        // Нажатие кнопки "Продолжить"
        payment.clickContinueButton();

        // Проверка корректности отображения суммы на кнопке "Оплатить"
        String payButtonText = payment.getPayButtonText();
        assertTrue(payButtonText.contains("20"), "Сумма на кнопке 'Оплатить' не совпадает");

        // Проверка корректности отображения суммы в поле
        String amountDisplayValue = payment.getAmountDisplayFieldValue();
        assertEquals("20", amountDisplayValue, "Сумма в поле не совпадает");

        // Проверка корректности отображения номера телефона
        String phoneDisplayValue = payment.getPhoneDisplayFieldValue();
        assertEquals("297777777", phoneDisplayValue, "Номер телефона в поле не совпадает");

        // Проверка реквизитов карты
        assertEquals("1234 5678 9012 3456", payment.getCardNumberFieldValue(), "Номер карты не совпадает");
        assertEquals("12/25", payment.getCardExpiryFieldValue(), "Срок действия карты не совпадает");
        assertEquals("123", payment.getCardCvcFieldValue(), "CVC карты не совпадает");
        assertEquals("IVAN IVANOV", payment.getCardOwnerFieldValue(), "Имя владельца карты не совпадает");

        // Проверка наличия иконок платежных систем
        assertTrue(payment.isVisaIconDisplayed(), "Иконка Visa отсутствует");
        assertTrue(payment.isMastercardIconDisplayed(), "Иконка Mastercard отсутствует");
        assertTrue(payment.isBelkartIconDisplayed(), "Иконка Белкарт отсутствует");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}