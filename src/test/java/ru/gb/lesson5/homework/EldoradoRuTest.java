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

//заблокировали на сайте при поиске
public class EldoradoRuTest {
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
        driver.manage().window().setSize(new Dimension(1500,900));
        driver.get("https://eldorado.ru/");
    }

    @Test
    void SearchWrenchTest() {
        //div[@class='ir'] or //span[contains(text(),'Ваш регион')]/..
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Да, верно']")));
        driver.findElement(By.xpath("//button[.='Да, верно']")).click();

        actions.click(driver.findElement(By.xpath("//input[@name='search']"))).perform();

        //a[@type='button' and .='Смартфоны']
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@type='button' and .='Смартфоны']")));

        //input[@aria-label='Поиск товаров']
        driver.findElement(By.xpath("//input[@aria-label='Поиск товаров']")).sendKeys("смартфон");

        //button[@type='submit' and .='Найти']
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and .='Найти']")));
        actions.click(driver.findElement(By.xpath("//button[@type='submit' and .='Найти']"))).perform();

        Assertions.assertTrue(driver.findElement(By.xpath("//li[1]//div//a[contains(text(),'Смартфон')]")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
