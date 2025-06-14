package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void fillPhoneAmount(String phone, String amount) throws InterruptedException {
        Select select = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pay"))));
        select.selectByVisibleText("Услуги связи");

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#connection-phone")));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        Thread.sleep(1000);

        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#connection-sum")));
        amountInput.clear();
        amountInput.sendKeys(amount);
        Thread.sleep(1000);
    }

    public void submitPayment() throws InterruptedException {
        WebElement continueBut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form#pay-connection button[type='submit']")));
        continueBut.click();
        Thread.sleep(3000);
    }

    public boolean isPaymentFormVisible() {
        try {
            WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form#pay-connection")));
            return form.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

}
