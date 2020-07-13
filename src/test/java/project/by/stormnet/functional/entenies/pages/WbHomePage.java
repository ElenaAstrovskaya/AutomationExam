package project.by.stormnet.functional.entenies.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class WbHomePage extends AbstractPage {
    private static String logo = "//a[@class=\"header-logo\"]";
    private static String searchField = "//input[@id=\"tbSrch\"]";
    private static String searchButton = "//span[@id=\"btnSrch\"]";
    private static String enter = "//*[@id=\"basketContent\"]/div[2]/a";

    private static String vkLink = "//a[@href='http://vk.com/club42631504']";
    private static String bottomLabel = "//span[(contains(text(),'Мы в соцсетях'))]";
    private static String faqLink = "//a[@class='faq-btn']";
    private static String cityLocation = "//li[@class='geocity item']/child::*";
    private static String cityInputField = "//input[@id='geo-city-input']";
    private static String cityLidaSearch = "//div[@title='Лида|г Лида, Беларусь, Гродненская обл|']";
    private static String cityLidaLocation = "//span[(contains(text(),'Лида'))]";
    private static String guideLogo = "//a[@aria-label='Гид по Wildberries']";
    private static String wbKidsLink = "//a[@href='https://wbkids.ru' and (contains(text(),'WB Kids'))]";
    private static String countriesLink = "//span[(contains(text(),'Сменить страну'))]";
    private static String polandLink = "//a[@href='https://pl.wildberries.eu']";
    private static String rentLink = "//a[@href='https://www.wildberries.by/promo/rent']";
    private static String popularBrandsLogo = "//h3[@class='c-h1 title']";
    private static String popularBrandsLink = "//a[@class='see-all']";
    private static String paymentOptionsLink = "//a[@href='https://www.wildberries.by/services/sposoby-oplaty']";
    private static String youTubeLink = "//a[@href='https://www.youtube.com/Wildberriesshop']";

    public static WbHomePage getWbHomePage(){
        WbHomePage wbHomePage = new WbHomePage();
        waitForElementVisible(getElementBy(logo));
        System.out.println("Wildberries page is opened!");
        return wbHomePage;
    }

    public WbHomePage navigateToWbHomePage(){
        openUrl(wbUrl);
        return getWbHomePage();
    }

    public WbHomePage fillSearchField(String searchKey){
        waitForElementVisible(getElementBy(searchField));
        getElement(searchField).sendKeys(searchKey);
        return getWbHomePage();
    }

    public WbSearchPage clickSearchButton(){
        waitForElementVisible(getElementBy(searchButton));
        getElement(searchButton).click();
        return WbSearchPage.getWbSearchPage();
    }

    public WbSearchPage pressEnterKey() {
        getElement(searchField).sendKeys(Keys.ENTER);
        return WbSearchPage.getWbSearchPage();
    }

    public WbLoginPage clickEnter(){
        waitForElementVisible(getElementBy(enter));
        getElement(enter).click();
        return WbLoginPage.getWbLoginPage();
    }

    public WbVkPage clickVkLink(){
        Actions scroll = new Actions(getDriver());
        scroll.moveToElement(getElement(bottomLabel));
        scroll.perform();
        getElement(vkLink).click();
        return WbVkPage.getWbVkPage();
    }

    public boolean isWildberriesLogoPresent(){
        changeWindow();
        if(getElement(logo).isDisplayed()){
            System.out.println("Home logo is present!");
            return true;
        }
        else {
            System.out.println("Logo is not displayed!");
            return false;
        }
    }

    public WbFaqPage clickFaqLink(){
        getElement(faqLink).click();
        return WbFaqPage.getWbFaqPage();
    }

    public WbHomePage clickCityLink(){
        getElement(cityLocation).click();
        wait(500);
        return getWbHomePage();
    }

    public WbHomePage enterNewCity(String searchKey){
        getElement(cityInputField).sendKeys(searchKey);
        wait(500);
        return getWbHomePage();
    }

    public WbHomePage changeCityToLida(){
        getElement(cityLidaSearch).click();
        wait(500);
        return getWbHomePage();
    }

    public boolean checkCity(){
        return getElement(cityLidaLocation).isDisplayed();
    }

    public WbKidsPage clickKidsLink(){
        hoverOnItem(guideLogo);
        getElement(wbKidsLink).click();
        changeWindow();
        return WbKidsPage.getWbKidsPage();
    }

    public WbPolishPage clickPolandLink(){
        hoverOnItem(countriesLink);
        getElement(polandLink).click();
        return WbPolishPage.getWbPolishPage();
    }

    public WbRentPage clickRentPageLink(){
        Actions scroll = new Actions(getDriver());
        scroll.moveToElement(getElement(bottomLabel));
        scroll.perform();
        getElement(rentLink).click();
        changeWindow();
        return WbRentPage.getWbRentPage();
    }

    public WbAllBrandsPage clickAllBrandsLink(){
        Actions scroll = new Actions(getDriver());
        scroll.moveToElement(getElement(popularBrandsLogo));
        scroll.perform();
        getElement(popularBrandsLink).click();
        return WbAllBrandsPage.getWbAllBrandsPage();
    }

    public WbPaymentOptionsPage clickPaymentOptionsLink(){
        Actions scroll = new Actions(getDriver());
        scroll.moveToElement(getElement(bottomLabel));
        scroll.perform();
        getElement(paymentOptionsLink).click();
        return WbPaymentOptionsPage.getPaymentOptionsPage();
    }

    public WbYoutubePage clickYoutubeLink(){
        Actions scroll = new Actions(getDriver());
        scroll.moveToElement(getElement(bottomLabel));
        scroll.perform();
        getElement(youTubeLink).click();
        return WbYoutubePage.getYoutubePage();
    }

}
