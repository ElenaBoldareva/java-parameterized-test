package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ImportantQuestionsPage {

    private final WebDriver driver;

    private final By howToPayButton = By.id("accordion__heading-0");          //локаторы для выпадающего списка
    private final By howToPayPanel = By.xpath(".//div[@id='accordion__panel-0']/p");          //локаторы для выпадающего списка
    private final By severalScooters = By.id("accordion__heading-1");
    private final By rentalTime = By.id("accordion__heading-2");
    private final By orderScooterToday = By.id("accordion__heading-3");
    private final By extendOrderOrReturnScooter = By.id("accordion__heading-4");
    private final By chargeWithScooter = By.id("accordion__heading-5");
    private final By canCancelOrder = By.id("accordion__heading-6");
    private final By bringOutsideMKAD = By.id("accordion__heading-7");

    public ImportantQuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHowToPayButton() {
        driver.findElement(howToPayButton).click();
    }

    public String getTextHowToPayPanel() {
        return driver.findElement(howToPayPanel).getText();
    }

    // метод проверяет текст 1 кнопки
    public void checkTextHowToPay() {
        assertEquals("Ошибка!", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", driver.findElement(howToPayButton).getText());
    }

    public void clickSeveralScootersButton() { driver.findElement(severalScooters); }
    public void checkTextSeveralScootersButton() {
        assertEquals("Ошибка!", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", driver.findElement(severalScooters).getText());
    }

    public void clickRentalTimeButton() {
        driver.findElement(rentalTime);
    }
    public void checkTextRentalTimeButton() {
        assertEquals("Ошибка!", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", driver.findElement(rentalTime).getText());
    }

    public void clickOrderScooterTodayButton() {
        driver.findElement(orderScooterToday);
    }
    public void checkOrderScooterTodayButton() {
        assertEquals("Ошибка!", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", driver.findElement(orderScooterToday).getText());
    }

    public void clickExtendOrderOrReturnScooterButton() {
        driver.findElement(extendOrderOrReturnScooter);
    }
    public void checkExtendOrderOrReturnScooterButton() {
        assertEquals("Ошибка!", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", driver.findElement(extendOrderOrReturnScooter).getText());
    }

    public void clickChargeWithScooterButton() {
        driver.findElement(chargeWithScooter);
    }
    public void checkChargeWithScooterButton() {
        assertEquals("Ошибка!", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", driver.findElement(chargeWithScooter).getText());
    }

    public void clickCanCancelOrderButton() {
        driver.findElement(canCancelOrder);
    }
    public void checkCanCancelOrderButton() {
        assertEquals("Ошибка!", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", driver.findElement(canCancelOrder).getText());
    }

    public void clickBringOutsideMKADButton() {
        driver.findElement(bringOutsideMKAD);
    }
    public void checkBringOutsideMKADButton() {
        assertEquals("Ошибка!", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", driver.findElement(bringOutsideMKAD).getText());
    }

}