package project.by.stormnet.functional.entenies.pages;

public class WbAllBrandsPage extends AbstractPage {

    private static String allBrandsLogo = "//h2[@class='our-brands-title']";
    private static String adidasLink = "//img[@title='Страница adidas']";

    public static WbAllBrandsPage getWbAllBrandsPage(){
        WbAllBrandsPage wbAllBrandsPage = new WbAllBrandsPage();
        waitForElementVisible(getElementBy(allBrandsLogo));
        System.out.println("Wildberries all brands page is opened");
        return wbAllBrandsPage;
    }

    public WbAdidasPage clickAdidasLink(){
        getElement(adidasLink).click();
        return WbAdidasPage.getWbAdidasPage();
    }
}
