package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;

    private final By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.className("Button_Middle__1CSJM");
    private final By whereToBringScooterField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-root']");
    //??? private final By dropdownMenuList = By.xpath(".//div[@class='Dropdown-menu']");
    private final By scooterColorBlackField = By.id("black");
    private final By scooterColorGreyField = By.id("grey");

    private final By commentsField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");

    private final By wantToPlaceAnOrderYesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Да']");
    private final By orderModalHeader = By.className("Order_ModalHeader__3FDaJ");

    public String getOrderModalHeaderText() {
        return driver.findElement(orderModalHeader).getText();
    }

    private void setScooterColor(String color) {
        if ("black".equals(color)) {
            clickScooterColorBlackField();
        } else if ("grey".equals(color)) {
            clickScooterColorGreyField();
        }
    }
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAdress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetro(String metro) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(metroField))
                .click()
                .sendKeys(metro)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }
    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void fillPersonForm(String firstName, String lastName, String address, String metro, String phone) {
        setFirstName(firstName);
        setLastName(lastName);
        setAdress(address);
        setMetro(metro);
        setPhone(phone);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void setWhereToBringScooter(String whereToBringScooter) {
        WebElement element = driver.findElement(whereToBringScooterField);
        element.sendKeys(whereToBringScooter);
        element.sendKeys(Keys.ENTER);
    }
     //public void clickRentalPeriod() {
       // driver.findElement(rentalPeriodField).click();

    public void clickRentalPeriod() {
        driver.findElement(rentalPeriodField).click();

//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath(".//div[@class='Dropdown-root Order_FilledDate__1pb8n is-open']")))
//                .click()
//                .sendKeys(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ENTER)
//                .build()
//                .perform();
    }
    public void clickScooterColorBlackField() {
        driver.findElement(scooterColorBlackField).click();
    }
    public void clickScooterColorGreyField() {
        driver.findElement(scooterColorGreyField).click();
    }
    public void setComments(String comments) {
        driver.findElement(commentsField).sendKeys(comments);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void clickWantToPlaceAnOrderYesButton() {
        driver.findElement(wantToPlaceAnOrderYesButton).click();
    }

    public void fillRentForm(String whereToBringScooter, String rentalPeriod, String color, String comments) {
        setWhereToBringScooter(whereToBringScooter);
        clickRentalPeriod();
        clickDropdownOption(rentalPeriod);
        setScooterColor(color);
        setComments(comments);
    }

    public void clickDropdownOption(String period) {
        By option = By.xpath(".//div[@class='Dropdown-option' and text() = '" + period + "']");
        driver.findElement(option).click();
    }

  }