package ru.gb.lesson3.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class qahacking {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://qahacking.guru/");

        driver.findElement(By.xpath("//div[@class='uk-icon uk-navbar-toggle-icon']")).click();
        driver.findElement(By.xpath("//*[@id=\"module-menu-mobile\"]//a[.='Магазин']")).click();
        driver.findElement(By.xpath("//*[@class='product productitem_2']//*[@class='btn btn-success button_buy']")).click();
        driver.findElement(By.xpath("//*[@id=\"comjshop\"]//input[@value='В корзину']")).click();
        driver.findElement(By.xpath("//*[@id=\"comjshop\"]//a[@class='button-img']")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().parentFrame().findElement(By.xpath("//*[.='Ваша корзина пуста.']"));

        driver.quit();


    }
}
