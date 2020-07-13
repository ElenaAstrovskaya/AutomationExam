package project.by.stormnet.functional.entenies.helpers;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entenies.pages.AbstractPage;

public class AbstractHelper {

    AbstractPage abstractPage = new AbstractPage();

    public void quit() {
        abstractPage.getDriver().quit();
    }
}
