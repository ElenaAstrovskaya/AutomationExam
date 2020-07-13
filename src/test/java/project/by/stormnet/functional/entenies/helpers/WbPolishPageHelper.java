package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbPolishPage;

public class WbPolishPageHelper {

    private WbPolishPage wbPolishPage = new WbPolishPage();

    public boolean checkPolishLogo(){
        return wbPolishPage.checkPageIsPolish();
    }
}
