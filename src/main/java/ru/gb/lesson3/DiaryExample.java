package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DiaryExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/user/login");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginform-username")));
//        driver.findElement(By.id("loginform-username")).sendKeys("eugeny2022");
//        driver.findElement(By.id("loginform-password")).sendKeys("ZvNpNmoK3R");
//        driver.findElement(By.id("login-btn")).click();

        Cookie authCookie = new Cookie("_identity_", "828445d700ceba2ddc301daeb7d0d29c2da934a4f84ab91beedc96c2563b1068a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3571989%2C%22J-xlH34EhqFuvqC98PfunlmwppzkIQc1%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();

        driver.findElement(By.id("writeThisDiary")).click();

        String postTitle = "title" + new Random().nextInt(100);
        driver.findElement(By.id("postTitle")).sendKeys(postTitle);

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("text");

        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();

        List<WebElement> titles = driver.findElements(By.xpath("//a[@class='title']"));
        titles.stream().filter(p -> p.getText().equals(postTitle)).findFirst().get().click();

        Thread.sleep(5000);
        driver.quit();
    }
}
