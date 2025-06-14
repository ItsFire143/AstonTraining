import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.testng.Assert;
import pages.MainPage;
import pages.PaymentPage;

public class MTSOnlinePaymentTest {
    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.mts.by");

        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);

        mainPage.acceptCookies();
    }

    @Test(priority = 1)
    public void testTitleBlock(){
        String text = mainPage.getPaymentTitleText();
        Assert.assertTrue(text.contains("Онлайн пополнение"), "Заголовок не найден");
        Assert.assertTrue(text.contains("без комиссии"), "Заголовок не найден");
    }

    @Test(priority = 2)
    public void testPaymentLogo(){
        Assert.assertTrue(mainPage.arePaymentLogosVisible(), "Логотипы не найдены");
    }

    @Test(priority = 3)
    public void testMoreAboutServiceLink() {
        mainPage.clickMoreAboutService();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

        mainPage.acceptCookies();
        Assert.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        driver.navigate().back();
        mainPage.waitForHomePage();
    }

    @Test(priority = 4)
    public void testPhoneNumber() throws InterruptedException{
        paymentPage.fillPhoneAmount("297777777", "5");
        paymentPage.submitPayment();
        Assert.assertTrue(paymentPage.isPaymentFormVisible(), "Форма оплаты не появилась");
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
