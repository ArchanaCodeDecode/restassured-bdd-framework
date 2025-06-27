package com.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtils {

    static {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    public static Response postRequest(String endpoint, Object payload) {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .body(payload)
                .post(endpoint);
    }
}
