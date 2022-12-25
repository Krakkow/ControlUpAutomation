package testNg;

import common.LogicalFunctions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.weatherMainPage;
import utils.RestUtil;

public class AutomatedApiTest extends BaseTest{
    String apiKey = "448862bc2bf740ef970212636222512";
    String zipCode = "20852";
    Integer temperatureFromWeb;
    Integer temperatureFromApi;

    @Test(description = "Automated API Test",testName = "Compare API result to Web UI")
        public void apiTest() throws InterruptedException {
        myBrowser.navigateToWebPage("http://www.weather.com");
        weatherMainPage mainPage = new weatherMainPage();
        mainPage.searchByZipCode(zipCode);
        mainPage.switchToCelsius();
        temperatureFromWeb = Integer.parseInt(mainPage.getTemperatureValueElement());
        Response actualResponse = RestUtil.executeGetRestAssured(RestUtil.MethodType.GET,"https://api.weatherapi.com/v1/current.json?key="+apiKey+"&q="+zipCode,null,200 );
        String actualResponseBodyAsString = actualResponse.asString();
        System.out.println(actualResponseBodyAsString);
        temperatureFromApi = Integer.parseInt(RestUtil.getKeyValueFromRESTAssuredResponse(actualResponse, ContentType.JSON,"current.temp_c"));
        Assert.assertTrue(LogicalFunctions.compareWithMargin(temperatureFromWeb,temperatureFromApi,0.1));

    }

}
