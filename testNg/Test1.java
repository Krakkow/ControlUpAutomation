package testNg;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtil;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    @Test(description = "",testName = "")
    public void test1(){
        Header header1 = new Header("x-rapidapi-host","jokes.p.rapidapi.com");
        Header header2 = new Header("x-rapidapi-key","56d7a4653emsh4c19b463b18e6b7p144eb7jsn030e478c59b2");
        List<Header> myHeadersList = new ArrayList<>();
        myHeadersList.add(header1);
        myHeadersList.add(header2);
        Headers myHeaders = new Headers(myHeadersList);
        Response actualResponse = RestUtil.executeGetRestAssured(RestUtil.MethodType.GET,"https://jokes.p.rapidapi.com/jod/test", myHeaders,200);
        String actualResponseBodyAsString = actualResponse.asString();
        System.out.println(actualResponseBodyAsString);
        if (actualResponseBodyAsString!=null && actualResponseBodyAsString.contains("200")){
            Assert.assertTrue(true);
        }else{
            Assert.fail("Unexpected Status Code");
        }
    }

}
