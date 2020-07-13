package project.by.stormnet.functional.entenies.pages;

public class WbAdidasPage extends AbstractPage {
    private static String adidasLogo = "//img[@alt='adidas']";

    public static WbAdidasPage getWbAdidasPage(){
        WbAdidasPage wbAdidasPage = new WbAdidasPage();
        System.out.println("Wildberries adidas page is opened");
        return wbAdidasPage;
    }

    public boolean isAdidasLogoPresent(){
        return getElement(adidasLogo).isDisplayed();
    }
}
