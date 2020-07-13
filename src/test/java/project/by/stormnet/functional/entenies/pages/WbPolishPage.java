package project.by.stormnet.functional.entenies.pages;

import org.openqa.selenium.interactions.Actions;

public class WbPolishPage extends AbstractPage{

    public static String polishPageSign = "//div[(contains(text(),'2020 © pl.wildberries.eu'))]";

    public static WbPolishPage getWbPolishPage(){
        WbPolishPage wbPolishPage = new WbPolishPage();
        System.out.println("Wildberries Polish page is opened");
        return wbPolishPage;
    }

    public boolean checkPageIsPolish(){
        Actions scroll = new Actions(getDriver());
        scroll.moveToElement(getElement(polishPageSign));
        scroll.perform();
        return getElement(polishPageSign).isDisplayed();
    }
}
