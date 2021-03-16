package br.com.restassuredapitesting.tests.ping.tests;

import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.ping.HealthCheck.HealthCheck;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class HealthCheckTest extends BaseTest {
    HealthCheck healthCheck = new HealthCheck();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verifica API Online")
    public void testarApiOnline() throws Exception {
        healthCheck.ApiOnline().then()
                .statusCode(201); //Verifica o status code
    }
}
