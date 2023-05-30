package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BookingExtraction {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        response = given()
                .when()
                .get("/booking")
                .then().statusCode(200);
    }
        // extract all the bookingId
    @Test
    public void extractAllTheBookingIds(){
        List<Integer>bookingIds = response.extract().path("bookingid");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List Of Id is : " + bookingIds);
        System.out.println("------------------End of Test---------------------------");
    }
    // Extract the id of the 7th object
    @Test
    public void extractTheIdOf7thObject(){
        Integer id = response.extract().path("bookingid[6]");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("7th object Id is : " + id);
        System.out.println("------------------End of Test---------------------------");
    }


}
