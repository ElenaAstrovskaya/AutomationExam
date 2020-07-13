package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entenies.helpers.*;

public class WbNavigationTests {

    private WbHomePageHelper wbHomePageHelper = new WbHomePageHelper();
    private WbSearchPageHelper wbSearchPageHelper = new WbSearchPageHelper();
    private TheoryOfEverythingPageHelper theoryOfEverythingPageHelper = new TheoryOfEverythingPageHelper();
    private WbCartPageHelper wbCartPageHelper = new WbCartPageHelper();
    private WbVkPageHelper wbVkPageHelper = new WbVkPageHelper();
    private WbFaqPageHelper wbFaqPageHelper = new WbFaqPageHelper();
    private WbKidsPageHelper wbKidsPageHelper = new WbKidsPageHelper();
    private WbPolishPageHelper wbPolishPageHelper = new WbPolishPageHelper();
    private WbRentPageHelper wbRentPageHelper = new WbRentPageHelper();
    private WbAllBrandsPageHelper wbAllBrandsPageHelper = new WbAllBrandsPageHelper();
    private WbAdidasPageHelper wbAdidasPageHelper = new WbAdidasPageHelper();
    private WbPaymentOptionsPageHelper wbPaymentOptionsPageHelper = new WbPaymentOptionsPageHelper();
    private WbYoutubePageHelper wbYoutubePageHelper = new WbYoutubePageHelper();


    @Test
    public void buyTheBookTest() {
        String bookSearchKey = "Теория всего";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.search(bookSearchKey);
        wbSearchPageHelper.goToTheoryOfEverythingPage();
        theoryOfEverythingPageHelper.addBook();
        System.out.println("Test buying a book passed");
        Assert.assertTrue(wbCartPageHelper.checkTheoryOfEverythingPresentInCart(), "Book is not found in the cart!");
    }

    @Test
    public void vkLinkTest() {
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.goToVkPage();
        wbVkPageHelper.goToHomePage();
        boolean logoPresent = wbHomePageHelper.checkHomeLogo();
        System.out.println("Test opening Vk page and return to Wb passed");
        Assert.assertTrue(logoPresent, "Home page is not opened!");
    }

    @Test
    public void faqSearchTest() {
        String faqSerchKey = "Регистрация";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.goToFaqPage();
        int faqResults = wbFaqPageHelper.faqSearch(faqSerchKey);
        System.out.println("Test opening FAQ page passed");
        Assert.assertTrue(faqResults > 0, "No results were found!");
    }

    @Test
    public void locationChangeTest() {
        String citySearchKey = "Лида";
        wbHomePageHelper.navigateToWbHomePage();
        System.out.println("Test change location passed");
        Assert.assertTrue(wbHomePageHelper.checkLocationChange(citySearchKey), "New location is not set!");
    }

    @Test
    public void kidsPageTest() {
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.goToKidsPage();
        System.out.println("Test opening Kids page passed");
        Assert.assertTrue(wbKidsPageHelper.checkKidsLogo(), "Kids page is not opened!");
    }

    @Test
    public void countryChangeTest() {
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.goToPolishPage();
        System.out.println("Test opening Polish page passed");
        Assert.assertTrue(wbPolishPageHelper.checkPolishLogo(), "Polish page is not opened!");
    }

    @Test
    public void rentPageTest() {
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.goToRentPage();
        System.out.println("Test opening Rent page passed");
        Assert.assertTrue(wbRentPageHelper.checkRentLogo(), "Rent page is not opened!");
    }

    @Test
    public void adidasBrandTest() {
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.goToAllBrandsPage();
        wbAllBrandsPageHelper.goAdidasPage();
        System.out.println("Test opening Adidas page passed");
        Assert.assertTrue(wbAdidasPageHelper.checkAdidasLogo(), "Adidas page is not opened!");
    }

    @Test
    public void visaPaymentOptionTest() {
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.goToPaymentOptionsPage();
        System.out.println("Test opening Visa payment option passed");
        Assert.assertTrue(wbPaymentOptionsPageHelper.checkVisaPaymentOptionPresent(), "Visa payment option is not present!");
    }

    @Test
    public void youtubeLinkTest() {
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.goToYoutubePage();
        System.out.println("Test Youtube open from Wildberries page passed");
        Assert.assertTrue(wbYoutubePageHelper.checkYoutubeLogo(), "Youtube page is not present!");
    }

    @AfterSuite
    public void tearDown() {
        wbHomePageHelper.quit();
    }
}