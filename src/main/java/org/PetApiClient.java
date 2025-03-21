package org;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetApiClient {
    private static final String BASE_URL = "https://petstore3.swagger.io/api/v3";

    public PetApiClient() {
        RestAssured.baseURI = BASE_URL;
    }

    public Response createPet(String petId, String name) {
        String body = String.format("{\"id\": %s, \"name\": \"%s\", \"status\": \"available\"}", petId, name);
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/pet");
    }

    public Response getPet(String petId) {
        return RestAssured.given()
                .get("/pet/{petId}", petId);
    }

    public Response updatePet(String petId, String name) {
        String body = String.format("{\"id\": %s, \"name\": \"%s\", \"status\": \"available\"}", petId, name);
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .put("/pet");
    }

    public Response deletePet(String petId) {
        return RestAssured.given()
                .delete("/pet/{petId}", petId);
    }
}