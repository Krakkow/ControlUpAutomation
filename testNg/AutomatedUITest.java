package testNg;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ConversionPage;
import pages.MetricConversionTypesOfCategoryPage;
import pages.MetricConversionsMainPage;
import selenium.Browser;
import selenium.CommonFuncWeb;

import java.time.Duration;


public class AutomatedUITest extends BaseTest{
    String conversionQuickType;
    Integer valueToConvert = 60;
    int convertedValue = 0;
    int expectedFahrenheitValue = (valueToConvert *2)+20;
    double expectedFeetValue = valueToConvert*3.2808;
    double expectedGramsValue = convertedValue/0.035274;
    String conversionCategory = "";
    String conversionType = "";
    String expMainPageTitle = "Metric conversion charts and calculators for metric conversions";


    @Test(description = "Converting Celsius to Fahrenheit",testName = "Celsius to Fahrenheit")
    public void celsiusToFahrenheitTest(){
        myBrowser.navigateToWebPage("https://www.metric-conversions.org/");
        CommonFuncWeb.waitForPageToLoad(Duration.ofMillis(10000));
        MetricConversionsMainPage mainPage = new MetricConversionsMainPage();
        mainPage.verifyPageTitle(expMainPageTitle);
        conversionQuickType = "Celsius to Fahrenheit";
        ConversionPage conversionPage = mainPage.selectConversionType(conversionQuickType);
        Assert.assertTrue(conversionPage.verifyPageTitle(conversionQuickType));
        conversionPage.fillConvertField(valueToConvert.toString());
        convertedValue = (conversionPage.getValueOfConversion());
        Assert.assertEquals(convertedValue, expectedFahrenheitValue);
    }

    @Test(description = "Converting Meters to Feet",testName = "Meters to Feet")
    public void metersToFeetTest(){
        myBrowser.navigateToWebPage("https://www.metric-conversions.org/");
        CommonFuncWeb.waitForPageToLoad(Duration.ofMillis(10000));
        MetricConversionsMainPage mainPage = new MetricConversionsMainPage();
        mainPage.verifyPageTitle(expMainPageTitle);
        conversionCategory = "Length";
        conversionType = "Meters to Feet";
        MetricConversionTypesOfCategoryPage categoryPage = mainPage.selectConversionCategory(conversionCategory);
        ConversionPage conversionPage = categoryPage.selectCategoryConversionType(conversionType);
        Assert.assertTrue(conversionPage.verifyPageTitle(conversionType));
        conversionPage.fillConvertField(valueToConvert.toString());
        conversionPage.selectFormatFromDropDown("Decimal");
        convertedValue = (conversionPage.getValueOfConversion());
        Assert.assertEquals(convertedValue, expectedFeetValue);
    }

    @Test(description = "Converting Ounces to Grams",testName = "Ounces to Grams")
    public void ouncesToGrams(){
        myBrowser.navigateToWebPage("https://www.metric-conversions.org/");
        CommonFuncWeb.waitForPageToLoad(Duration.ofMillis(10000));
        MetricConversionsMainPage mainPage = new MetricConversionsMainPage();
        mainPage.verifyPageTitle(expMainPageTitle);
        conversionQuickType = "Ounces to Grams";
        ConversionPage conversionPage = mainPage.selectConversionType(conversionQuickType);
        Assert.assertTrue(conversionPage.verifyPageTitle(conversionQuickType));
        conversionPage.fillConvertField(valueToConvert.toString());
        convertedValue = (conversionPage.getValueOfConversion());
        Assert.assertEquals(convertedValue, expectedGramsValue);
    }



}
