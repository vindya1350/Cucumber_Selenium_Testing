package com.jupitertoys.api.okta;

import com.jupitertoys.util.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authentication {

    private static final String GET_TOKEN_URI = PropertyReader.getBaseUriForTokenGeneration();
    
    public String getToken() {
    Response response = RestAssured.given()
                .param("client_id", System.getenv("OKTA_BACKEND_CLIENTID"))
                .param("client_secret",System.getenv("OKTA_BACKEND_SECRET"))
                .param("scope", System.getenv("SCOPE"))
                .param("grant_type", System.getenv("GRANT_TYPE"))
            .post(GET_TOKEN_URI + "/oauth2/default/v1/token");
    if (response.getStatusCode() == 200) {
        String token = response.getBody().jsonPath().getString("access_token");
        return token;
    } else {
        throw new RuntimeException("Failed to get token. Status code: " + response.getStatusCode() + " Response: " + response.getBody().asString());
    }
}
}
