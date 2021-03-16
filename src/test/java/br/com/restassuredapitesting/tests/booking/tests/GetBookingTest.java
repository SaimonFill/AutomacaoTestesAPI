package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.Contract;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

@Feature("Reservas")
public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    //Primeiro teste
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs das Reservas")
    public void validarIdsDasReservas() throws Exception {
        getBookingRequest.allBookings().then()
                .statusCode(200) //Verifica o status code
                .time(lessThan(3L), TimeUnit.SECONDS) //O tempo de resposta deve ser menor que 2 segundos
                .body("size()", greaterThan(0)); // O tamanho do corpo deve ser maior do que zero
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno da lista de reservas")
    public void garantirContratoListaReserva() throws Exception{
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .assertThat()
                //Está fazendo matches com o booking.json e passando o arquivo para o body
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno de uma reserva específica")
    public void garantirContratoReservaEspecifica() throws Exception{
        getBookingRequest.specificBooking().then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookingSpecific"))));
    }
}
