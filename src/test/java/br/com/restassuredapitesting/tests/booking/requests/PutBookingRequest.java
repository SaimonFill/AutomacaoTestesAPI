package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {

    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Step("Alterar uma reserva com token")
    public Response alterarUmaReservaComToken(int id, JSONObject payload){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", postAuthRequest.getToken())
                .when()
                .body(payload.toString())
                .put("booking/" + id);
    }

    @Step("Deletar ema reserva")
    public Response deleteBooking(){
        return given()
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Cookie", "token=abc123")
                .header("Content-Type", "application/json")
                .when()
                .delete("booking/19");
    }
}
