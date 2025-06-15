import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.testng.Assert;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import pages.MainPage;
import pages.PaymentPage;

public class MTSOnlinePaymentTest {
    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;
    private String phone = "297777777";

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
        mainPage.acceptCookies();
        paymentPage.fillPhoneAmount(phone, "5");
        paymentPage.submitPayment();
        Assert.assertTrue(paymentPage.isPaymentFormVisible(), "Форма оплаты не появилась");
    }

    @Test(priority = 5)
    public void testAllPaymentInPlaceholder() {
        paymentPage.ClosePupUp(driver);
        List<String> expectedTypes = List.of(
                "Услуги связи",
                "Домашний интернет",
                "Рассрочка",
                "Задолженность"
        );

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dropdownButton = driver.findElement(By.cssSelector(".select__header"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownButton).click().perform();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".select__list .select__option")));

        List<String> actualOptions = options.stream().map(WebElement::getText).collect(Collectors.toList());

        Assert.assertEquals(actualOptions, expectedTypes, "Списки не совпадают");

        actions.moveToElement(dropdownButton).click().perform();
    }

    @DataProvider(name = "paymentData")
    public Object[][] paymentData() {
        return new Object[][] {
                {"10"},
                {"100"}
        };
    }
    @Test(dataProvider = "paymentData", priority = 6)
    public void testOnlinePaymentForm(String amount) {

            paymentPage.enterPhoneNumber(phone);
            paymentPage.enterAmount(amount);
            paymentPage.submitPaymentForm();

            paymentPage.switchToPaymentFrame();

            String displayedAmount = paymentPage.getDisplayedAmountFromFrame();
            Assert.assertTrue(displayedAmount.contains(amount), "Сумма в описании не совпадает");

            String buttonText = paymentPage.getPayButtonAmountFromFrame();
            Assert.assertTrue(buttonText.contains(amount), "Сумма на кнопке не совпадает");

            String phoneInfo = paymentPage.getPhoneInfoFromFrame();
            Assert.assertTrue(phoneInfo.contains("375" + phone), "Номер телефона в фрейме не совпадает");
            Assert.assertEquals(paymentPage.getCardNumberLabelText(), "Номер карты");
            Assert.assertEquals(paymentPage.getExpirationDateLabelText(), "Срок действия");
            Assert.assertEquals(paymentPage.getCvcLabelText(), "CVC");
            Assert.assertEquals(paymentPage.getHolderLabelText(), "Имя и фамилия на карте");

            List<String> iconSources = paymentPage.getCardIconSources();
            List<String> expectedIcons = Arrays.asList(
                    "visa-system.svg",
                    "mastercard-system.svg",
                    "belkart-system.svg",
                    "maestro-system.svg",
                    "mir-system-ru.svg"
            );

            for (String expected : expectedIcons) {
                boolean found = iconSources.stream().anyMatch(src -> src.contains(expected));
                Assert.assertTrue(found, "Не найдена иконка: " + expected);
            }
            paymentPage.ClosePupUp(driver);
    }
    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
