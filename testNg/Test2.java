package testNg;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ReadWriteFileUtil;
import utils.RestUtil;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    @Test(description = "",testName = "")
    public void test2(){
        String responseId = null;
        String myCategory = null;
        String description = null;
        String title = null;
        String text = null;
        String myFilePath = "C:\\dev\\MoonActive\\MoonActive\\";
        Response actualInitialResponse;
        Response actualCategoryResponse;
        Header header1 = new Header("x-rapidapi-host","jokes.p.rapidapi.com");
        Header header2 = new Header("x-rapidapi-key","56d7a4653emsh4c19b463b18e6b7p144eb7jsn030e478c59b2");
        List<Header> myHeadersList = new ArrayList<>();
        myHeadersList.add(header1);
        myHeadersList.add(header2);
        Headers myHeaders = new Headers(myHeadersList);
        actualInitialResponse = RestUtil.executeGetRestAssured(RestUtil.MethodType.GET,"https://jokes.p.rapidapi.com/jod/categories", myHeaders,200);
        if (actualInitialResponse!=null){
            myCategory = RestUtil.getKeyValueFromRESTAssuredResponse(actualInitialResponse, ContentType.JSON,"contents.categories[2].name");
        }
        if (myCategory!=null){
            actualCategoryResponse = RestUtil.executeGetRestAssured(RestUtil.MethodType.GET,"https://jokes.p.rapidapi.com/jod?category="+myCategory,myHeaders,200);
            if (actualCategoryResponse!=null){
                responseId = RestUtil.getKeyValueFromRESTAssuredResponse(actualCategoryResponse,ContentType.JSON,"contents.jokes[0].joke.id");
                description = RestUtil.getKeyValueFromRESTAssuredResponse(actualCategoryResponse,ContentType.JSON,"contents.jokes[0].description");
                title = RestUtil.getKeyValueFromRESTAssuredResponse(actualCategoryResponse,ContentType.JSON,"contents.jokes[0].joke.title");
                text = RestUtil.getKeyValueFromRESTAssuredResponse(actualCategoryResponse,ContentType.JSON,"contents.jokes[0].joke.text");
            }
            if (responseId!=null && myCategory!=null && description !=null && title !=null && text !=null){
                ReadWriteFileUtil.writeToFile(myFilePath,responseId,description,myCategory,title,text);
            }

        }
    }
}
