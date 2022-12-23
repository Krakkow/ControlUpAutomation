package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public static WebDriver myDriver = new ChromeDriver();

    public Browser(String sUrl) {
        myDriver.get(sUrl);
        myDriver.manage().window().maximize();
    }
}
