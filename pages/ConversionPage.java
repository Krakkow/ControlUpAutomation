package pages;

import common.LogicalFunctions;
import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

import java.util.List;

public class ConversionPage {

    String convertFieldTitleXpath;//example - "//div[@class='main']//descendant::h1[contains(text(),'Celsius to Fahrenheit')]";
    String convertFieldValueXpath = ".//div[@class='main']//descendant::input[@id='argumentConv']";
    String convertResultXpath = ".//div[@class='main']//descendant::section[@id='result']";
    String swapConvertButtonXpath = ".//div[@class='main']//descendant::a[contains(@class,'swapIcon')]";
    String formatDropDownValuesXpath = ".//div[@id='visibleControls']//descendant::*[@id='opformat']/option";
    String formatDropDownXpath = ".//*[@id='metricConversionTable']//descendant::*[@id='visibleControls']/div//descendant::*[@id='opformat']";
    String resultDropDownXpath = ".//section[@id='result']//descendant::select";
    String bottomNavBarXpath = ".//footer//descendant::nav[@id='menulinks']";

    WebElement convertFieldTitleElement;
    static WebElement convertFieldValueElement;
    static WebElement convertResultElement;
    static WebElement swapConvertButtonElement;
    WebElement formatDropDownElement;
    WebElement bottomNavBarElement;

    List<WebElement> formatDropDownElementList;

    public WebElement getConvertFieldTitleElement() {
        return convertFieldTitleElement;
    }

    public static WebElement getConvertFieldValueElement() {
        return convertFieldValueElement;
    }

    public static WebElement getConvertResultElement() {
        return convertResultElement;
    }

    public static WebElement getSwapConvertButtonElement() {
        return swapConvertButtonElement;
    }

    public ConversionPage(String convertType) {
            convertFieldTitleXpath = ".//div[@class='main']//descendant::h1[contains(text(),'%s')]";
            convertFieldTitleXpath = String.format(convertFieldTitleXpath,convertType);
            convertFieldTitleElement = CommonFuncWeb.findElement(convertFieldTitleXpath);
        if (convertFieldTitleElement != null && LogicalFunctions.verifyStringContains(convertType,convertFieldTitleElement.getText()))
            initPageElements();
    }

    /**
     * <h1>Page Elements initiation</h1>
     * This function is called from within the constructor of the class and from some of the functions if they caused a page refresh
     * initiation of all relevant elements of the page
     */
    private void initPageElements() {
        convertFieldValueElement = CommonFuncWeb.findElement(convertFieldValueXpath);
        convertResultElement = CommonFuncWeb.findElement(convertResultXpath);
        swapConvertButtonElement = CommonFuncWeb.findElement(swapConvertButtonXpath);
        formatDropDownElementList = CommonFuncWeb.getElements(formatDropDownValuesXpath);
        formatDropDownElement = CommonFuncWeb.findElement(formatDropDownXpath);
        bottomNavBarElement = CommonFuncWeb.findElement(bottomNavBarXpath);
    }

    /**
     * <h1>Verify Page Title</h1>
     * @param expPageTitle - send a string with the expected page title
     * @return boolean
     */
    public boolean verifyPageTitle(String expPageTitle){
        if (convertFieldTitleElement!=null){
            String actualPageTitle = convertFieldTitleElement.getText();
            return LogicalFunctions.verifyStringContains(expPageTitle,actualPageTitle);
            }
        return false;
    }

    /**
     * <h1>Fill Convert Field</h1>
     * @param sConvertFromValue - fill the convert field.
     * @return boolean
     */
    public boolean fillConvertField(String sConvertFromValue){
        if (CommonFuncWeb.verifyElementExists(convertFieldValueElement)) {
            return CommonFuncWeb.fillTextField(convertFieldValueElement, sConvertFromValue);
        }
        return false;
    }

    /**
     * <h1>Get Values of Conversion</h1>
     * @return int - this function parse a string into numerical value
     */
    public int getValueOfConversion(){
        if (CommonFuncWeb.verifyElementExists(convertResultElement)){
            String[] parsedValue = getConvertResultElement().getText().trim().split("=");
            parsedValue = parsedValue[1].trim().split("\n");
            parsedValue = parsedValue[0].split("\\.");
            return Integer.parseInt(parsedValue[0]);
        }else{
            return 0;
        }
    }

    /**
     * <h1>Swap Conversion</h1>
     * This functions click on the button that swap between the two conversions parameters
     * @return boolean
     */
    public boolean swapConversion() {
        if (CommonFuncWeb.verifyElementExists(swapConvertButtonElement)) {
            return CommonFuncWeb.clickOnElement(swapConvertButtonElement);
        } else {
            return false;
        }
    }

    /**
     * <h1>Select Item From Results Drop Down</h1>
     * @param expFormat - send a string like 'Decimal' to set the format of the converted value
     * @return
     */
        public boolean selectFormatFromDropDown(String expFormat){
            formatDropDownElement = CommonFuncWeb.findElement(resultDropDownXpath);
        if (CommonFuncWeb.verifyElementExists(formatDropDownElement)){
            CommonFuncWeb.scrollToElement(formatDropDownElement);
            return CommonFuncWeb.selectValueFromDropDown(formatDropDownElement, expFormat);
        }
        return false;
        }


}
