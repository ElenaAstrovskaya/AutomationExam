package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbRentPage;

public class WbRentPageHelper extends AbstractHelper {

    private WbRentPage wbRentPage = new WbRentPage();

    public boolean checkRentLogo(){
        return wbRentPage.isWbRentPageLogoIsPresent();
    }
}
