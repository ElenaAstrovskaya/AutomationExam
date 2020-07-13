package project.by.stormnet.functional.entenies.pages;

public class WbYoutubePage extends AbstractPage{

    public static String youtubeLogo = "//div[@id='logo-icon-container']";

    public static WbYoutubePage getYoutubePage(){
        WbYoutubePage wbYoutubePage = new WbYoutubePage();
        System.out.println("Youtube page is opened");
        return wbYoutubePage;
    }

    public boolean isYoutubeLogoPresent(){
        changeWindow();
        return getElement(youtubeLogo).isDisplayed();
    }
}
