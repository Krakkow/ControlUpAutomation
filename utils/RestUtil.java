package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtil {

    String body;
    Headers headers;
    String url;
    static Response actualResponse;
    int expStatusCode;
    String responseId;

    public enum MethodType{
        POST,
        GET,
        PUT,
        DELETE
    }

    /**
     * Executing the Rest Request
     * @param myMethod - enum of Method type - i.e. MethodType.GET
     * @param url - String of the Complete URL(base URI + parameters you should pass the complete the request)
     * @param myHeaders - Should be pass as a List object. Can be null.
     * @param expStatusCode - for example 200
     * @return Response object
     */
    public static Response executeGetRestAssured(MethodType myMethod, String url, Headers myHeaders,int expStatusCode){
        RequestSpecification myReqeuest;

        myReqeuest = RestAssured.given(); //no authentication needed

        if (myHeaders!=null)
            myReqeuest.headers(myHeaders);

        //Execute Get Request
        actualResponse = myReqeuest.get(url);

        if (actualResponse.getStatusCode()==expStatusCode){
            System.out.println("Request Passed! Status code is: " + expStatusCode + ". as expected.");
            return actualResponse;
        }else{
            System.out.println("Request Failed! Status code is:" + expStatusCode + ". NOT as expected.");
            return null;
        }

    }

    /**
     * Getting Value according to Key from the response body
     * @param myResponse - A Response object is being created when you use the executeGetRestAssured()
     * @param contentType - i.e. application.json
     * @param expKeyName - Pass as a string the path to the object within the json object - i.e. "current.temp_c"
     * @return String value
     */
    public static String getKeyValueFromRESTAssuredResponse(Response myResponse, ContentType contentType, String expKeyName){
        if (myResponse!=null){
            return myResponse.body().jsonPath().getString(expKeyName);
        }else{
            System.out.println("Unable to Get Requested Value. Please Check");
            return null;
        }
    }

}
