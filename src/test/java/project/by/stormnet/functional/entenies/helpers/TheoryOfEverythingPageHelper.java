package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.TheoryOfEverythingPage;

public class TheoryOfEverythingPageHelper extends AbstractHelper {

    private TheoryOfEverythingPage theoryOfEverythingPage = new TheoryOfEverythingPage();

    public WbCartPageHelper addBook(){
        theoryOfEverythingPage
                .clickAddToCartButton()
                .clickCartIcon();
        System.out.println("Add book to a cart and go to cart page!");
        return new WbCartPageHelper();
    }
}
