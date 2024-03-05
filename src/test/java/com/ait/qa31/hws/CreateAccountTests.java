package com.ait.qa31.hws;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountTests extends TestBase {

//    @Test(dataProvider = "registrationData")
    public void createAccountPositiveTest(String firstName, String lastName, String email, String password, String confirmPassword) {
        clickOnRegisterLink();
        fillRegisterForm(new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword));
        clickOnRegisterButton();
        Assert.assertTrue(isLogOutButtonPresent());
    }

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() throws IOException {
        List<Object[]> data = new ArrayList<>();
        String csvFile = "src/test/resources/register_data.csv";

        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(csvSplitBy);
                data.add(userData);
            }
        }
        return data.toArray(new Object[0][]);
    }

}
