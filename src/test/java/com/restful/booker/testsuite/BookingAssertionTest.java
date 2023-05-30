package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookingAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking")
                .then().statusCode(200);
    }

    // verify bookingid = 2128 has lastname Brown
   /* @Test
    public void getAllBookingIds() {
        response.body("booking.findAll{it.bookingid== 2128}.lastname",equalTo("Brown"));
    }*/


}
