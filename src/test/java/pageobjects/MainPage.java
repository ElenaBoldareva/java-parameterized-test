package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By cookieButton = By.id("rcc-confirm-button");
    private final By howToPayButton = By.id("accordion__heading-0");          //локаторы для выпадающего списка
    private final By howToPayPanel = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final By severalScootersButton = By.id("accordion__heading-1");
    private final By severalScootersPanel = By.xpath(".//div[@id='accordion__panel-1']/p");
    private final By rentalTimeButton = By.id("accordion__heading-2");
    private final By rentalTimePanel = By.xpath(".//div[@id='accordion__panel-2']/p");
    private final By orderScooterTodayButton = By.id("accordion__heading-3");
    private final By orderScooterPanel = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final By extendOrderOrReturnScooterButton = By.id("accordion__heading-4");
    private final By extendOrderOrReturnScooterPanel = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final By chargeWithScooterButton = By.id("accordion__heading-5");
    private final By chargeWithScooterPanel = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final By canCancelOrderButton = By.id("accordion__heading-6");
    private final By canCancelOrderPanel = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final By bringOutsideMKADButton = By.id("accordion__heading-7");
    private final By bringOutsideMKADPanel = By.xpath(".//div[@id='accordion__panel-7']/p");
    private final By upButtonOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private final By downButtonOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHowToPayButton() {
        driver.findElement(howToPayButton).click();     //1
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();     //1
    }

    public String getTextHowToPayPanel() {
        return driver.findElement(howToPayPanel).getText();         //1.1
    }

    public void clickSeveralScootersButton() {
        driver.findElement(severalScootersButton).click();
    }     //2

    public String getTextSeveralScootersPanel(){
        return driver.findElement(severalScootersPanel).getText();          //2.1
    }

    public void clickRentalTimeButton() {
        driver.findElement(rentalTimeButton).click();
    }       //3

    public String getTextRentalTimePanel(){
        return driver.findElement(rentalTimePanel).getText();          //3.1
    }

    public void clickOrderScooterTodayButton() {
        driver.findElement(orderScooterTodayButton).click();
    }       //4

    public String getTextOrderScooterTodayPanel(){
        return driver.findElement(orderScooterPanel).getText();          //4.1
    }

    public void clickExtendOrderOrReturnScooterButton() {               //5
        driver.findElement(extendOrderOrReturnScooterButton).click();
    }
    public String getTextExtendOrderOrReturnScooterPanel(){         //5.1
        return driver.findElement(extendOrderOrReturnScooterPanel).getText();
    }

    public void clickChargeWithScooterButton() {
        driver.findElement(chargeWithScooterButton).click();
    }       //6

    public String getTextChargeWithScooterPanel(){                                           //6.1
        return driver.findElement(chargeWithScooterPanel).getText();
    }

    public void clickCanCancelOrderButton() {
        driver.findElement(canCancelOrderButton).click();
    }       //7

    public String getTextCanCancelOrderPanel(){                                           //7.1
        return driver.findElement(canCancelOrderPanel).getText();
    }

    public void clickBringOutsideMKADButton() {
        driver.findElement(bringOutsideMKADButton).click();
    }       //8

    public String getTextBringOutsideMKADPanel(){                                           //7.1
        return driver.findElement(bringOutsideMKADPanel).getText();
    }

    public void waitForLoad(int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_FAQ__3uVm4")));
    }

    public void clickUpOrderButton() {
        driver.findElement(upButtonOrderButton).click();
    }

    public void clickDownButtonOrderButton() {
        driver.findElement(downButtonOrderButton).click();
    }
}

