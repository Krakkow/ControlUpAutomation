package pages;

import common.LogicalFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.CommonFuncWeb;

import java.util.List;

public class MetricConversionTypesOfCategoryPage extends MetricConversionsMainPage{

    public static String categoryPageTitleXpath ="//div[@class='main']/h1";
    public static String categoryConvertTypesXpath = "//div[@class='main']//descendant::div[@id='popLinks']//descendant::li";

    public static WebElement categoryPageTitleElement;
    public static List<WebElement> categoryConvertTypesElement;
    public static WebElement[] categoryConvertTypesElementArray;

    public MetricConversionTypesOfCategoryPage(String conversionType) {
        categoryPageTitleElement = CommonFuncWeb.findElement((categoryPageTitleXpath));
        if (categoryPageTitleElement.getText().contains(conversionType)){
            initPageElements();
        }else{
            System.out.println("Expected title to contain: " + conversionType + ". Actual title contains: " + categoryPageTitleElement.getText());
            return;
        }
    }

    private void initPageElements() {
        categoryConvertTypesElement = CommonFuncWeb.getElements(categoryConvertTypesXpath);
    }

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

    public WebElement[] getAllCategoryConversionTypes(){
            if (categoryConvertTypesElement!=null){
                categoryConvertTypesElementArray = new WebElement[]{};
                return categoryConvertTypesElement.toArray(categoryConvertTypesElementArray);
            }else{
                return null;
            }
    }

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
