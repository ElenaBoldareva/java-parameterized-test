package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobjects.MainPage;

import java.time.Duration;


public class TestMainPage {
    private WebDriver driver;
    private final int defaultTimeOut = 10;
    private final String howToPayExpectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String severalScootersExpectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String rentalTimeExpectedText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String orderScooterTodayExpectedText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String extendOrderOrReturnScooterExpectedText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String chargeWithScooterExpectedText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String canCancelOrderExpectedText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String bringOutsideMkadExpectedText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    @Before
    public void startUp() {
        String br = System.getenv("browser");
        if ("chrome".equals(br)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new ChromeDriver(chromeOptions);
        } else if ("ff".equals(br)) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(true);
            driver = new FirefoxDriver();
        } else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new ChromeDriver(chromeOptions);
        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaultTimeOut));
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void checkHowToPay() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoad(defaultTimeOut);
        mainPage.clickCookieButton();
        mainPage.waitForLoad(defaultTimeOut);
        mainPage.clickHowToPayButton();
        String actualText = mainPage.getTextHowToPayPanel();
        Assert.assertEquals(howToPayExpectedText, actualText);
    }

    @Test
    public void checkSeveralScooters() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickSeveralScootersButton();
        String actualText = mainPage.getTextSeveralScootersPanel();
        Assert.assertEquals(severalScootersExpectedText, actualText);
    }

    @Test
    public void checkRentalTime() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickRentalTimeButton();
        String actualText = mainPage.getTextRentalTimePanel();
        Assert.assertEquals(rentalTimeExpectedText, actualText);
    }

    @Test
    public void checkOrderScooterToday() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickOrderScooterTodayButton();
        String actualText = mainPage.getTextOrderScooterTodayPanel();
        Assert.assertEquals((orderScooterTodayExpectedText), actualText);
    }

    @Test
    public void checkExtendOrderOrReturnScooter() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickExtendOrderOrReturnScooterButton();
        String actualText = mainPage.getTextExtendOrderOrReturnScooterPanel();
        Assert.assertEquals((extendOrderOrReturnScooterExpectedText), actualText);
    }

    @Test
    public void checkChargeWithScooter() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickChargeWithScooterButton();
        String actualText = mainPage.getTextChargeWithScooterPanel();
        Assert.assertEquals((chargeWithScooterExpectedText), actualText);
    }

    @Test
    public void checkCanCancelOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickCanCancelOrderButton();
        String actualText = mainPage.getTextCanCancelOrderPanel();
        Assert.assertEquals((canCancelOrderExpectedText), actualText);
    }

    @Test
    public void checkBringOutsideMKAD() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickBringOutsideMKADButton();
        String actualText = mainPage.getTextBringOutsideMKADPanel();
        Assert.assertEquals((bringOutsideMkadExpectedText), actualText);
    }
}