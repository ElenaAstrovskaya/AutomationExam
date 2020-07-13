package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entenies.helpers.WbConfirmPageHelper;
import project.by.stormnet.functional.entenies.helpers.WbHomePageHelper;
import project.by.stormnet.functional.entenies.helpers.WbLoginPageHelper;

public class WbLoginTests {

    private WbHomePageHelper wbHomePageHelper = new WbHomePageHelper();
    private WbLoginPageHelper wbLoginPageHelper = new WbLoginPageHelper();
    private WbConfirmPageHelper wbConfirmPageHelper = new WbConfirmPageHelper();

    @Test
    public void validInputInPhoneField() {
        int phoneKey = ((int) (Math.random() * 999_999_999) + 100_000_000);
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.clickLoginButton();
        wbLoginPageHelper.inputInPhoneField(String.valueOf(phoneKey));
        System.out.println("Valid input in phone field test passed");
        Assert.assertTrue(wbConfirmPageHelper.displayConfirmPage(), "Valid input in phone field test is failed");

    }

    @Test
    public void invalidLetterInputInPhoneField() {
        String phoneKey = "qwertyu";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.clickLoginButton();
        wbLoginPageHelper.inputInPhoneField(phoneKey);
        System.out.println("Invalid letter in phone field test passed");
        Assert.assertTrue(wbLoginPageHelper.isErrorMessageDisplayed(), "Invalid input in phone field test is failed");
    }

    @Test
    public void invalidShortInputInPhoneField() {
        int phoneKey = ((int) (Math.random() * 100));
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.clickLoginButton();
        wbLoginPageHelper.inputInPhoneField(String.valueOf(phoneKey));
        System.out.println("Invalid input in phone field test passed");
        Assert.assertTrue(wbLoginPageHelper.isErrorMessageDisplayed(), "Invalid input in phone field test failed");
    }

    @Test
    public void invalidLongInPhoneField() {
        String phoneKey = String.valueOf(((long) (Math.random() * 100_000_000) * 123456789));
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.clickLoginButton();
        wbLoginPageHelper.inputInPhoneField(String.valueOf(phoneKey));
        System.out.println("Invalid long input in phone field test passed");
        Assert.assertTrue(wbConfirmPageHelper.displayConfirmPage(), "Invalid long input in phone field test failed");
    }

    @Test
    public void invalidSymbolsInputInPhoneField() {
        String phoneKey = "!@#$%^&";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.clickLoginButton();
        wbLoginPageHelper.inputInPhoneField(phoneKey);
        System.out.println("Invalid symbols in phone field test passed");
        Assert.assertTrue(wbLoginPageHelper.isErrorMessageDisplayed(), "Invalid symbols in phone field test failed");
    }

    @Test
    public void invalidNoInputInPhoneField() {
        String phoneKey = "";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.clickLoginButton();
        wbLoginPageHelper.inputInPhoneField(phoneKey);
        System.out.println("Invalid no input in phone field test passed");
        Assert.assertTrue(wbLoginPageHelper.isErrorMessageDisplayed(), "No input in phone field test failed");
    }

    @Test
    public void invalidSpaceInputInPhoneField() {
        String phoneKey = "       ";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.clickLoginButton();
        wbLoginPageHelper.inputInPhoneField(phoneKey);
        System.out.println("Invalid spaces input in phone field test passed");
        Assert.assertTrue(wbLoginPageHelper.isErrorMessageDisplayed(), "Space spaces input in phone field test failed");
    }

    @AfterSuite
    public void tearDown() {
        wbHomePageHelper.quit();
    }
}
