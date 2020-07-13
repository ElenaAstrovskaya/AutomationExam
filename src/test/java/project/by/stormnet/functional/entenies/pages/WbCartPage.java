package project.by.stormnet.functional.entenies.pages;

public class WbCartPage extends AbstractPage{

    private static String cartPageLogo = "//h3[@class='bold']";
    private static String theoryInCart = "//span[(contains(text(),'Теория Всего'))]";

    public static WbCartPage getCartContantsPage() {
        WbCartPage wbCartPage = new WbCartPage();
        waitForElementVisible(getElementBy(cartPageLogo));
        System.out.println("Cart page is opened");
        return wbCartPage;
    }
    public boolean isTheoryOfEverythingPresent(){
        if (getElement(theoryInCart).isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }
}
