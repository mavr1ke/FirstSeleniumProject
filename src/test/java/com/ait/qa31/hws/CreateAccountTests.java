package com.ait.qa31.hws;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest() {
        clickOnRegisterLink();
        fillRegisterForm(new User()
                .setFirstName("Manuel")
                .setLastName("Ferraro")
                .setEmail("okay@gm.com")
                .setPassword("qwerty123")
                .setConfirmPassword("qwerty123"));
        clickOnRegisterButton();
        Assert.assertTrue(isLogOutButtonPresent());
    }

}
