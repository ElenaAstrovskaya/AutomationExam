package project.by.stormnet.functional.entenies.pages;

public class WbPaymentOptionsPage extends AbstractPage{

    private static String paymentOptionsTitle = "//h1[@class='title-main']";
    private static String bankCardDropdown = "//h2[(contains(text(),'Банковская карта'))]";
    private static String visaLogo = "//span[@class='block-cards-item card-visa-37']";

    public static WbPaymentOptionsPage getPaymentOptionsPage(){
        WbPaymentOptionsPage wbPaymentOptionsPage = new WbPaymentOptionsPage();
        waitForElementVisible(getElementBy(paymentOptionsTitle));
        System.out.println("Payment options page is opened");
        return wbPaymentOptionsPage;
    }

    public WbPaymentOptionsPage clickBankCardDropdown(){
        getElement(bankCardDropdown).click();
        return getPaymentOptionsPage();
    }

    public boolean isVisaLogoPresent(){
        wait(500);
        return getElement(visaLogo).isDisplayed();
    }
}
