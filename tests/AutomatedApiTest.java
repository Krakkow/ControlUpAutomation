package tests;

import common.LogicalFunctions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WeatherMainPage;
import utils.RestUtil;

public class AutomatedApiTest extends BaseTest{
    String baseURI = "https://api.weatherapi.com/v1";
    String apiKey = "448862bc2bf740ef970212636222512";
    String zipCode = "20852";
    Integer temperatureFromWeb;
    Integer temperatureFromApi;

    @Test(description = "Automated API Test",testName = "Compare API result to Web UI")
        public void apiTest() throws InterruptedException {
        myBrowser.navigateToWebPage("http://www.weather.com");
        WeatherMainPage mainPage = new WeatherMainPage();
        Thread.sleep(5000);
        if (mainPage.searchByZipCode(zipCode)){
            Thread.sleep(5000);
            if (mainPage.switchToCelsius()){
                temperatureFromWeb = LogicalFunctions.getDigitFromString(WeatherMainPage.getTemperatureValueElement());
                Response actualResponse = RestUtil.executeGetRestAssured(RestUtil.MethodType.GET,baseURI+"/current.json?key="+apiKey+"&q="+zipCode,null,200 );
                temperatureFromApi = LogicalFunctions.getDigitFromString(RestUtil.getKeyValueFromRESTAssuredResponse(actualResponse, ContentType.JSON,"current.temp_c"));
                Assert.assertTrue(LogicalFunctions.compareWithMargin(temperatureFromWeb,temperatureFromApi,0.1));
            }else{
                Assert.fail("Failed To Switch to Celsius");
            }
        }else{
            Assert.fail("Failed To Search for Zip Code");
        }

    }

}
