package pages;

import common.LogicalFunctions;
import net.sf.saxon.exslt.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

public class MetricConversionsMainPage {

    String mainPageLogoXpath = ".//div[@id='logo']";
    String mainPageTitleElementXpath = ".//div[@class='main']/h1";
    String convertFromFieldXpath = ".//div[@class='main']//descendant::input[@id='queryFrom']";
    String convertToFieldXpath = ".//div[@class='main']//descendant::input[@id='queryTo']";
    String convertTypeButtonXpath = ".//div[@id='mainLinks']/a[contains(text(), '%s')]";
    String convertTypeCategoryButtonXpath = ".//div[@id='typeMenu']/a[contains(text(), '%s')]";
    String bottomNavBarXpath = ".//footer//descendant::nav[@id='menulinks']";

    WebElement mainPageTitleElement;
    WebElement convertFromFieldElement;
    WebElement convertToFieldElement;
    //currently there is no use for this button
    WebElement convertButtonElement;
    WebElement convertTypeButtonElement;
    WebElement convertTypeCategoryButtonElement;
    WebElement bottomNavBarElement;

    public MetricConversionsMainPage() {
        mainPageTitleElement = CommonFuncWeb.findElement(mainPageTitleElementXpath);
        if (mainPageTitleElement != null)
            initPageElement();
    }

    /**
     * <h1>Verify Page Title</h1>
     * @param expMainPageTitle - send a string with the expected page title
     * @return
     */
    public boolean verifyPageTitle(String expMainPageTitle) {
        if (CommonFuncWeb.verifyElementExists(mainPageTitleElement)){
            String actualMainPageTitle = mainPageTitleElement.getText();
            return LogicalFunctions.verifyStrings(expMainPageTitle, actualMainPageTitle);
        }
        return false;
    }

    /**
     * <h1>Page Elements Initiation</h1>
     */
    private void initPageElement() {
        convertFromFieldElement = CommonFuncWeb.findElement(convertFromFieldXpath);
        convertToFieldElement = CommonFuncWeb.findElement(convertToFieldXpath);
        bottomNavBarElement = CommonFuncWeb.findElement(bottomNavBarXpath);
        convertTypeButtonXpath = "//div[@id='mainLinks']/a[contains(text(), '%s')]";
        convertTypeCategoryButtonXpath = "//div[@id='typeMenu']/a[contains(text(), '%s')]";
    }

    /**
     * <h1>Click on Convert Button</h1>
     * @return boolean
     */
    public boolean clickOnConvertButton(){
        if (CommonFuncWeb.verifyElementExists(convertButtonElement)){
            convertButtonElement.click();
            return true;
        }else {
            return false;
        }
    }

    /**
     * <h1>Fill Convert FROM field</h1>
     * @param sConvertFromFieldText
     * @return boolean
     */
    public boolean fillConvertFromField(String sConvertFromFieldText){
        if (CommonFuncWeb.verifyElementExists(convertFromFieldElement)){
            CommonFuncWeb.fillTextField(convertFromFieldElement, sConvertFromFieldText);
            return true;
        }else {
            return false;
        }
    }
    /**
     * <h1>Fill Convert TO field</h1>
     * @param sConvertToFieldText
     * @return boolean
     */
    public boolean fillConvertToField(String sConvertToFieldText){
        if (CommonFuncWeb.verifyElementExists(convertToFieldElement)){
            CommonFuncWeb.fillTextField(convertToFieldElement,sConvertToFieldText);
            return true;
        }else{
            return false;
        }
    }

    /**
     * <h1>Select Conversion Type</h1>
     * @param conversionType - Pass string like 'Meters to feet' through this function to select a conversion type from inside a conversion category
     * @return ConversionPage
     */
    public ConversionPage selectConversionType(String conversionType){
        if (conversionType != null){
            initPageElement();
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

    /**
     * <h1>Select Conversion Category</h1>
     * @param conversionCategory - Pass string like 'Length' through this function to select a conversion category
     * @return MetricConversionTypesOfCategoryPage
     */
    public MetricConversionTypesOfCategoryPage selectConversionCategory(String conversionCategory){
        if (conversionCategory != null){
            initPageElement();
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



