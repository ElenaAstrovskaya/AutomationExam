package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbHomePage;
import project.by.stormnet.functional.entenies.pages.WbLoginPage;

public class WbHomePageHelper extends AbstractHelper {
    private WbHomePage wbHomePage = new WbHomePage();

    public WbHomePageHelper navigateToWbHomePage(){
        System.out.println("Navigate to Wb page");
        wbHomePage.navigateToWbHomePage();
        return this;
    }

    public WbSearchPageHelper search(String searchKey){
        navigateToWbHomePage();
        wbHomePage
                .fillSearchField(searchKey)
                .clickSearchButton();
        return new WbSearchPageHelper();
    }

//    public WbSearchHelper searchBook(String searchKey){
//        navigateToHomePage();
//        wbHomePage
//                .fillSearchField(searchKey)
//                .clickSearchButton();
//        return new WbSearchHelper();
//    }

    public WbSearchPageHelper searchViaEnter (String searchKey) {
        navigateToWbHomePage();
        wbHomePage.fillSearchField(searchKey).pressEnterKey();
        return new WbSearchPageHelper();
    }

    public WbLoginPage clickLoginButton(){
        wbHomePage.clickEnter();
        return new WbLoginPage();
    }

    public WbVkPageHelper goToVkPage(){
        wbHomePage.clickVkLink();
        return new WbVkPageHelper();
    }

    public boolean checkHomeLogo(){
        return wbHomePage.isWildberriesLogoPresent();
    }

    public WbFaqPageHelper goToFaqPage(){
        wbHomePage.clickFaqLink();
        return new WbFaqPageHelper();
    }

    public boolean checkLocationChange(String searchKey){
        return wbHomePage
                .clickCityLink()
                .enterNewCity(searchKey)
                .changeCityToLida()
                .checkCity();
    }

    public WbKidsPageHelper goToKidsPage(){
        wbHomePage.clickKidsLink();
        return new WbKidsPageHelper();
    }

    public WbPolishPageHelper goToPolishPage(){
        wbHomePage.clickPolandLink();
        return new WbPolishPageHelper();
    }

    public WbRentPageHelper goToRentPage(){
        wbHomePage.clickRentPageLink();
        return new WbRentPageHelper();
    }

    public WbAllBrandsPageHelper goToAllBrandsPage(){
        wbHomePage.clickAllBrandsLink();
        return new WbAllBrandsPageHelper();
    }

    public WbPaymentOptionsPageHelper goToPaymentOptionsPage(){
        wbHomePage.clickPaymentOptionsLink();
        return new WbPaymentOptionsPageHelper();
    }

    public WbYoutubePageHelper goToYoutubePage(){
        wbHomePage.clickYoutubeLink();
        return new WbYoutubePageHelper();
    }

}