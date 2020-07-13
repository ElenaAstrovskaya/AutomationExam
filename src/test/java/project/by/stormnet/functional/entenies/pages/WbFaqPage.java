package project.by.stormnet.functional.entenies.pages;

public class WbFaqPage extends AbstractPage{

    private static String logoFaq = "//div[@class='faq-result']";
    private static String inputFaqLine = "//input[@class='faq-search-input tooltipstered']";
    private static String resultsFaq = "//span[@class='faq-result-count']";

    public static WbFaqPage getWbFaqPage(){
        WbFaqPage wbFaqPage = new WbFaqPage();
        waitForElementVisible(getElementBy(logoFaq));
        System.out.println("FAQ page is opened!");
        return wbFaqPage;
    }

    public WbFaqPage fillInputFaqLine(String searchKey){
        getElement(inputFaqLine).sendKeys(searchKey);
        return getWbFaqPage();
    }

    public int getFaqResults(){
        wait(500);
        return Integer.parseInt(getElement(resultsFaq).getText());
    }
}
