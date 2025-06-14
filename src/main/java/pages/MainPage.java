package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void acceptCookies() {
        try {
            WebElement cookie = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.cookie.show")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cookie);
            WebElement acceptBut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#cookie-agree")));
            acceptBut.click();
            wait.until(ExpectedConditions.invisibilityOf(cookie));
        } catch (TimeoutException e) {
            System.out.println("Куки не появилось");
        }
    }

    public String getPaymentTitleText() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.pay h2")));
        return title.getText().replace("\n", " ").trim();
    }

    public boolean arePaymentLogosVisible() {
        try {
            return !wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'pay__partners')]//img"))).isEmpty();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickMoreAboutService() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Подробнее")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        link.click();
    }

    public void waitForHomePage() {
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/"));
    }
}
