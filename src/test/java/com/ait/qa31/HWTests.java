package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HWTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssSelector() {

        driver.findElement(By.cssSelector(".header-logo"));
        driver.findElement(By.cssSelector("#small-searchterms"));
        driver.findElement(By.cssSelector("a:-webkit-any-link"));
        driver.findElement(By.cssSelector(".picture"));
        driver.findElement(By.cssSelector("input[type='button' i]"));
        driver.findElement(By.cssSelector(".search-box-button"));
        driver.findElement(By.cssSelector(".block .listbox ul"));
        driver.findElement(By.cssSelector(".footer-menu-wrapper .column ul"));
        driver.findElement(By.cssSelector(".poll-options li, .poll-results li"));
        driver.findElement(By.cssSelector(".nivo-nextNav"));

    }

    @Test
    public void findElementByXpath() {
        driver.findElement(By.xpath("//*[@class='header-logo']"));
        driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        driver.findElement(By.xpath("//*[@href='/gift-cards']"));
        driver.findElement(By.xpath("//*[@class='picture']"));
        driver.findElement(By.xpath("//input[@value='Subscribe']"));
        driver.findElement(By.xpath("//input[@type='submit']"));
        driver.findElement(By.xpath("//*[@class='block' or @class='listbox' or @class='ul']"));
        driver.findElement(By.xpath("//*[@class='footer-menu-wrapper' or @class='column' or @class='ul']"));
        driver.findElement(By.xpath("//*[@class='poll-options' or @class='poll-results' or @class='li']"));
        driver.findElement(By.xpath("//*[@class='nivo-nextNav']"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
