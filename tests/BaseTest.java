package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import selenium.Browser;

public class BaseTest {
    Browser myBrowser;

    @BeforeTest
    public void beforeTest(){
        myBrowser = new Browser();
    }

    @AfterTest
    public void afterTest(){
        myBrowser.closeBrowser();
    }

    @BeforeClass
    public void beforeClass(){
        myBrowser = new Browser();
    }
    @AfterClass
    public void afterClass(){
        myBrowser.closeBrowser();
    }

}
