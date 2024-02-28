package com.ait.qa31.hws;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class TestBase {

    static WebDriver driver;

    protected static void clickOnRegisterButton() {
        driver.findElement(By.name("register-button")).click();
    }

    protected static void clickOnRegisterLink() {
        driver.findElement(By.cssSelector("[href='/register']")).click();
    }

    protected static void findTenElementsByCssSelector() {
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

    protected static void findTenElementsByXpath() {
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

    //    @BeforeMethod
    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    //    @AfterMethod(enabled = true)
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertAppears() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            alert.accept();
            return true;
        }
    }

    protected boolean isLogOutButtonPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public boolean isProductAddedByText(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("a"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    protected void fillLoginForm(User user) {
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    protected void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    protected void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    protected void clickOnLogOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

    protected boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    protected void clickOnCartLink() {
        click(By.xpath("//span[contains(text(),'Shopping cart')]"));
    }

    protected void clickOnAddSecondProduct() {
        click(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[2]"));
    }

    protected void removeCart() {
        click(By.cssSelector("input[name=removefromcart]"));
        click(By.cssSelector("input[name=updatecart]"));
    }

    protected void fillRegisterForm(User user) {
        click(By.name("FirstName"));
        type(By.name("FirstName"),user.getFirstName());
        click(By.name("LastName"));
        type(By.name("LastName"),user.getLastName());
        click(By.name("Email"));
        type(By.name("Email"),user.getEmail());
        click(By.name("Password"));
        type(By.name("Password"),user.getPassword());
        click(By.name("ConfirmPassword"));
        type(By.name("ConfirmPassword"),user.getConfirmPassword());
    }
}
