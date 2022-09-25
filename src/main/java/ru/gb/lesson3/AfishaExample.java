package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.afisha.ru/");

        WebDriverWait waitSomeTime = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

        waitSomeTime.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Событие, актер, место']")));
        chromeDriver.findElement(By.xpath("//input[@placeholder='Событие, актер, место']")).sendKeys("Брат");


        waitSomeTime.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Брат']")));
        chromeDriver.findElement(By.xpath("//div[.='Брат']")).click();

        chromeDriver.quit();
    }
}
