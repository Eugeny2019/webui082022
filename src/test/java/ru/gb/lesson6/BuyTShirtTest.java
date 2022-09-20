package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyTShirtTest {
    WebDriver driver;
    MainPage mainPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void bueTShirtTest(){
        mainPage.clickSignInButton()
                .login("evch@rambler.ru", "test4test")
                .navigationBlock.hoverWomenMenuAndClickTShirts()
                .selectSize("S")
                .moveLeftPriceSliderElement(5)
                .addToCardByName("Faded")
                .checkTotalSumma("$18.51");
    }

    @Test
    public void deleteGoodFromBasket () {
        mainPage.clickSignInButton()
                .login("evch@rambler.ru", "test4test")
                .navigationBlock.hoverWomenMenuAndClickTShirts()
                .selectSize("S")
                .moveLeftPriceSliderElement(5)
                .addToCardByName("Faded")
                .addGoodToBasket()
                .deleteGoodFromBasket()
                .checkBasketIsEmpty();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
