package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CommonFuncWeb extends Browser{

    static WebElement webElement;
    static List<WebElement> webElements;


    public static WebElement findElement(String xpath){
        webElement = myDriver.findElement(By.xpath(xpath));
        if (webElement!=null){
            System.out.println("Element was found successfully.");
            return webElement;
        }else{
            System.out.println("Element was not found. Please Check.");
            return null;
        }
    }

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


    public static List<WebElement> getElements(String sElementXpath) {
        if(getAllRequiredElements(sElementXpath)){
            return webElements;
        }else{
            System.out.println("getAllRequiredElements() has failed. Please check.");
            return null;
        }
    }

    public static boolean getAllRequiredElements(String sElementXpath){
        if (sElementXpath != null){
            webElements = myDriver.findElements(By.xpath(sElementXpath));
            if (webElements!=null){
                System.out.println("All Required Elements were assorted to a list");
                return true;
            }else{
                System.out.println("WebElements list is null. Please Check.");
                return false;
            }
        }else{
            System.out.println("Element Xpath is null or incorrect. Please check");
            return false;
        }
    }

    public static void waitForPageToLoad(Duration waitTimeInMilliSeconds){
        myDriver.manage().timeouts().implicitlyWait(waitTimeInMilliSeconds);
    }

    public static boolean openDropDown(WebElement dropdownElement) {
        if (CommonFuncWeb.verifyElementExists(dropdownElement)) {
            scrollToElement(dropdownElement);
            dropdownElement.click();
            return true;
        }else{
            return false;
        }
    }

    public static boolean selectValueFromDropDown(WebElement[] webElements){
        if (webElements!=null){
            for (int i = 0; i< webElements.length; i++){
                if (webElements[i].getText().equals("Decimal")){
                    Select dropDownSelection = new Select(webElements[i]);
                    System.out.println("Drop down value successfully selected");
                    return true;
                }else{
                    System.out.println("Drop down value wasn't selected successfully. Please Check.");
                }
        }
            System.out.println("Drop down item was not found.");
            return false;

        }
        System.out.println("WebElements array is null. Please Check.");
        return false;
    }

    public static boolean scrollToElement(WebElement webElement){
        if (verifyElementExists(webElement)){
            Actions actions = new Actions(myDriver);
            actions.moveToElement(webElement);
            return true;
        }else{
            return false;
        }
    }
}
