package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");
//
//
//        driver.quit();
//
        WebDriverManager.firefoxdriver().setup();
        WebDriver driverFF = new FirefoxDriver();
        driverFF.get("https://ya.ru");
        Thread.sleep(5000);
        driverFF.quit();

//        WebDriverManager.safaridriver().setup();
//        WebDriver driverSafary = new SafariDriver();
//        driverSafary.get("https://google.com");
//        //driverFF.quit();

//        WebDriverManager.operadriver().setup();
//        WebDriver driverOpera = new OperaDriver();
//        driverOpera.get("https://google.com");
//        //driverFF.quit();

    }
}
