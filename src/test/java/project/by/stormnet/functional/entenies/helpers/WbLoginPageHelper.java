package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbConfirmPage;
import project.by.stormnet.functional.entenies.pages.WbLoginPage;

public class WbLoginPageHelper extends AbstractHelper {
    WbLoginPage wbLoginPage = new WbLoginPage();

    public WbConfirmPage inputInPhoneField(String phoneKey) {
        wbLoginPage
                .fillPhoneField(phoneKey)
                .clickGetCodeButton1();
        return new WbConfirmPage();
    }

    public WbLoginPage getValue(){
        wbLoginPage.getValue();
        return WbLoginPage.getWbLoginPage();
    }

    public boolean isErrorMessageDisplayed(){
        return wbLoginPage.displayErrorMessage();
    }
}