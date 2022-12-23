package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

public class ConversionPage {

    String convertFieldTitleXpath = "";
    String convertFieldValueXpath = "";
    String convertResultXpath = "";
    String swapConvertButtonXpath = "";

    WebElement convertFieldTitleElement;
    static WebElement convertFieldValueElement;
    static WebElement convertResultElement;
    static WebElement swapConvertButtonElement;

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
        convertFieldTitleElement.findElement(By.xpath(convertFieldTitleXpath));
        if (convertFieldTitleElement != null && convertFieldTitleElement.getText().contains(convertType))
            initPageElements();
    }

    private void initPageElements() {
        this.convertFieldValueElement = convertFieldValueElement.findElement(By.xpath(convertFieldValueXpath));
        this.convertResultElement = convertResultElement.findElement(By.xpath(convertResultXpath));
        this.swapConvertButtonElement = swapConvertButtonElement.findElement(By.xpath(swapConvertButtonXpath));
    }

    public static boolean fillConvertField(String sConvertFromValue){
        if (CommonFuncWeb.verifyElementExists(convertFieldValueElement)){
            return CommonFuncWeb.fillTextField(convertFieldValueElement, sConvertFromValue);
        }else{
            return false;
        }
    }

    public static String getValueOfConversion(){
        if (CommonFuncWeb.verifyElementExists(convertResultElement)){
//            return CommonFuncWeb.getElementText(convertResultElement);
            return getConvertResultElement().getText();
        }else{
            return null;
        }
    }

    public static boolean swapConversion(){
        if (CommonFuncWeb.verifyElementExists(swapConvertButtonElement)){
            return CommonFuncWeb.clickOnElement(swapConvertButtonElement);
        }else{
            return false;
        }
    }
}
