package pages;

import common.LogicalFunctions;
import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

public class weatherMainPage {

    public static String mainPageLogoXpath = "//*[@class='MainMenuHeader--wrapperLeft--23iHH']";
    public static String searchBarXpath = "//*[@id='LocationSearch_input']";
    public static String temperatureValueXpath = "//*[@class='CurrentConditions--tempValue--MHmYY']";
    public static String dropMenuButtonXpath = "//*[@data-testid='ctaButton']/div[@class='LanguageSelector--menuButtonInner--3z59Z']";
    public static String celsiusButtonInDropMenuXpath = "//div[contains(@class, 'ExpandableMenu')]//descendant::li[@id='UnitSelectorTabs-tab_1']";

    public static WebElement mainPageLogoElement;
    public static WebElement searchBarElement;
    public static WebElement temperatureValueElement;
    public static WebElement dropMenuButtonElement;
    public static WebElement celsiusButtonInDropMenuElement;

    public weatherMainPage() {
        mainPageLogoElement = CommonFuncWeb.findElement(mainPageLogoXpath);
        if (mainPageLogoElement!=null)
            initPageElements();
    }

    private void initPageElements() {
        searchBarElement = CommonFuncWeb.findElement(searchBarXpath);
        dropMenuButtonElement = CommonFuncWeb.findElement(dropMenuButtonXpath);
    }

    public boolean searchByZipCode(String sText) throws InterruptedException {
        if (CommonFuncWeb.verifyElementExists(searchBarElement)){
            if (CommonFuncWeb.fillTextField(searchBarElement, sText)){
                Thread.sleep(1500);
                CommonFuncWeb.clickEnter(searchBarElement);
                initPageElements();
                temperatureValueElement = CommonFuncWeb.findElement(temperatureValueXpath);
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean switchToCelsius(){
        if (CommonFuncWeb.verifyElementExists(dropMenuButtonElement)){
            dropMenuButtonElement.click();
            celsiusButtonInDropMenuElement = CommonFuncWeb.findElement(celsiusButtonInDropMenuXpath);
            celsiusButtonInDropMenuElement.click();
            return true;
        }else{
            return false;
        }
    }

    public static String getTemperatureValueElement() {
        temperatureValueElement = CommonFuncWeb.findElement(temperatureValueXpath);
        if (CommonFuncWeb.verifyElementExists(temperatureValueElement)){
            return temperatureValueElement.getText();
        }else{
            return null;
        }
    }
}
