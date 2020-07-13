package project.by.stormnet.functional.entenies.pages;

public class WbRentPage extends AbstractPage {

    private static String rentLogo = "//h2[(contains(text(),'Аренда нежилых помещений'))]";

    public static WbRentPage getWbRentPage(){
        WbRentPage wbRentPage = new WbRentPage();
        System.out.println("Wildberries rent page is opened");
        return wbRentPage;
    }

    public boolean isWbRentPageLogoIsPresent(){
        return getElement(rentLogo).isDisplayed();
    }
}
