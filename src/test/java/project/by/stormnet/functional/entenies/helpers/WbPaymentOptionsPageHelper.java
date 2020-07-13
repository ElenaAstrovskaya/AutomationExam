package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbPaymentOptionsPage;

public class WbPaymentOptionsPageHelper extends AbstractHelper {

    private WbPaymentOptionsPage wbPaymentOptionsPage = new WbPaymentOptionsPage();

    public boolean checkVisaPaymentOptionPresent(){
        return wbPaymentOptionsPage
                .clickBankCardDropdown()
                .isVisaLogoPresent();
    }
}
