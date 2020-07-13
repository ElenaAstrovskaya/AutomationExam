package project.by.stormnet.functional.entenies.helpers;

import project.by.stormnet.functional.entenies.pages.WbYoutubePage;

public class WbYoutubePageHelper extends AbstractHelper{

    private WbYoutubePage wbYoutubePage = new WbYoutubePage();

    public boolean checkYoutubeLogo(){
        return wbYoutubePage.isYoutubeLogoPresent();
    }
}
