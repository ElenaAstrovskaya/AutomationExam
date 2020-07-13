package project.by.stormnet.functional.entenies.pages;

public class WbVkPage extends AbstractPage{

    private static String vkWildberriesBackLink = "//a[@href='/away.php?to=http%3A%2F%2Fwww.wildberries.by&cc_key=']";

    public static WbVkPage getWbVkPage(){
        WbVkPage wbVkPage = new WbVkPage();
        System.out.println("Vk wildberries page is opened");
        return wbVkPage;
    }
    public WbHomePage clickWildberriesBackLink(){
        changeWindow();
        getElement(vkWildberriesBackLink).click();
        return WbHomePage.getWbHomePage();
    }
}
