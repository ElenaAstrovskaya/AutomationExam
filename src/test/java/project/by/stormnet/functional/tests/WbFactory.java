package project.by.stormnet.functional.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Factory;
import project.by.stormnet.functional.entenies.helpers.WbHomePageHelper;
import project.by.stormnet.functional.tests.WbSearchTests;

public class WbFactory {

    private WbHomePageHelper wbHomePageHelper = new WbHomePageHelper();

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{new TestForFactory(), new TestForFactory(), new TestForFactory()};
    }

    @AfterSuite
    public void tearDown() {
        wbHomePageHelper.quit();
    }
}
