package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    @Step("Buscar todas as reservas.")
    public Response allBookings(){
        return given() //Notação do restassured,
                .header("Content-Type","application/json") //Adiciona cabeçalho
                .when()
                .get("booking"); //Adiciona o método
    }

    @Step("Buscar reserva especifica.")
    public Response specificBooking(){
        return given()
                .header("Accept", "application/json")
                .when()
                .get("booking/22");
    }
}
