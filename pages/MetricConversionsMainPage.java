package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

public class MetricConversionsMainPage {

    static String mainPageTitleElementXpath = "";
    static String convertFromFieldXpath = "";
    static String convertToFieldXpath = "";
    static String convertButtonXpath = "";
    static String convertTypeButtonXpath = "//div[@id='mainLinks']/a[contains(text(), '%s')]";

    static String convertTypeCategoryButtonXpath = "//div[@id='typeMenu']/a[contains(text(), '%s)]";

    static WebElement mainPageTitleElement;
    static WebElement convertFromFieldElement;
    static WebElement convertToFieldElement;
    static WebElement convertButtonElement;
    static WebElement convertTypeButtonElement;
    static WebElement convertTypeCategoryButtonElement;

    public MetricConversionsMainPage() {
        mainPageTitleElement.findElement(By.xpath(mainPageTitleElementXpath));
        if (mainPageTitleElement != null)
            initPageElement();
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
        convertFromFieldElement.findElement(By.xpath(convertFromFieldXpath));
        convertToFieldElement.findElement(By.xpath(convertToFieldXpath));
        convertButtonElement.findElement(By.xpath(convertButtonXpath));
        convertTypeButtonElement.findElement(By.xpath(convertTypeButtonXpath));
    }

    public boolean clickOnConvertButton(){
        if (convertButtonElement != null){
            convertButtonElement.click();
            return true;
        }else {
            System.out.println("Element is null. Please check.");
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

    public static ConversionPage selectConversionType(String conversionType){
        if (conversionType != null){
            convertTypeCategoryButtonXpath = String.format(convertTypeCategoryButtonXpath,conversionType);
            if (convertTypeCategoryButtonXpath != null)
                convertTypeButtonElement.findElement(By.xpath(convertTypeButtonXpath));
            if (CommonFuncWeb.verifyElementExists(convertTypeButtonElement)){
                if (CommonFuncWeb.clickOnElement(convertTypeButtonElement))
                    return new ConversionPage(conversionType);
            }else{
                return null;
            }
        }
        return null;
    }

    public static MetricConversionTypesOfCategoryPage selectConversionCategory(String conversionCategory){
        if (conversionCategory != null){
            convertTypeButtonXpath = String.format(convertTypeButtonXpath,conversionCategory);
            if (convertTypeButtonXpath != null)
                convertTypeCategoryButtonElement.findElement(By.xpath(convertTypeButtonXpath));
            if (CommonFuncWeb.verifyElementExists(convertTypeCategoryButtonElement)){
                if (CommonFuncWeb.clickOnElement(convertTypeCategoryButtonElement))
                    return new MetricConversionTypesOfCategoryPage();
            }else{
                return null;
            }
        }
        return null;
    }
}



