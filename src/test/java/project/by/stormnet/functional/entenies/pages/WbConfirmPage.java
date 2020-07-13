package project.by.stormnet.functional.entenies.pages;

import org.openqa.selenium.WebElement;

public class WbConfirmPage extends AbstractPage {
    private static String title = "//*[@id=\"body-layout\"]/div/div/div/form/div/div[2]/h2";

    public boolean getWbConfirmPage(){
        WbConfirmPage wbConfirmPage = new WbConfirmPage();
        waitForElementVisible(getElementBy(title));
        WebElement titl = getElement(title);
        if (titl == null) {
            return false;
        } else
            return titl.isDisplayed();
    }
}
