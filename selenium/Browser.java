package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public static WebDriver myDriver;

    public Browser() {
        myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
    }

    public void closeBrowser(){
        myDriver.quit();
    }

    public void navigateToWebPage(String sUrl){
        if (myDriver!=null){
            myDriver.get(sUrl);
        }
    }
}
