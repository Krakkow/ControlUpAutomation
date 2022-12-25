package testNg;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import selenium.Browser;
import selenium.CommonFuncWeb;

import java.time.Duration;

public class BaseTest {
    Browser myBrowser;

    @BeforeTest
    public void beforeTest(){
        myBrowser = new Browser();
//        myBrowser.navigateToWebPage("https://www.metric-conversions.org/");
//        CommonFuncWeb.waitForPageToLoad(Duration.ofMillis(10000));
    }

    @AfterTest
    public void afterTest(){
        myBrowser.closeBrowser();
    }

}
