package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbFaqPage;

public class WbFaqPageHelper extends AbstractHelper {
    WbFaqPage wbFaqPage = new WbFaqPage();

    public int faqSearch(String searchKey){
        return wbFaqPage
                .fillInputFaqLine(searchKey)
                .getFaqResults();
    }
}
