package project.by.stormnet.functional.entenies.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entenies.pages.WbSearchPage;

public class WbSearchPageHelper extends AbstractHelper {

    private WbSearchPage wbSearchPage = new WbSearchPage();

    public boolean isResultFound() {
        return wbSearchPage.foundResult();
    }

    public WbSearchPage getPriceFilter() {
        wbSearchPage.clickPriceFilter();
        return new WbSearchPage();
    }

    public WbSearchPage getBrandFilter(String searchBrand) {
        wbSearchPage.scrollPage();
        wbSearchPage.inputBrand(searchBrand);
        wbSearchPage.enableDomiraCheckbox();
        return new WbSearchPage();
    }

    public WbSearchPage clickNextPage() {
        wbSearchPage.scrollPage();
        wbSearchPage.clickNextPage();
        return new WbSearchPage();
    }

    public boolean isPriceFilterResultFound() {
        return wbSearchPage.isPriseResultFound();
    }

    public boolean isNextPageResultFound() {
        return wbSearchPage.isNextPageResultFound();
    }

    public boolean isBrandFilterResultFound() {
        return wbSearchPage.isBrandResultFound();
    }

    public int getSearchResultsPerPage() {
        return wbSearchPage.getResultsPerPage();
    }

    public int getSearchResultsTotal() {
        return Integer.parseInt(wbSearchPage.getResultsTotal().split(" ")[0]);
    }

    public boolean isResultsTitleExist() {
        return wbSearchPage.isResultsTitleDisplayed();
    }

    public boolean isResultsReplacedExist() {
        return wbSearchPage.isResultsReplacedDisplayed();
    }

    public int getSearchResultsTitleSize() {
        return wbSearchPage.getResultsTitleSize();
    }

    public TheoryOfEverythingPageHelper goToTheoryOfEverythingPage(){
        System.out.println("'Theory of everything' book page is opened!");
        wbSearchPage.clickTheoryOfEverything();
        return new TheoryOfEverythingPageHelper();
    }
}
