package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbCartPage;

public class WbCartPageHelper extends AbstractHelper {
    private WbCartPage wbCartPage = new WbCartPage();

    public boolean checkTheoryOfEverythingPresentInCart(){
        return wbCartPage.isTheoryOfEverythingPresent();
    }
}
