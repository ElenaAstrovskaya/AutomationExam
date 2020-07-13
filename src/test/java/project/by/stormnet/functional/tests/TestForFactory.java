package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entenies.helpers.WbConfirmPageHelper;
import project.by.stormnet.functional.entenies.helpers.WbHomePageHelper;
import project.by.stormnet.functional.entenies.helpers.WbLoginPageHelper;
import project.by.stormnet.functional.entenies.helpers.WbSearchPageHelper;

public class TestForFactory {

    private WbHomePageHelper wbHomePageHelper = new WbHomePageHelper();
    private WbSearchPageHelper wbSearchPageHelper = new WbSearchPageHelper();

    @Test
    public void foundResultWithUsePriseFilter(){
        String searchKey = "босоножки";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.search(searchKey);
        wbSearchPageHelper.getPriceFilter();
        System.out.println("Test using @Factory with price filter is passed");
        Assert.assertFalse(wbSearchPageHelper.isPriceFilterResultFound(), "Test with filter using is failed");
    }

    @Test
    public void foundResultWithUseBrandFilter(){
        String searchKey = "платье";
        String searchBrand = "Domira";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.search(searchKey);
        wbSearchPageHelper.getBrandFilter(searchBrand);
        System.out.println("Test using @Factory with brand filter is passed");
        Assert.assertFalse(wbSearchPageHelper.isBrandFilterResultFound(), "Test with filter using is failed");
    }

    @Test
    public void foundResultAtNewPage() {
        String searchKey = "пляжное полотенце";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.search(searchKey);
        wbSearchPageHelper.clickNextPage();
        System.out.println("Test using @Factory switch to next page is passed");
        Assert.assertFalse(wbSearchPageHelper.isNextPageResultFound(), "Test switch to next page is failed");
    }
}
