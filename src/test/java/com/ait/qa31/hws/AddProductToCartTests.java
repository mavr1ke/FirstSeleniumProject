package com.ait.qa31.hws;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!isLoginLinkPresent()) {
            clickOnLogOutButton();
        }
        clickOnLoginLink();
        fillLoginForm(new User()
                .setEmail("okay@gm.com")
                .setPassword("qwerty123"));
        clickOnLoginButton();
    }

    @Test
    public void addProductPositiveTest() {
        clickOnAddSecondProduct();
        clickOnCartLink();
        Assert.assertTrue(isProductAddedByText("14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition() {
        removeCart();
    }

}
