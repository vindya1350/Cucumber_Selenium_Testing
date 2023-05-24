package com.jupitertoys.api;

import com.jupitertoys.api.okta.Authentication;
import com.jupitertoys.util.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseClient {
    String baseURI;
    Authentication authentication = new Authentication();

     public BaseClient() {
        baseURI = PropertyReader.getApiBaseUri();
        RestAssured.baseURI=baseURI;
    }
    
    // Method to make a GET request and return the response
    public Response get(String endpoint) {
        Response response = RestAssured.given()
        .header("Authorization", "Bearer "+ authentication.getToken())
        .header("Accept", "*/*").when()
        .get(endpoint)
        .then()
        .log().all(true)
        .extract()
        .response();
        return response;
    }
}
