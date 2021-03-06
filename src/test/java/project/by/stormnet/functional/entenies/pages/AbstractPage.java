package project.by.stormnet.functional.entenies.pages;

import by.stormnet.core.FrameworkCore;
import by.stormnet.core.utils.PauseLength;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AbstractPage extends FrameworkCore{

    private static WebDriver driver = getInstance();

    public static WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String URL) {
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public static void waitForElementVisible(final By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, PauseLength.MAX.value());
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void waitForElementClickable(final By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, PauseLength.MAX.value());
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public boolean isElementVisible(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(PauseLength.AVG.value(), TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(by);

            if (list.size() == 0) {
                return false;
            } else {
                try {
                    return list.get(0).isDisplayed();
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } finally {
            driver.manage().timeouts().implicitlyWait(PauseLength.MAX.value(), TimeUnit.SECONDS);
        }
    }


    public static By getElementBy(String xpath) {
        return By.xpath(xpath);
    }

    public WebElement getElement(String xpath) {
        try {
            return driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<WebElement> getElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public static void wait(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void pageRefresh() throws StaleElementException{
        driver.navigate().refresh();
    }

    public boolean retryingFindClick(By by) throws StaleElementException{
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            driver.findElement(by).click();
            result = true;
            break;
        }
        return result;
    }

    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,300)");
    }

    public void changeWindow(){
        Set<String> handles = driver.getWindowHandles();
        for(String s : handles){
            driver.switchTo().window(s);
        }
    }

    public void hoverOnItem(String item){
        Actions action = new Actions(getDriver());
        WebElement element = getElement(item);
        action.moveToElement(element).perform();
    }
}