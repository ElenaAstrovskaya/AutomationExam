package project.by.stormnet.functional.entenies.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WbSearchPage extends AbstractPage {

    private static String logo = "//a[@class=\"header-logo\"]";
    private static String results = "//div[@class=\"l_class\"]";
    private static String resultsCounter = "//span[@class = 'goods-count j-goods-count']";
    private static String resultsTitle = "//h1[@class = 'searching-results-title']";
    private static String resultsReplaced = "//span[@class = 'searching-results-text searching-results-text-replaced']";
    private static String searchResult = "//span[@class=\"goods-count j-goods-count\"]";
    private static String priceFilter = "//*[@id=\"price\"]";
    private static String brand = "//input[@id=\"tBrandSearch\"]";
    private static String DomiraCheckbox = "//*[@id=\"brand_list_left\"]/label";
    private static String pagination = "//a[@class=\"pagination-next\"]";
    private static String resultPrice = "//div[@id=\"c8808990\"]";
    private static String resultNextPage = "//div[@id=\"c8319559\"]";
    private static String resultBrand = "//div[@id=\"c12101596\"]";

    private static String resultsBook = "//h1[@class='c-h1 searching-results-title']";
    private static String theory = "//img[@alt='Теория Всего Издательство АСТ']";

    public static WbSearchPage getWbSearchPage(){
        WbSearchPage wbSearchPage = new WbSearchPage();
        waitForElementVisible(getElementBy(logo));
        System.out.println("Result page is opened!");
        return wbSearchPage;
    }

    public boolean foundResult(){
        WebElement res = getElement(results);
                if (res == null) {
                    return false;
                } else
                    return res.isDisplayed();
    }

    public WbSearchPage clickPriceFilter(){
        waitForElementVisible(getElementBy(priceFilter));
        getElement(priceFilter).click();
        return getWbSearchPage();
    }

    public WbSearchPage clickNextPage(){
        waitForElementVisible(getElementBy(pagination));
        getElement(pagination).click();
        return getWbSearchPage();
    }

    public boolean isPriseResultFound(){
        WebElement res = getElement(resultPrice);
        if (res == null) {
            return false;
        } else
            return res.isDisplayed();
    }

    public boolean isNextPageResultFound(){
        WebElement res = getElement(resultNextPage);
        if (res == null) {
            return false;
        } else
            return res.isDisplayed();
    }

    public WbSearchPage inputBrand(String searchKey){
        waitForElementVisible(getElementBy(brand));
        getElement(brand).sendKeys(searchKey);
        return getWbSearchPage();
    }

    public WbSearchPage enableDomiraCheckbox(){
        waitForElementVisible(getElementBy(DomiraCheckbox));
        getElement(DomiraCheckbox).click();
        return getWbSearchPage();
    }

    public boolean isBrandResultFound(){
        WebElement res = getElement(resultBrand);
        if (res == null) {
            return false;
        } else
            return res.isDisplayed();
    }

    public int getResultsPerPage() {
        return getElements(results).size();
    }

    public String getResultsTotal() {
        return getElement(resultsCounter).getText();
    }

    public boolean isResultsTitleDisplayed() {
        WebElement element = getElement(resultsTitle);
        if (element == null) {
            return false;
        } else
            return element.isDisplayed();
    }

    public int getResultsTitleSize() {
        return getElement(resultsTitle).getText().length();
    }

    public boolean isResultsReplacedDisplayed() {
        return getElement(resultsReplaced).isDisplayed();
    }

    public TheoryOfEverythingPage clickTheoryOfEverything(){
        getElement(theory).click();
        return TheoryOfEverythingPage.getTheoryOfEverythingPage();
    }
}