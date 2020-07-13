package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbAllBrandsPage;

public class WbAllBrandsPageHelper {

    private WbAllBrandsPage wbAllBrandsPage = new WbAllBrandsPage();

    public WbAdidasPageHelper goAdidasPage(){
        wbAllBrandsPage.clickAdidasLink();
        return new WbAdidasPageHelper();
    }
}
