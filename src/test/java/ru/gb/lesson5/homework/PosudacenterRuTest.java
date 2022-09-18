package ru.gb.lesson5.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PosudacenterRuTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
        driver.manage().window().setSize(new Dimension(1400, 900));
        driver.get("https://posudacenter.ru/");

    }

    @Test
    void searchKettleLUCKYTest() {
        //*[@id='title-search-input_fixed']
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("title-search-input_fixed")));
        driver.findElement(By.id("title-search-input_fixed")).sendKeys("Чайник LUCKY\n");

        //pagetitle
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pagetitle")));
        actions.scrollByAmount(0, 500).perform();

        //span[contains(text(),'Чайник') and contains(text(),'LUCKY')]
        Assertions.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Чайник') and contains(text(),'LUCKY')]")).isDisplayed());
    }

    @Test
    void searchNoResultsTest() {
        //*[@id='title-search-input_fixed']
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("title-search-input_fixed")));
        driver.findElement(By.id("title-search-input_fixed")).sendKeys("asdfghjkqwetyiuzxcbn\n");

        //pagetitle
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pagetitle")));
        //div[contains(text()[2],'ничего не найдено')]
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(text()[2],'ничего не найдено')]")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
