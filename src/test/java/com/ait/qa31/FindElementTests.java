package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagName() {
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());

        WebElement a = driver.findElement(By.tagName("a"));
        System.out.println(a.getText());

        List<WebElement> a1 = driver.findElements(By.tagName("a"));
        System.out.println(a1.size());
    }


    @Test
    public void findElementBySampleLocator() {
        driver.findElement(By.id("city"));

        WebElement element = driver.findElement(By.className("navigation-link"));
        System.out.println(element.getText());

        driver.findElement(By.linkText("Let the car work"));

        driver.findElement(By.partialLinkText("work"));
    }

    @Test
    public void findElementByCssSelectorTest() {
        driver.findElement(By.cssSelector("#city"));

        driver.findElement(By.cssSelector(".navigation-link"));

        driver.findElement(By.cssSelector("[href='/search']"));
    }

    @Test
    public void findElementByXpath() {
        //tagName == //tagName
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));
        //id -> //tag[@id='city']
        //driver.findElement(By.id("city"));
        driver.findElement(By.xpath("//*[@id='city']"));
        //className -> //tag[@class='class name']
        // driver.findElement(By.className("navigation-link"));
        driver.findElement(By.xpath("//*[@class='navigation-link']"));
        //any -> //*[@attr='par']
        driver.findElement(By.xpath("//*[@href='/search']"));
        //by text
        driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        driver.findElement(By.xpath("//*[.='Find your car now!']"));
        driver.findElement(By.xpath("//*[contains(.,'your car now!')]"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
