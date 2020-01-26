package cl.prueba.testdesarrollo1.controller;

import cl.prueba.testdesarrollo1.model.ConsultaPersona;
import cl.prueba.testdesarrollo1.model.Persona;
import cl.prueba.testdesarrollo1.model.RespuestaPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
//@EnableAutoConfiguration
//@RequestMapping("/datos_persona")
public class TarjetaPersonaController {

    public TarjetaPersonaController() {
    }

    @RequestMapping(value = "/obtener_tarjeta", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    public RespuestaPersona ObtenerTarjeta(@RequestBody ConsultaPersona nuevaPersona) throws ParseException {
        RespuestaPersona respuestaPersona = new RespuestaPersona();
        try {
            Persona persona = new Persona();
            persona.cargarNombre(nuevaPersona.getNombre());
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            persona.setFechaNacimiento(dateFormat.parse(nuevaPersona.getFechaNacimiento()));
            respuestaPersona.cargarPersona(persona);
        } catch (ParseException e) {
            throw new ParseException("La fecha no es valida", 500);
        }
        return respuestaPersona;
    }

}
