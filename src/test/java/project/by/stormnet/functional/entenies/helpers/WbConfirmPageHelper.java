package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbConfirmPage;

public class WbConfirmPageHelper {
    WbConfirmPage wbConfirmPage = new WbConfirmPage();

    public boolean displayConfirmPage(){
        System.out.println("Confirm page is opened!");
        return wbConfirmPage.getWbConfirmPage();
    }
}
