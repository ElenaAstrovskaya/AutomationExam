package project.by.stormnet.functional.entenies.pages;

public class WbKidsPage extends AbstractPage{

    private static String wbKidsTitle = "//a[@href='https://kids.wildberries.ru/adventures']";

    public static WbKidsPage getWbKidsPage(){
        WbKidsPage wbKidsPage = new WbKidsPage();
        System.out.println("Wildberries kids page is opened!");
        return wbKidsPage;
    }
    public boolean isWbKidsTitlePresent(){
        return getElement(wbKidsTitle).isDisplayed();
    }
}
