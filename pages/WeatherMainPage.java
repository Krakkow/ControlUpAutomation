package pages;

import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

public class WeatherMainPage {

    String mainPageLogoXpath = "//*[@class='MainMenuHeader--wrapperLeft--23iHH']";
    String searchBarXpath = "//*[@id='LocationSearch_input']";
    static String temperatureValueXpath = "//*[@class='CurrentConditions--tempValue--MHmYY']";
    String dropMenuButtonXpath = "//*[@data-testid='ctaButton']//descendant::*[@name='globe']";
    String celsiusButtonInDropMenuXpath = "//div[contains(@class, 'ExpandableMenu')]//descendant::li[@id='UnitSelectorTabs-tab_1']";

    WebElement mainPageLogoElement;
    WebElement searchBarElement;
    static WebElement temperatureValueElement;
    WebElement dropMenuButtonElement;
    WebElement celsiusButtonInDropMenuElement;

    public WeatherMainPage() {
        mainPageLogoElement = CommonFuncWeb.findElement(mainPageLogoXpath);
        if (mainPageLogoElement!=null)
            initPageElements();
    }

    private void initPageElements() {
        searchBarElement = CommonFuncWeb.findElement(searchBarXpath);
        dropMenuButtonElement = CommonFuncWeb.findElement(dropMenuButtonXpath);
    }

    public boolean searchByZipCode(String sText) throws InterruptedException {
        initPageElements();
        if (CommonFuncWeb.verifyElementExists(searchBarElement)){
            if (CommonFuncWeb.fillTextField(searchBarElement, sText)){
                Thread.sleep(1500);
                CommonFuncWeb.clickEnter(searchBarElement);
                temperatureValueElement = CommonFuncWeb.findElement(temperatureValueXpath);
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean switchToCelsius() throws InterruptedException {
        initPageElements();
        if (CommonFuncWeb.verifyElementExists(dropMenuButtonElement)) {
            dropMenuButtonElement.click();
            Thread.sleep(3500);
            celsiusButtonInDropMenuElement = CommonFuncWeb.findElement(celsiusButtonInDropMenuXpath);
            if (celsiusButtonInDropMenuElement != null) {
                celsiusButtonInDropMenuElement.click();
                return true;
            } else {
                return false;
            }
        }
        return false;
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
