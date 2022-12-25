package pages;

import common.LogicalFunctions;
import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

import java.util.List;

public class ConversionPage {

    static String convertFieldTitleXpath = "//div[@class='main']//descendant::h1[contains(text(),'%s')]";//example - "//div[@class='main']//descendant::h1[contains(text(),'Celsius to Fahrenheit')]";
    static String convertFieldValueXpath = "//div[@class='main']//descendant::input[@id='argumentConv']";
    static String convertResultXpath = "//div[@class='main']//descendant::section[@id='result']";
    static String swapConvertButtonXpath = "//div[@class='main']//descendant::a[contains(@class,'swapIcon')]";
    static String formatDropDownValuesXpath = "//div[@id='visibleControls']//descendant::*[@id='opformat']/option";
    static String formatDropDownXpath = "//*[@id='metricConversionTable']//descendant::*[@id='visibleControls']/div//descendant::*[@id='opformat']";
    static String bottomNavBarXpath = "//footer//descendant::nav[@id='menulinks']";

    static WebElement convertFieldTitleElement;
    static WebElement convertFieldValueElement;
    static WebElement convertResultElement;
    static WebElement swapConvertButtonElement;
    static WebElement formatDropDownElement;
    static WebElement bottomNavBarElement;

    public static List<WebElement> formatDropDownElementList;
    public static WebElement[] formatDropDownElementArray;

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
//        convertFieldTitleElement.findElement(By.xpath(convertFieldTitleXpath));
        convertFieldTitleXpath = String.format(convertFieldTitleXpath,convertType);
        convertFieldTitleElement = CommonFuncWeb.findElement(convertFieldTitleXpath);
        if (convertFieldTitleElement != null && LogicalFunctions.verifyStringContains(convertType,convertFieldTitleElement.getText()))
            initPageElements();
    }

    public ConversionPage() {
    }

    private void initPageElements() {
        convertFieldValueElement = CommonFuncWeb.findElement(convertFieldValueXpath);
        convertResultElement = CommonFuncWeb.findElement(convertResultXpath);
        swapConvertButtonElement = CommonFuncWeb.findElement(swapConvertButtonXpath);
        formatDropDownElementList = CommonFuncWeb.getElements(formatDropDownValuesXpath);
        formatDropDownElement = CommonFuncWeb.findElement(formatDropDownXpath);
        bottomNavBarElement = CommonFuncWeb.findElement(bottomNavBarXpath);
    }

    public boolean verifyPageTitle(String expPageTitle){
        if (convertFieldTitleElement!=null){
            String actualPageTitle = convertFieldTitleElement.getText();
            if (LogicalFunctions.verifyStringContains(expPageTitle,actualPageTitle));
            return true;
        }else{
            return false;
        }
    }

    public boolean fillConvertField(String sConvertFromValue){
        if (CommonFuncWeb.verifyElementExists(convertFieldValueElement)){
            return CommonFuncWeb.fillTextField(convertFieldValueElement, sConvertFromValue);
        }else{
            return false;
        }
    }

    public int getValueOfConversion(){
        if (CommonFuncWeb.verifyElementExists(convertResultElement)){
            String[] parsedValue = getConvertResultElement().getText().trim().split("=");
            parsedValue = parsedValue[1].trim().split("\n");
            parsedValue = parsedValue[0].split("\\.");
            Integer intValue = Integer.parseInt(parsedValue[0]);
            return intValue;
        }else{
            return 0;
        }
    }

    public boolean swapConversion() {
        if (CommonFuncWeb.verifyElementExists(swapConvertButtonElement)) {
            return CommonFuncWeb.clickOnElement(swapConvertButtonElement);
        } else {
            return false;
        }
    }

        public boolean selectFormatFromDropDown(String expFormat){
        if (CommonFuncWeb.verifyElementExists(formatDropDownElement)){
            CommonFuncWeb.scrollToElement(formatDropDownElement);
            WebElement[] dropDownValue = getFormatDropDownValues();
            CommonFuncWeb.selectValueFromDropDown(dropDownValue);
            for (int i = 0; i<dropDownValue.length; i++){
                if (dropDownValue[i].getText().equals(expFormat)){
                    dropDownValue[i].click();
                    System.out.println("Drop Down Item Selected Successfully");
                    return true;
                }else{
                    System.out.println("Unable to find drop down element. Please Check.");
                    return false;
                }
            }
            System.out.println("Unable to find required format from dropdown. Please Check.");
            return false;
        }
        return false;
        }

    public WebElement[] getFormatDropDownValues(){
        if (formatDropDownElementList!=null){
            formatDropDownElementArray = new WebElement[]{};
            return formatDropDownElementList.toArray(formatDropDownElementArray);
        }else{
            return null;
        }
    }

}
