package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entenies.helpers.WbHomePageHelper;
import project.by.stormnet.functional.entenies.helpers.WbSearchPageHelper;

public class WbSearchTests {
    private WbHomePageHelper wbHomePageHelper = new WbHomePageHelper();
    private WbSearchPageHelper wbSearchPageHelper = new WbSearchPageHelper();

    private String searchKey;

    public WbSearchTests(String searchKey) {this.searchKey = searchKey;}

    @Test
    public void performSearchViaButton() {
        String searchKey = "купальник";
        int countPerPage = wbHomePageHelper.search(searchKey).getSearchResultsPerPage();
        System.out.println("Test search by clicking the button passed");
        Assert.assertTrue(countPerPage > 0, "No result were found");
    }

    @Test
    public void performSearchViaEnter() {
        String searchKey = "чулки";
        int countPerPage = wbHomePageHelper.searchViaEnter(searchKey).getSearchResultsPerPage();
        System.out.println("Test search by enter passed");
        Assert.assertTrue(countPerPage > 0, "No result were found");
    }

    @Test
    public void countSearchResultsPerPage() {
        String searchKey = "бюстгалтер";
        int countPerPage = wbHomePageHelper.search(searchKey).getSearchResultsPerPage();
        System.out.println("Test found result per page passed. " + countPerPage + " results were found");
        Assert.assertTrue(countPerPage > 0, "No result were found");
    }

    @Test
    public void countSearchResultsTotal() {
        String searchKey = "платье";
        int countTotal = wbHomePageHelper.search(searchKey).getSearchResultsTotal();
        System.out.println("Test found total result passed. " + countTotal  + " results were found");
        Assert.assertTrue(countTotal > 0, "No result were found");
    }

    @Test (dataProvider = "nonExistentKeys")
    public void searchNonExistent(String searchKey) {
        boolean resultsTitle = wbHomePageHelper.search(searchKey).isResultsTitleExist();
        System.out.println("Test invalid search with @DataProvider passed");
        Assert.assertTrue(resultsTitle, "Something is found, but shouldn't be");
    }

    @DataProvider(name = "nonExistentKeys")
    public Object[] provideDate() {
        return new Object[][]{{"пыжня"}, {"easypeasy"}, {"blablabla"}};
    }

    @Test
    public void searchCyrillic() {
        String searchKey = "привет";
        int countPerPage = wbHomePageHelper.searchViaEnter(searchKey).getSearchResultsPerPage();
        System.out.println("Test cyrillic input passed");
        Assert.assertTrue(countPerPage > 0, "No result were found");
    }

    @Test
    public void searchSpecialChars() {
        String searchKey = "!@#$%^&*()_+1234567890";
        boolean resultsTitle = wbHomePageHelper.search(searchKey).isResultsTitleExist();
        System.out.println("Test special symbols and numeral input passed");
        Assert.assertTrue(resultsTitle, "Something is found, but shouldn't be");
    }

    @Test
    public void searchInvalidInputReplace() {
        String searchKey = "gkfnmt";
        boolean resultsTitle = wbHomePageHelper.search(searchKey).isResultsReplacedExist();
        System.out.println("Test replace of invalid value passed");
        Assert.assertTrue(resultsTitle, "Key word is not replaced. No result were found");
    }

    @Test
    public void emptySearch() {
        String searchKey = "";
        boolean resultsTitle = wbHomePageHelper.searchViaEnter(searchKey).isResultsTitleExist();
        System.out.println("Test empty search passed");
        Assert.assertFalse(resultsTitle, "Something is found, but shouldn't be:");
    }

    @Test
    public void searchMaxAmount() {
        String searchKey = "qwertqwertqwertqwe20qwertqwertqwertqwe40qwertqwertqwertqwe60qwertqwertqwertqwe80qwertqwertqwertqw100qwertqwertqwertqw120qwertqwertqwertqw140qwertqwertqwertqw160qwertqwertqwertqw180qwertqwertqwertqw200qwertqwertqwertqw220qwertqwertqwertqw240qwertqwertqwertqw220qwertqwertqwertqw280qwertqwertqwertqw300qwertqwertqwertqw320qwertqwertqwertqw340";
        int resultsTitleSize = wbHomePageHelper.searchViaEnter(searchKey).getSearchResultsTitleSize();
        System.out.println("Test trimming the entered value to 300 symbols passed");
        Assert.assertEquals(resultsTitleSize, 300, "Search result key is not cropped to 300 chars:");
    }

    @Test
    public void foundResultWithUsePriseFilter(){
          String searchKey = "босоножки";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.search(searchKey);
        wbSearchPageHelper.getPriceFilter();
        System.out.println("Test with price filter using is passed");
        Assert.assertFalse(wbSearchPageHelper.isPriceFilterResultFound(), "Test with filter using is failed");
    }

    @Test
    public void foundResultWithUseBrandFilter(){
        String searchKey = "платье";
        String searchBrand = "Domira";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.search(searchKey);
        wbSearchPageHelper.getBrandFilter(searchBrand);
        System.out.println("Test with brand filter using is passed");
        Assert.assertFalse(wbSearchPageHelper.isBrandFilterResultFound(), "Test with filter using is failed");
    }

    @Test
    public void foundResultAtNewPage() {
        String searchKey = "пляжное полотенце";
        wbHomePageHelper.navigateToWbHomePage();
        wbHomePageHelper.search(searchKey);
        wbSearchPageHelper.clickNextPage();
        System.out.println("Test switch to next page is passed");
        Assert.assertFalse(wbSearchPageHelper.isNextPageResultFound(), "Test switch to next page is failed");
    }

    @AfterSuite
    public void tearDown() {
        wbHomePageHelper.quit();
    }
}
