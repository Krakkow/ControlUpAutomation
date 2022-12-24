package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonFuncWeb {

    static WebDriver driver;
    static WebElement webElement;
    List<WebElement> webElements;

    public static boolean isElementExists(WebElement webElement){
        if (webElement!=null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean verifyElementExists(WebElement webElement){
        if (isElementExists(webElement)){
            System.out.println("Element " + webElement + " was found successfully.");
            return true;
        }else{
            System.out.println("Element is null. Please Check.");
            return false;
        }
    }

    public static boolean fillTextField(WebElement webElement, String sText){
        if (isElementExists(webElement)){
            webElement.sendKeys(sText);
            System.out.println("Field was filled successfully");
            return true;
        }else{
            System.out.println("Element was not found. Please Check");
            return false;
        }
    }

    public static boolean clickOnElement(WebElement webElement){
        if (isElementExists(webElement)){
            webElement.click();
            System.out.println(webElement + " was found and clicked successfully.");
            return true;
        }else{
            System.out.println("WebElement is null. Please Check");
            return false;
        }
    }

    public static String getElementText(WebElement webElement){
        if (isElementExists(webElement)){
            String elementTextValue = webElement.getText();
            System.out.println(webElement + " return value of: " + elementTextValue);
            return elementTextValue;
        }else{
            System.out.println("WebElement is null. Please Check");
            return null;
        }
    }

    public static List[] getElements(String parentWebElementXpath){
//        webElements = new WebElement[]{};
        if (parentWebElementXpath != null){

        }

        return new List[0];
    }

}
