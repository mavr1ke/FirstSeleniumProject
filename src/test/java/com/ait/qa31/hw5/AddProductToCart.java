package com.ait.qa31.hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddProductToCart extends TestCase {

    @BeforeMethod
    public void precondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            click(By.cssSelector("[href='/logout']"));
        }

        click(By.cssSelector("[href='/login']"));
        type(By.name("Email"), "okay@gm.com");
        type(By.name("Password"), "qwerty123");
        click(By.cssSelector(".button-1.login-button"));
    }

    @Test
    public void addContactPositiveTest() {
        click(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[2]"));
        click(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Assert.assertTrue(isContactCreatedByText("14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition() {
        click(By.cssSelector("input[name=removefromcart]"));
        click(By.cssSelector("input[name=updatecart]"));
    }

    public boolean isContactCreatedByText(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("a"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

}
