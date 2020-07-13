package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbAdidasPage;

public class WbAdidasPageHelper extends AbstractHelper {

    private WbAdidasPage wildberriesAdidasPage = new WbAdidasPage();

    public boolean checkAdidasLogo(){
        return wildberriesAdidasPage.isAdidasLogoPresent();
    }
}
