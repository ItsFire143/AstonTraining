package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.util.List;
import java.util.stream.Collectors;

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

    public void ClosePupUp(WebDriver driver) {
        try {
            WebElement testElement = driver.findElement(By.cssSelector(".header__close-button"));
        } catch (NoSuchElementException e) {
            WebElement frame = driver.findElement(By.cssSelector("iframe[src*='widget_v2']"));
            driver.switchTo().frame(frame);
        }

        WebElement closeButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header__close-button")));

        Actions actions = new Actions(driver);
        actions.moveToElement(closeButton, 5, 5).click().perform();
        driver.switchTo().defaultContent();
    }

    public void enterPhoneNumber(String phone) {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterAmount(String amount) {
        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void submitPaymentForm() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection .button")));
        submitButton.click();
    }

    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[src*='widget_v2']")));
    }

    public String getDisplayedAmountFromFrame() {
        WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.pay-description__cost span")));
        return amount.getText().trim();
    }

    public String getPayButtonAmountFromFrame() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.colored")));
        return button.getText().trim();
    }

    public String getPhoneInfoFromFrame() {
        WebElement info = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.pay-description__text span")));
        return info.getText().trim();
    }

    public String getCardNumberLabelText() {
        WebElement input = driver.findElement(By.cssSelector("input#cc-number"));
        WebElement label = input.findElement(By.xpath("following-sibling::label"));
        return label.getText().trim();
    }

    public String getExpirationDateLabelText() {
        WebElement input = driver.findElement(By.cssSelector("input[formcontrolname='expirationDate']"));
        WebElement label = input.findElement(By.xpath("following-sibling::label"));
        return label.getText().trim();
    }

    public String getCvcLabelText() {
        WebElement input = driver.findElement(By.cssSelector("input[formcontrolname='cvc']"));
        WebElement label = input.findElement(By.xpath("following-sibling::label"));
        return label.getText().trim();
    }

    public String getHolderLabelText() {
        WebElement input = driver.findElement(By.cssSelector("input[formcontrolname='holder']"));
        WebElement label = input.findElement(By.xpath("following-sibling::label"));
        return label.getText().trim();
    }

    public List<String> getCardIconSources() {
        List<WebElement> icons = driver.findElements(By.cssSelector(".cards-brands__container img"));
        return icons.stream().map(el -> el.getAttribute("src")).collect(Collectors.toList());
    }
}