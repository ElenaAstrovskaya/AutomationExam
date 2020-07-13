package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbVkPage;

public class WbVkPageHelper extends AbstractHelper {

    private WbVkPage wbVkPage = new WbVkPage();

    public WbHomePageHelper goToHomePage(){
        wbVkPage.clickWildberriesBackLink();
        System.out.println("User is re-directed back to Wildberries site!");
        return new WbHomePageHelper();
    }
}
