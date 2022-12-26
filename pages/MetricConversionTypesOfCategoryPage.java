package pages;

import common.LogicalFunctions;
import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

import java.util.List;

public class MetricConversionTypesOfCategoryPage extends MetricConversionsMainPage{

    String categoryPageTitleXpath =".//div[@class='main']/h1";
    String categoryConvertTypesXpath = ".//div[@class='main']//descendant::div[@id='popLinks']//descendant::li";

    WebElement categoryPageTitleElement;
    List<WebElement> categoryConvertTypesElement;
    WebElement[] categoryConvertTypesElementArray;

    public MetricConversionTypesOfCategoryPage(String conversionType) {
        categoryPageTitleElement = CommonFuncWeb.findElement((categoryPageTitleXpath));
        if (categoryPageTitleElement.getText().contains(conversionType)){
            initPageElements();
        }else{
            System.out.println("Expected title to contain: " + conversionType + ". Actual title contains: " + categoryPageTitleElement.getText());
            return;
        }
    }

    /**
     * <h1>Page Elements Initiation</h1>
     */
    private void initPageElements() {
        categoryConvertTypesElement = CommonFuncWeb.getElements(categoryConvertTypesXpath);
    }

    /**
     * <h1>Verify Page Title</h1>
     * @param expPageTitle
     * @return boolean
     */
    public boolean verifyPageTitle(String expPageTitle){
        String actualPageTitle;
        if (CommonFuncWeb.verifyElementExists(categoryPageTitleElement)){
            actualPageTitle = categoryPageTitleElement.getText();
            if (LogicalFunctions.verifyStringContains(expPageTitle,actualPageTitle)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * <h1>Get All Category Conversion Types</h1>
     * @return WebElement[] - This function will get all the conversion type(i.e. Meters to feet) within a Conversion Category(i.e. Length)
     */
    public WebElement[] getAllCategoryConversionTypes(){
            if (categoryConvertTypesElement!=null){
                categoryConvertTypesElementArray = new WebElement[]{};
                return categoryConvertTypesElement.toArray(categoryConvertTypesElementArray);
            }else{
                return null;
            }
    }

    /**
     * <h1>Select Category Conversion Type</h1>
     * @param categoryConversionType - Pass string like 'Meters to feet' through this function to select a conversion type from inside a conversion category
     * @return ConversionPage
     */
    public ConversionPage selectCategoryConversionType(String categoryConversionType){
        categoryConvertTypesElementArray = getAllCategoryConversionTypes();
        if (categoryConvertTypesElementArray!=null){
            for (int i = 0; i< categoryConvertTypesElementArray.length; i++){
                if (categoryConvertTypesElementArray[i].getText().contains(categoryConversionType)){
                    if (categoryConvertTypesElementArray[i]!=null){
                        CommonFuncWeb.clickOnElement(categoryConvertTypesElementArray[i]);
                        return new ConversionPage(categoryConversionType);
                    }else{
                        System.out.println("WebElement at index " + i + " is null. Please check.");
                        return null;
                    }
                }

            }
        }
        System.out.println("WebElement Array is null. Please check.");
        return null;
    }


}
