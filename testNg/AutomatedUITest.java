package testNg;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConversionPage;
import pages.MetricConversionTypesOfCategoryPage;
import pages.MetricConversionsMainPage;
import selenium.CommonFuncWeb;

import java.time.Duration;


public class AutomatedUITest extends BaseTest{
    String conversionQuickType;
    Integer valueToConvert = 60;
    int convertedValue = 0;
    int expectedFahrenheitValue = (valueToConvert *2)+20;
    double expectedFeetValue = valueToConvert*3.2808;
    double expectedGramsValue = valueToConvert/0.035274;
    String conversionCategory = "";
    String conversionType = "";
    String expMainPageTitle = "Metric conversion charts and calculators for metric conversions";
    MetricConversionsMainPage mainPage;
    ConversionPage conversionPage;
    MetricConversionTypesOfCategoryPage categoryPage;



    @Test(description = "Converting Celsius to Fahrenheit",testName = "Celsius to Fahrenheit")
    public void celsiusToFahrenheitTest(){
        myBrowser.navigateToWebPage("https://www.metric-conversions.org/");
        CommonFuncWeb.waitForPageToLoad(Duration.ofMillis(10000));
        mainPage = new MetricConversionsMainPage();
        if (mainPage.verifyPageTitle(expMainPageTitle)){
            conversionQuickType = "Celsius to Fahrenheit";
            conversionPage = mainPage.selectConversionType(conversionQuickType);
            if (conversionPage.verifyPageTitle(conversionQuickType)){
                conversionPage.fillConvertField(valueToConvert.toString());
                convertedValue = (conversionPage.getValueOfConversion());
                Assert.assertEquals(convertedValue, expectedFahrenheitValue);
            }else{
                Assert.fail("Page Title Does not Match the Expected Page Title");
            }
        }else{
            Assert.fail("Page Title Does not Match the Expected Page Title");
        }
    }

    @Test(description = "Converting Meters to Feet",testName = "Meters to Feet")
    public void metersToFeetTest(){
        myBrowser.navigateToWebPage("https://www.metric-conversions.org/");
        CommonFuncWeb.waitForPageToLoad(Duration.ofMillis(10000));
        mainPage = new MetricConversionsMainPage();
        if (mainPage.verifyPageTitle(expMainPageTitle)){
            conversionCategory = "Length";
            conversionType = "Meters to Feet";
            categoryPage = mainPage.selectConversionCategory(conversionCategory);
            conversionPage = categoryPage.selectCategoryConversionType(conversionType);
            if (conversionPage.verifyPageTitle(conversionType)){
                if (conversionPage.fillConvertField(valueToConvert.toString())){
                    if (conversionPage.selectFormatFromDropDown("Decimal")){
                        convertedValue = (conversionPage.getValueOfConversion());
                        expectedFeetValue = (int)expectedFeetValue;
                        Assert.assertEquals(convertedValue, expectedFeetValue);
                    }else{
                        Assert.fail("Failed to select item from dropdown list");
                    }
                }else{
                    Assert.fail("Failed to Fill Conversion Field");
                }
            }else{
                Assert.fail("Page Title Does not Match the Expected Page Title");
            }
        }else{
            Assert.fail("Page Title Does not Match the Expected Page Title");
        }
    }

    @Test(description = "Converting Ounces to Grams",testName = "Ounces to Grams")
    public void ouncesToGrams(){
        myBrowser.navigateToWebPage("https://www.metric-conversions.org/");
        CommonFuncWeb.waitForPageToLoad(Duration.ofMillis(10000));
        mainPage = new MetricConversionsMainPage();
        if (mainPage.verifyPageTitle(expMainPageTitle)){
            conversionCategory = "Weight";
            conversionType = "Ounces to Grams";
            categoryPage = mainPage.selectConversionCategory(conversionCategory);
            conversionPage = categoryPage.selectCategoryConversionType(conversionType);
            if (conversionPage.verifyPageTitle(conversionType)){
                if (conversionPage.fillConvertField(valueToConvert.toString())){
                    if (conversionPage.selectFormatFromDropDown("Decimal")){
                        convertedValue = (conversionPage.getValueOfConversion());
                        expectedGramsValue = (int)expectedGramsValue;
                        Assert.assertEquals(convertedValue, expectedGramsValue);
                    }else{
                        Assert.fail("Failed to select item from dropdown list");
                    }
                }else{
                    Assert.fail("Failed to Fill Conversion Field");
                }
            }else{
                Assert.fail("Page Title Does not Match the Expected Page Title");
            }
        }else{
            Assert.fail("Page Title Does not Match the Expected Page Title");
        }
    }



}
