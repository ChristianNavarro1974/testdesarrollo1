package cl.prueba.testdesarrollo1;

import cl.prueba.testdesarrollo1.controller.TarjetaPersonaController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

@RunWith(SpringRunner.class)
@RestClientTest(TarjetaPersonaController.class)
class Testdesarrollo1ApplicationTests {

    @Autowired
    private TarjetaPersonaController service;

    @Autowired
    private MockRestServiceServer server;


    @Test
    public void FormularioCorrectoTest() {

    }

}
