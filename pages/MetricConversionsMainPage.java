package pages;

import common.LogicalFunctions;
import net.sf.saxon.exslt.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

public class MetricConversionsMainPage {

    static String mainPageLogoXpath = "//div[@id='logo']";
    static String mainPageTitleElementXpath = "//div[@class='main']/h1";
    static String convertFromFieldXpath = "//div[@class='main']//descendant::input[@id='queryFrom']";
    static String convertToFieldXpath = "//div[@class='main']//descendant::input[@id='queryTo']";
    static String convertTypeButtonXpath = "//div[@id='mainLinks']/a[contains(text(), '%s')]";

    static String convertTypeCategoryButtonXpath = "//div[@id='typeMenu']/a[contains(text(), '%s')]";
    static String bottomNavBarXpath = "//footer//descendant::nav[@id='menulinks']";

    static WebElement mainPageTitleElement;
    static WebElement convertFromFieldElement;
    static WebElement convertToFieldElement;
    //currently there is no use for this button
    static WebElement convertButtonElement;
    static WebElement convertTypeButtonElement;
    static WebElement convertTypeCategoryButtonElement;
    static WebElement bottomNavBarElement;

    public MetricConversionsMainPage() {
        mainPageTitleElement = CommonFuncWeb.findElement(mainPageTitleElementXpath);
        if (mainPageTitleElement != null)
            initPageElement();
    }

    public boolean verifyPageTitle(String expMainPageTitle) {
        if (CommonFuncWeb.verifyElementExists(mainPageTitleElement)){
            String actualMainPageTitle = mainPageTitleElement.getText();
            if (LogicalFunctions.verifyStrings(expMainPageTitle,actualMainPageTitle)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public enum ConversionTypes{
        CELCIUSTOFAHRENHEIT("Celsius to Fahrenheit"),
        METERSTOFEET("Meters to Feet"),
        OUNCESTOGRAMS("Celcius to Fahrenhiet");

        private String conversionType;
        ConversionTypes(String conversionType) {
            this.conversionType = conversionType;
        }

        public String getConversionType() {
            return conversionType;
        }
    }

    private void initPageElement() {
        convertFromFieldElement = CommonFuncWeb.findElement(convertFromFieldXpath);
        convertToFieldElement = CommonFuncWeb.findElement(convertToFieldXpath);
        bottomNavBarElement = CommonFuncWeb.findElement(bottomNavBarXpath);
    }

    public boolean clickOnConvertButton(){
        if (CommonFuncWeb.verifyElementExists(convertButtonElement)){
            convertButtonElement.click();
            return true;
        }else {
            return false;
        }
    }

    public boolean fillConvertFromField(String sConvertFromFieldText){
        if (CommonFuncWeb.verifyElementExists(convertFromFieldElement)){
            CommonFuncWeb.fillTextField(convertFromFieldElement, sConvertFromFieldText);
            return true;
        }else {
            return false;
        }
    }

    public boolean fillConvertToField(String sConvertToFieldText){
        if (CommonFuncWeb.verifyElementExists(convertToFieldElement)){
            CommonFuncWeb.fillTextField(convertToFieldElement,sConvertToFieldText);
            return true;
        }else{
            return false;
        }
    }

    public ConversionPage selectConversionType(String conversionType){
        if (conversionType != null){
            convertTypeButtonXpath = String.format(convertTypeButtonXpath,conversionType);
            if (convertTypeButtonXpath != null)
                convertTypeButtonElement = CommonFuncWeb.findElement(convertTypeButtonXpath);
            if (CommonFuncWeb.verifyElementExists(convertTypeButtonElement)){
                CommonFuncWeb.scrollToElement(bottomNavBarElement);
                if (CommonFuncWeb.clickOnElement(convertTypeButtonElement))
                    return new ConversionPage(conversionType);
            }else{
                return null;
            }
        }
        return null;
    }

    public MetricConversionTypesOfCategoryPage selectConversionCategory(String conversionCategory){
        if (conversionCategory != null){
            convertTypeCategoryButtonXpath = String.format(convertTypeCategoryButtonXpath,conversionCategory);
            if (convertTypeCategoryButtonXpath != null)
                convertTypeCategoryButtonElement = CommonFuncWeb.findElement(convertTypeCategoryButtonXpath);
            if (CommonFuncWeb.verifyElementExists(convertTypeCategoryButtonElement)){
                if (CommonFuncWeb.clickOnElement(convertTypeCategoryButtonElement))
                    return new MetricConversionTypesOfCategoryPage(conversionCategory);
            }else{
                return null;
            }
        }
        return null;
    }
}



