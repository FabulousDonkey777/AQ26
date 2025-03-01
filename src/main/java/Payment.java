import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Payment {
    private WebDriver driver;
    private WebDriverWait wait;
    // Локаторы пустых полей
    private By phonePlaceholder = By.name("connection-phone");
    private By amountPlaceholder = By.name("connection-sum");
    private By emailPlaceholder = By.name("connection-email");
    // Локаторы элементов
    private By blockTitle = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2");
    private By visaLogo = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[1]/img");
    private By mastercardLogo = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[3]/img");
    private By belkartLogo = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[5]/img");
    private By detailsLink = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a");
    private By serviceOptionButton = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private By phoneNumberField = By.xpath("//*[@id='connection-phone']");
    private By amountField = By.xpath("//*[@id='connection-sum']");
    private By emailField = By.xpath("//*[@id='connection-email']");
    private By continueButton = By.xpath("//*[@id='pay-connection']/button");
    private By resultElement = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");

    // Локаторы для вариантов оплаты
    private By servicesLink = By.xpath("//button[contains(text(), 'Услуги связи')]");
    private By homeInternetLink = By.xpath("//button[contains(text(), 'Домашний интернет')]");
    private By installmentLink = By.xpath("//button[contains(text(), 'Рассрочка')]");
    private By debtLink = By.xpath("//button[contains(text(), 'Задолженность')]");

    // Локаторы для проверки данных после нажатия "Продолжить"
    private By payButton = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button");
    private By amountDisplayField = By.xpath("/html/body/div[6]/main/div/div[3]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[2]/input");
    private By phoneDisplayField = By.xpath("/html/body/div[6]/main/div/div[3]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[2]/input");

    // Локаторы для реквизитов карты
    private By cardNumberField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]");
    private By cardExpiryField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]");
    private By cardCvcField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]");
    private By cardOwnerField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]");

    // Локаторы для иконок платежных систем
    private By visaIcon = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]");
    private By mastercardIcon = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]");
    private By belkartIcon = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]");

    public Payment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    // Методы для взаимодействия с элементами
    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public boolean isLogoDisplayed(By logoLocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoLocator)).isDisplayed();
    }

    public void clickDetailsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(detailsLink)).click();
    }

    public void selectServiceOption() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceOptionButton)).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField)).sendKeys(phoneNumber);
    }

    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField)).sendKeys(amount);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public boolean isResultElementDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultElement)).isDisplayed();
    }

    // Методы для проверки надписей в незаполненных полях
    public String getPhonePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phonePlaceholder)).getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountPlaceholder)).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailPlaceholder)).getAttribute("placeholder");
    }

    // Методы для выбора вариантов оплаты
    public void selectServicesLink() {
        wait.until(ExpectedConditions.elementToBeClickable(servicesLink)).click();
    }

    public void selectHomeInternetLink() {
        wait.until(ExpectedConditions.elementToBeClickable(homeInternetLink)).click();
    }

    public void selectInstallmentLink() {
        wait.until(ExpectedConditions.elementToBeClickable(installmentLink)).click();
    }

    public void selectDebtLink() {
        wait.until(ExpectedConditions.elementToBeClickable(debtLink)).click();
    }

    // Методы для проверки данных после нажатия "Продолжить"
    public String getPayButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).getText();
    }

    public String getAmountDisplayFieldValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountDisplayField)).getAttribute("value");
    }

    public String getPhoneDisplayFieldValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneDisplayField)).getAttribute("value");
    }
    // Проверка наличия логотипов
    public By getVisaLogo() {
        return visaLogo;
    }

    public By getMastercardLogo() {
        return mastercardLogo;
    }

    public By getBelkartLogo() {
        return belkartLogo;
    }

    // Методы для проверки реквизитов карты
    public String getCardNumberFieldValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField)).getAttribute("value");
    }

    public String getCardExpiryFieldValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryField)).getAttribute("value");
    }

    public String getCardCvcFieldValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcField)).getAttribute("value");
    }

    public String getCardOwnerFieldValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardOwnerField)).getAttribute("value");
    }

    // Методы для проверки иконок платежных систем
    public boolean isVisaIconDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon)).isDisplayed();
    }


    public boolean isMastercardIconDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardIcon)).isDisplayed();
    }

    public boolean isBelkartIconDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(belkartIcon)).isDisplayed();
    }
}