package project.by.stormnet.functional.entenies.pages;

public class TheoryOfEverythingPage extends AbstractPage{

    private static String theoryLogo = "//span[@class='name']";
    private static String addToCart = "//button[@class='c-btn-main-lg-v1 j-add-to-card']";
    private static String cart = "//a[@class='my-basket']";

    public static TheoryOfEverythingPage getTheoryOfEverythingPage() {
        TheoryOfEverythingPage theoryOfEverythingPage = new TheoryOfEverythingPage();
        waitForElementVisible(getElementBy(theoryLogo));
        System.out.println("Theory of everything page is opened");
        return theoryOfEverythingPage;
    }

    public TheoryOfEverythingPage clickAddToCartButton(){
        getElement(addToCart).click();
        return getTheoryOfEverythingPage();
    }

    public WbCartPage clickCartIcon(){
        getElement(cart).click();
        return WbCartPage.getCartContantsPage();
    }
}
