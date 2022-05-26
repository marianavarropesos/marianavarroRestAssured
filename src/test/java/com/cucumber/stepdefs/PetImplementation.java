package com.cucumber.stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.io.Serializable;

public class PetImplementation implements Serializable {
    private Response putPets = null;
    private Response postPets = null;
    private Response deletePets = null;


    @Before
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        //Url a la que accedemos
    }


    //getPet

    @Given("the following get request that bring us the pet by id")
    public Response getPets() {
        //Introducimos el código de la mascota
        Response responseGetPets = given().log().all().get("/55555");

        return responseGetPets;
    }

    @And("the response is 200")
    public void validateResponse() {
        assertTrue("The response is not 200", getPets().statusCode() == 200);
    }


    //postPet

    @Given("the following post request to add pets")
    public void PostPets() {

        File fileBodyRequest = new File("src/main/resources/bodyRequest.json");
        postPets = given().contentType(ContentType.JSON).body(fileBodyRequest).post();

    }


    @Then("the body response contains the {string} of the new pet")
    public void validateResponsePostValueName(String valueName) {
        JsonPath jsonPathUsers = new JsonPath(postPets.body().asString());
        String jsonUsers = jsonPathUsers.getString("name");
        assertEquals("The value of the name is not correct", valueName, jsonUsers);

    }



}
