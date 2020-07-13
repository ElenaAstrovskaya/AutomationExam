package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbKidsPage;

public class WbKidsPageHelper extends AbstractHelper {

    private WbKidsPage wbKidsPage = new WbKidsPage();

    public boolean checkKidsLogo(){
        return wbKidsPage.isWbKidsTitlePresent();
    }

}
