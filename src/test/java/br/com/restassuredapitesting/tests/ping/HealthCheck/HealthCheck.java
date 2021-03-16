package br.com.restassuredapitesting.tests.ping.HealthCheck;

import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;

public class HealthCheck extends BaseTest {

    @Step("Verificar API Online")

    public Response ApiOnline(){
        return given()
                .when()
                .get("/ping");
    }
}
