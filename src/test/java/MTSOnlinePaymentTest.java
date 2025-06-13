import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.testng.Assert;
import java.util.List;

public class MTSOnlinePaymentTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.mts.by");

        acceptCookies();
    }

    private void acceptCookies() {
        try {
            WebElement cookieBlock = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.cookie.show")));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", cookieBlock);

            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#cookie-agree")));
            acceptButton.click();

            wait.until(ExpectedConditions.invisibilityOf(cookieBlock));
            System.out.println("Куки закрыто");

        } catch (TimeoutException e) {
            System.out.println("Куки не появилось");
        }
    }

    @Test(priority = 1)
    public void testTitleBlock(){
        try {
            WebElement titleBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.pay h2")));
            String blockText = titleBlock.getText().replace("/n", " ").trim();
            System.out.println("Заголовок " + blockText);
            Assert.assertTrue(blockText.contains("Онлайн пополнение"), "Заголовок не найден");
            Assert.assertTrue(blockText.contains("без комиссии"), "Заголовое не найден");
        } catch (TimeoutException e) {
            Assert.fail("Не удалось найти блок с заголовком: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testPaymentLogo(){
        try {
            List<WebElement> logos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'pay__partners')]//img")));
            Assert.assertFalse(logos.isEmpty(), "Лого нет");
        } catch (TimeoutException e) {
            Assert.fail("Таймаут при поиске лого " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testMoreAboutServiceLink() {
        try {
            WebElement serviceLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Подробнее")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", serviceLink);
            serviceLink.click();

            wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

            acceptCookies();

            Assert.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"), "Открылась не та страница");
            driver.navigate().back();
            wait.until(ExpectedConditions.urlToBe("https://www.mts.by/"));

        } catch (TimeoutException e) {
            Assert.fail("Таймаут при переходе по ссылке: " + e.getMessage());
        } catch (NoSuchElementException e) {
            Assert.fail("Ссылка не найдена: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void testPhoneNumber(){
        try {
            WebElement selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pay")));
            Select select = new Select(selectElement);
            select.selectByVisibleText("Услуги связи");

            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#connection-phone")));
            phoneInput.click();
            phoneInput.clear();
            phoneInput.sendKeys("297777777");

            Thread.sleep(1000);

            WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#connection-sum")));
            amountInput.clear();
            amountInput.clear();
            amountInput.sendKeys("5");
            Thread.sleep(1000);

            WebElement continueBut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form#pay-connection button[type='submit']")));
            continueBut.click();
            Thread.sleep(3000);

            WebElement paymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form#pay-connection")));
            Assert.assertTrue(paymentForm.isDisplayed(), "Форма оплаты не появилась");
            Thread.sleep(2000);
        } catch (TimeoutException e) {
            Assert.fail("Таймаут при работе с номером " + e.getMessage());
        } catch (NoSuchElementException e) {
            Assert.fail("Элемент не найден " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
