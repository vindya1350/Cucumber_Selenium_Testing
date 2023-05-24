package com.jupitertoys.api;

import java.util.List;

import com.google.gson.Gson;
import com.jupitertoys.testData.ToyDetails;

import io.restassured.response.Response;

public class ToyAPIEndpoint extends BaseClient{
    private static final String endPoint = "/toy"; 

    public List<ToyDetails> getAllToys(){
        Response response = get(endPoint);
        List<ToyDetails> toyDetails = response.getBody().jsonPath().getList("", ToyDetails.class);
        return toyDetails;
    }

    public ToyDetails getToy(String toyId){
        Response response = get(endPoint+"/"+toyId);
        Gson gson = new Gson();
        ToyDetails toyDetail = gson.fromJson(response.getBody().asString(), ToyDetails.class);
        return toyDetail;
    }
}
